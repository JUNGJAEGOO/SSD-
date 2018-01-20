package back2150;

import java.util.*;

public class Main {
	static int V,E;
	static ArrayList<Integer> adj[];
	static ArrayList<Integer> rev[];
	static ArrayList<Integer> res[];
	static Stack<Integer> tmpst;
	static boolean visit[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		V = in.nextInt();
		E = in.nextInt();
		adj = new ArrayList[V+1];
		rev = new ArrayList[V+1];
		visit = new boolean[V+1];
		res = new ArrayList[V+1];
		for ( int i = 1 ; i<= V ; i++) {
			adj[i] = new ArrayList<>();
			rev[i] = new ArrayList<>();
			res[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < E ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			adj[from].add(to);
			rev[to].add(from);
		}
		
		tmpst = new Stack<Integer>();
		for ( int i = 1 ; i<= V; i++) {
			DFS(i);
			//System.out.println(tmpst);
		}
		
		
		Arrays.fill(visit, false);
		while ( !tmpst.isEmpty()) {
			int now = tmpst.pop();
			revDFS(now,now);
			//System.out.println(res[now]);
		}
		int ans = 0;
		for ( int i = 1 ; i<= V ; i++) {
			Collections.sort(res[i]);
			if ( res[i].size() != 0) {
				ans++;
			}
		}
		ArrayList<Integer> order = new ArrayList<>();
		ArrayList<Integer> first = new ArrayList<>();
		for ( int i = 1 ; i<= V ; i++) {
			if ( res[i].size() != 0) {
				first.add(res[i].get(0));
			}
			//System.out.println(res[i]);
		}
		Collections.sort(first);
		for ( int i = 0 ; i< first.size() ; i++) {
			for ( int j = 1 ; j <= V ; j++) {
				if ( res[j].contains(first.get(i))) {
					order.add(j);
				}
			}
			//System.out.println(res[i]);
		}
		System.out.println(ans);
		for ( int i = 0 ; i < order.size() ; i++) {
			for ( int j = 0 ; j < res[order.get(i)].size() ; j++) {
				System.out.print(res[order.get(i)].get(j)+" ");
			}
			System.out.println(-1);
		}
		
	}
	
	public static void DFS(int start) {
		//System.out.println(start);
		if ( visit[start] == true) {
			return;
		}
		visit[start] = true;
		for ( int i = 0 ; i < adj[start].size() ; i++) {
			if ( visit[adj[start].get(i)] == false ) {
				DFS(adj[start].get(i));
			}
		}
		//System.out.println(start+"====");
		tmpst.add(start);
	}
	
	public static void revDFS(int start,int real) {
		if ( visit[start] == true) {
			return;
		}
		visit[start] = true;
		for ( int i = 0 ; i < rev[start].size() ; i++) {
			if ( visit[rev[start].get(i)] == false ) {
				revDFS(rev[start].get(i),real);
			}
		}
		res[real].add(start);
	}
}
