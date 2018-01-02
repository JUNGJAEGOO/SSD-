package back11378;

import java.util.*;

public class Main {
	static int A[];
	static int B[];
	static boolean visit[];
	static ArrayList<Integer> adj[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner( System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		A = new int[1001];
		B = new int[M+1];
		visit = new boolean[1001];
		adj = new ArrayList[1001];
		for ( int i = 1 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		Arrays.fill(A,-1);
		Arrays.fill(B,-1);
		
		for (int i = 1 ; i <= N ; i++) {
			int works = in.nextInt();
			for ( int j = 1 ; j<= works ; j++) {
				adj[i].add(in.nextInt());
			}
		}
		
		int ans = 0;
		for (int i = 1 ; i<= N ; i++) {
			for (int j = 1 ; j <= N ; j++) {
				visit[j] = false;
			}
			if ( DFS(i) == true ) {
				ans++;
			}
			
		}
		
		while ( true ) {
			boolean matched = false;
			for (int i = 1 ; i<= N && K>0 ; i++) {
				for (int j = 1 ; j <= N ; j++) {
					visit[j] = false;
				}
				if ( DFS(i) == true ) {
					ans++;
					K--;
					matched = true;
				}
			}
			
			if ( matched == false) {
				break;
			}
			
		}
		
		System.out.println(ans);
		/*for (int i = 1 ; i <= N ; i++) {
			System.out.print(A[i]+" ");
		}System.out.println();
		for (int i = 1 ; i <= N ; i++) {
			System.out.print(B[i]+" ");
		}*/
	}
	
	public static boolean DFS(int start) {
		if ( visit[start] == true ) {
			return false;
		}
		visit[start] = true;
		
		for (int i = 0 ; i < adj[start].size() ; i++) {
			int end = adj[start].get(i);
			if ( B[end] == -1 || (visit[B[end]] == false && DFS(B[end])) ) {
				A[start] = end;
				B[end] =start;
				return true;
			}
		}
		
		return false;
	}
	
}
