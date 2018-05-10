package back11438;

import java.util.*;

public class Main {
	static ArrayList<Integer> adj[];
	static int parent[][];
	static int depth[];
	static boolean visit[];
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		adj  = new ArrayList[N+1];
		for ( int i = 0 ; i < N+1 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < N - 1; i++) {
			
			int from = in.nextInt();
			int to = in.nextInt();
			adj[from].add(to);
			adj[to].add(from);
			
		}
		
		visit = new boolean[N+1];
		depth = new int[N+1];
		parent = new int[N+1][21];
		DFS(1,0);
		
		for ( int i = 1 ; i < 21 ; i++) {
			for ( int j = 1 ; j <= N ; j++) {
				parent[j][i] = parent[parent[j][i-1]][i-1];
			}
		}
		
		int M = in.nextInt();
		while ( M > 0 ) {
			
			int x = in.nextInt();
			int y = in.nextInt();
			System.out.println(lca(x,y));
			
			M--;
		}
		
	}
	
	public static int lca(int a,int b) {
		if ( depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b  = tmp;
		}
		
		for ( int i = depth[b] ; i >= 0 ; i--) {
			if ( depth[b] - depth[a] >= ( 1 << i ) ) {
				b = parent[b][i];
			}
		}

		
		if ( b == a) {
			return b;
		}
		
		for ( int i = 20 ; i >= 0 ; i--) {
			if ( parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		
		return parent[a][0];
		
	}
	
	public static void DFS(int now,int d) {
		visit[now] = true;
		depth[now] = d;
		
		for ( int i = 0 ; i < adj[now].size() ; i++) {
			
			int next = adj[now].get(i);
			if ( visit[next]) {
				continue;
			}
			
			parent[next][0] = now;
			DFS(next,d+1);
			
		}
		
	}
}
