package back2228;

import java.util.*;
import java.io.*;

public class Main2 {
	static int arr[];
	static int N,M;
	static int dp[][][];
	static int cache[][];
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cache = new int[N+1][N+1];
		arr = new int[N+1];
		for ( int i = 1 ; i <= N ; i++ ) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for  (int i = 1 ; i<= N ; i++) {
			
			for ( int j = i ; j<= N ; j++) {
				if ( i == j) {
					cache[i][i] = arr[i];
				}else {
					cache[i][j] = cache[i][j-1] + arr[j];
				}
				
			}
		}
		
		dp = new int[N+1][N+1][M+1];
		for ( int i = 0 ; i < N+1 ; i++) {
			for ( int j = 0 ; j < N+1 ; j++) {
				for ( int k = 0 ; k < M+1 ; k++) {
					dp[i][j][k] = -1;
				}
				
			}
		}
		
		System.out.print(func(0,0,M));
	}
	
	public static int func(int from,int to,int go) {
		
		//System.out.println(from+" "+to+" "+go);
		
		if ( go == 0) {
			return 0;
		}
		
		int ret = dp[from][to][go];
		if ( ret != -1) {
			return ret;
		}
		ret = -1000000;
		
		if ( from == 0 && to == 0) {
			for  (int i = 1 ; i <= N ; i++) {
				for ( int j = i ; j <= N ; j++) {
					ret = Math.max(ret, cache[i][j]+func(i,j,go-1));
				}
			}
		}
		else {
			for (int i = to+2 ; i <= N ; i++) {
				for ( int j = i ; j <= N ; j++) {
					ret = Math.max(ret, cache[i][j]+func(i,j,go-1));
				}
				
			}
		}
		
		
		
		return dp[from][to][go] = ret;
	}
}
