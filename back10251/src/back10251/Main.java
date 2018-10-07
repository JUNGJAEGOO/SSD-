package back10251;

import java.io.*;
import java.util.*;

public class Main {
	static int M,N,L,G;
	static int right[][];
	static int down[][];
	static int cost[][][][];
	static int ans;
	static final int inf = (int)1e8;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		right = new int[105][105];
		down = new int[105][105];
		cost = new int[105][105][120][2];
		
		for ( int testcase = 0 ; testcase < T ; testcase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			
			
			
			for ( int i = 0 ; i < M ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for ( int j = 0; j < N-1 ; j++) {
					right[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			
			for ( int i = 0 ; i < M-1 ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for ( int j = 0 ; j < N ; j++) {
					down[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for ( int i = 0 ; i < 105 ; i++) {
				for ( int j = 0 ; j < 105 ; j++) {
					for ( int k = 0 ; k < 120 ; k++) {
						cost[i][j][k][0] = inf;
						cost[i][j][k][1] = inf;
					}
				}
			}
			
			cost[0][0][0][0] = 0;
			cost[0][0][0][1] = 0;
			
			for ( int i = 0 ; i < M ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					
					for ( int k = 0 ; k < 119 ; k++) {
					
						if ( i + 1 < M ) {
							cost[i+1][j][k][0] = Math.min(cost[i+1][j][k][0], down[i][j] + cost[i][j][k][0]);
							cost[i+1][j][k+1][0] = Math.min(cost[i+1][j][k+1][0], down[i][j] + cost[i][j][k][1]);
							
						}
						
						if ( j + 1 < N) {
							cost[i][j+1][k][1] = Math.min(cost[i][j+1][k][1], right[i][j] + cost[i][j][k][1]);
							cost[i][j+1][k+1][1] = Math.min(cost[i][j+1][k+1][1], right[i][j] + cost[i][j][k][0]);
							
						}
					
						
					}
					
				}
			}
			
			
			int ans = inf;
			
			for ( int i = 0 ; i < 120 ; i++) {
				
				if ( cost[M-1][N-1][i][0] <= G ) {
					ans = Math.min(ans , i);
				}
				if ( cost[M-1][N-1][i][1] <= G ) {
					ans = Math.min(ans, i);
				}
				
			}
			
			sb.append( ans == inf ? -1 +"\n" : (M-1)*L + (N-1)*L + ans +"\n");
			
		}
		System.out.print(sb);
		
	}
	
	
}
