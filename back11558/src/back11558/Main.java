package back11558;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static ArrayList<Integer> adj[];
	static int ans;
	static int N;
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for( int test = 0 ; test < T ; test++) {
			
			N = Integer.parseInt(br.readLine());
			adj = new ArrayList[N+1];
			for ( int i = 0 ; i < N+1 ; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for ( int i = 1 ; i <= N ; i++) {
				adj[i].add(Integer.parseInt(br.readLine()));
			}
			
			ans = Integer.MAX_VALUE;
			visit = new boolean[N+1];
			DFS(1,0);
			if ( ans == Integer.MAX_VALUE) {
				System.out.println(0);
			}else {
				System.out.println(ans);				
			}
			
		}
		
	}
	
	static void DFS(int x,int cnt) {
		
		if ( cnt > ans) {
			return;
		}
		
		if ( x == N) {
			ans = Math.min(ans, cnt);
		}
		visit[x] = true;
		
		for ( int i = 0 ; i < adj[x].size() ; i++) {
			
			if ( visit[adj[x].get(i)] == false) {
				DFS(adj[x].get(i),cnt+1);
			}
			
		}
		
		visit[x] = false;
	}
}
