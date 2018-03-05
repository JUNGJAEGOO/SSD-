package back1506;

import java.util.*;

// 강한 연결 요소

public class Main {
	static boolean visit[];
	static Stack<Integer> st;
	static int mat[][];
	static int N;
	static ArrayList<Integer> res[];
	static ArrayList<Integer> rev[];
	static ArrayList<Integer> adj[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = Integer.parseInt(in.nextLine());
		String input[] = in.nextLine().split(" ");
		int cost[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			cost[i] = Integer.parseInt(input[i]);
		}
	
		mat = new int[N][N];
		res = new ArrayList[N+1];
		rev = new ArrayList[N+1];
		adj = new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++) {
			res[i] = new ArrayList<>();
			rev[i] = new ArrayList<>();
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < N ; i++) {
			char[] tmp = in.nextLine().toCharArray();
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = Integer.parseInt(String.valueOf(tmp[j]));
				if ( mat[i][j] == 1) {
					rev[j+1].add(i+1);
					adj[i+1].add(j+1);
				}
			}
		}
		
		st = new Stack<>();
		visit = new boolean[N+1];
		for ( int i = 1 ; i<= N ; i++) {
			DFS(i);
		}
		//System.out.println(st);
		visit = new boolean[N+1];
		while ( !st.isEmpty() ) {
			
			int tmp = st.pop();
			if ( visit[tmp] == false) {
				revDFS(tmp,tmp);
			}
			
		}
		
		int ans = 0;
		for (int i = 1 ; i<= N ; i++) {
			if ( res[i].size() != 0) {
				int min = 100000000;
				for (int j = 0 ; j < res[i].size() ; j++) {
					min = Math.min(min, cost[res[i].get(j)-1]);
				}
				ans += min;
			}
			
		}
		System.out.println(ans);
	}
	
	public static void DFS(int now) {
		if ( visit[now] == true) {
			return;
		}
		visit[now] = true;
		
		for (int i = 1 ; i<= N ; i++) {
			if ( visit[i] == false) {
				if ( adj[now].contains(i)) {
					DFS(i);
				}
			}
		}
		
		st.add(now);
	}
	
	public static void revDFS(int now,int real) {
		if ( visit[now] == true) {
			return;
		}
		visit[now] = true;
		
		for (int i = 1 ; i<= N ; i++) {
			if ( visit[i] == false && rev[now].contains(i) ) {
				revDFS(i,real);
			}
		}
		
		res[real].add(now);
	}
}
