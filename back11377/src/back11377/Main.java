package back11377;

import java.io.*;
import java.util.*;
public class Main {
	static ArrayList<Integer>[] adj ;
	static int A[];
	static int B[];
	static boolean visit[];
	static int res = 0;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		A = new int[1002];
		B = new int[1002];
		adj = new ArrayList[1002];
		visit = new boolean[1002];
		
		for ( int i = 1 ; i <= 1001 ; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0 ; j < num ; j++) {
				int to = Integer.parseInt(st.nextToken());
				adj[i].add(to);
			}
		}
		
		for (int i = 1 ; i <=5 ; i++) {

			if ( A[i] == 0) {
				if ( DFS(i) ) { res++; }
			}
			for (int j = 1 ; j <= N ; j++) {
				visit[j] = false;
			}
		}
		
		int cnt = 0;
		for (int i = 1 ; i <= N ; i++) {
			
			if ( DFS(i) ) { res++; cnt++; }
			if ( cnt == K) { break;}
			for (int j = 1 ; j <= N ; j++) {
				visit[j] = false;
			}
		}
		
		System.out.println(res);
	}
	
	public static boolean DFS(int start) {
		//if ( visit[start] == true) { return false;}
		visit[start] = true;
		
		for ( int i = 0 ; i < adj[start].size() ; i++) {
			int end = adj[start].get(i);
			if ( B[end] == 0 ) {
				B[end] = start;
				A[start] = end;
				return true;
			}else if (visit[B[end]] == false && DFS(B[end])) {
				B[end] = start;
				A[start] = end;
				return true;
			}
				
		}
		
		return false;
	}
}
