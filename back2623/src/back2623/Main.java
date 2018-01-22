package back2623;

import java.util.*;

public class Main {
	static int N,M;
	static ArrayList<Integer> adj[];
	static ArrayList<Integer> rev[];
	static boolean visit[];
	static ArrayList<Integer> res = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		adj = new ArrayList[N+1];
		rev = new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for ( int i = 1 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
			rev[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < M ; i++) {
			int num = in.nextInt();
			int from = in.nextInt();
			for ( int j = 0 ; j < num-1 ; j++) {
				int to = in.nextInt();
				adj[from].add(to);
				rev[to].add(from);
				from = to;
			}
		}
		
		BFS();
	}
	
	public static void BFS() {
		Queue<Integer> q= new LinkedList<>();
		for  (int i = 1 ; i <= N ; i++) {
			if ( rev[i].size() == 0) {
				q.add(i);
				visit[i] = true;
				break;
			}
		}
		
		while ( !q.isEmpty() ) {
			int now = q.poll();
			res.add(now);
			
			for  (int i = 0 ; i < adj[now].size() ; i++) {
				int next= adj[now].get(i);
				for  (int j = 0 ; j < rev[next].size() ; j++) {
					if ( rev[next].get(j) == now) {
						rev[next].remove(j);
						break;
					}
				}
			}
			
			for  (int i = 1 ; i <= N ; i++) {
				if ( rev[i].size() == 0 && visit[i] == false) {
					q.add(i);
					visit[i] = true;
					break;
				}
			}
			
		}
		
		if ( res.size() != N ) {
			System.out.println(0);
		}else {
			StringBuilder sb = new StringBuilder();
			for ( int i = 0 ; i < res.size() ; i++) {
				sb.append(res.get(i)+"\n");
			}
			System.out.print(sb);
		}
	}
}
