package back1014;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> adj[];
	static int A[],B[];
	static char mat[][];
	static boolean visit[];
	public static void main(String args[]) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while ( T>0) {
			StringTokenizer st = new StringTokenizer (br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			mat = new char[N][M];
			for (int i = 0 ; i < N ; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0 ; j < M ; j++) {
					mat[i][j] = tmp[j];
				}
			}
			adj = new ArrayList[N*M];
			for (int i = 0 ; i < N*M ; i++) {
				adj[i] = new ArrayList<>();
			}
			visit = new boolean[N*M];
			A = new int[N*M];
			B = new int[N*M];
			int sum = 0;
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < M ; j++) {
					if ( mat[i][j] == '.') {
						sum++;
					}
					if ( j%2 == 1) {
						int now = j%M + i*M;
						if ( i-1 >= 0 && j-1 >=0) {
							if ( mat[i-1][j-1] == '.') {
								adj[now].add((i-1)*M+(j-1)%M);
							}
						}
						if ( i-1 >= 0 && j+1 < M) {
							if ( mat[i-1][j+1] == '.') {
								adj[now].add((i-1)*M+(j+1)%M);
							}
						}
						if ( j-1 >= 0 ) {
							if ( mat[i][j-1] == '.') {
								adj[now].add((i)*M+(j-1)%M);
							}
						}
						if ( j+1 < M) {
							if ( mat[i][j+1] == '.') {
								adj[now].add((i)*M+(j+1)%M);
							}
						}
						
					}
				}
			}
			Arrays.fill(A,-1);
			Arrays.fill(B,-1);
			int ans = 0;
			for (int i = 0 ; i < N*M ; i++) {
				Arrays.fill(visit, false);
				if ( DFS(i) ) {
					ans++;
				}
			}
			
			System.out.println(sum-ans);
			
			T--;
		}
	}
	
	public static boolean DFS(int start) {
		if ( visit[start]) {
			return false;
		}
		visit[start] = true;
		
		for (int i = 0 ; i < adj[start].size() ; i++) {
			int end = adj[start].get(i);
			if ( B[end] == -1 || DFS(B[end]) ) {
				A[start] = end;
				B[end] = start;
				return true;
			}
		}
		
		return false;
	}
}
