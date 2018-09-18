package back2188;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N,M;
	static int B[];
	static ArrayList<Integer> adj[];
	static boolean visit[];
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = new int[201];
		Arrays.fill(B, -1);
		adj = new ArrayList[201];
		for ( int i = 0 ; i < 201 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		
		for ( int i = 1 ; i <= N ; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			int want = Integer.parseInt(st.nextToken());
			for ( int j = 0 ; j < want ; j++) {
				int to = Integer.parseInt(st.nextToken());
				adj[i].add(to);
			}
			
		}
		
		int ans = 0;
		for (int i = 1; i <= N ; i++) {
			visit = new boolean[201];
			if ( dfs(i) == true ) {
				ans++;
			}
		}
		
		System.out.print(ans);
	
	}
	
	public static boolean dfs(int now) {
		if (visit[now]) {
			return false;
		}
		visit[now] = true;
		
		
		for ( int i = 0 ; i < adj[now].size() ; i++) {
			int next = adj[now].get(i);
			if ( B[next] == -1 || dfs(B[next]) ) {
				B[next] = now;
				
				return true;
			}
		}
		
		return false;
 	}
}
