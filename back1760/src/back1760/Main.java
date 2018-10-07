package back1760;

import java.util.*;
import java.io.*;

public class Main  {
	static int M,N;
	static int mat[][];
	static boolean visit[];
	static ArrayList<Integer> adj[];
	static int B[];
	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		mat = new int[M][N];
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		adj = new ArrayList[10001];
		for ( int i = 0 ; i < 10001 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		int num1 = 1 , num2 = 1;
		int mat1[][] = new int[M][N];
		int mat2[][] = new int[M][N];
		
		for ( int i = 0 ; i< M ; i++) {
			for (int j = 0 ; j <N ; j++) {
				if ( mat[i][j] == 2) {
					num1++;
				}else {
					mat1[i][j] = num1;
				}
			}
			num1++;
		}
		
		for ( int i = 0 ; i< N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				if ( mat[j][i] == 2) {
					num2++;
				}else {
					mat2[j][i] = num2;
				}
			}
			num2++;
		}
		
		for ( int i = 0 ; i < M ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				if ( mat1[i][j] != 0 && mat[i][j] == 0 ) {
					adj[mat1[i][j]].add(mat2[i][j]);
				}
			}
		}
		

		int ans = 0;
		visit = new boolean[10001];
		B = new int[10001];
		Arrays.fill(B, -1);

		for ( int i = 1 ; i <= 10000 ; i++) {
			Arrays.fill(visit, false);
			if ( DFS(i) ) {
				ans++;
			}
			
		}
		
		System.out.println(ans);
	}
	
	
	public static boolean DFS(int now) {
		if ( visit[now] ) {
			return false;
		}
		visit[now] = true;
		
		for ( int i = 0 ; i < adj[now].size(); i++) {
			int nx = adj[now].get(i);
			if ( B[nx] == -1 || DFS(B[nx]) ) {
				B[nx] = now;
				return true;
			}
			
		}
		
		return false;
		
	}
	

}
