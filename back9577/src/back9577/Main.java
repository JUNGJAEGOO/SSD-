package back9577;

import java.io.*;
import java.util.*;

public class Main {
	static int A[];
	static int B[];
	static boolean visit[];
	static ArrayList<Integer> adj[];
	static int n;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		lop:
		for ( int test = 0 ; test < T ; test++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			visit = new boolean[101];
			A = new int[101];
			B = new int[101];
			Arrays.fill(A, -1);
			Arrays.fill(B, -1);
			adj = new ArrayList[101];
			for ( int i = 0 ; i < 101 ; i++) {
				adj[i] = new ArrayList<>();
			}

			for ( int i = 0 ; i < m ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int limit = Integer.parseInt(st.nextToken());
				for ( int j = 0 ; j < limit ; j++ ) {
					int go = Integer.parseInt(st.nextToken());
					for ( int k = start ; k< end ; k++) {
						adj[k].add(go);
					}
				}
			}

			System.out.println(match());
			
		}
	}
	
	public static int match() {
		int ans = 0;
		for ( int i = 0 ; i <= 100 ; i++) {
			visit = new boolean[101];
			if( dfs(i) ) {
				ans++;
			}
			if ( ans == n) {
				return i+1;
			}
		}
		
		return -1;
		
	}
	
	public static boolean dfs(int idx) {
		
		if ( visit[idx] ) {
			return false;
		}
		visit[idx] =  true;
		
		for ( int i = 0 ; i < adj[idx].size(); i++) {
			int next = adj[idx].get(i);
			if ( B[next] == -1 || dfs(B[next])) {
				A[idx] = next;
				B[next] = idx;
				return true;
			}
		}
		
		return false;
	}
}
