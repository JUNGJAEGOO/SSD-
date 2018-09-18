package back15938;

import java.io.*;
import java.util.*;

public class Main {
	
	static int Xs,Ys;
	static int T,N;
	static int Xh,Yh;
	static int mat[][] = new int[500][500];
	static int dp[][][];
	static int xx[] = {0,1,0,-1};
	static int yy[] = {1,0,-1,0};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Xs = Integer.parseInt(st.nextToken());
		Ys = Integer.parseInt(st.nextToken());
		
		T = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		Xh = Integer.parseInt(st.nextToken());
		Yh = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(br.readLine());
		for ( int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if ( Math.abs(x - Xs) + Math.abs(y - Ys) <= 200) {
				mat[250+(x-Xs)][250+(y-Ys)] = 1;
			}
			
		}
		
		dp = new int[480][480][201];
		for (int i = 0 ; i <480 ; i++) {
			for ( int j = 0 ; j < 480 ; j++) {
				for (int k = 0 ; k < 201 ; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
	
		
		System.out.print(func(250,250,0));
		
		
	}
	
	public static int func(int x,int y,int time) {
		
		if ( time > T ) {
			return 0;
		}
		
		if ( x == Xh+(250-Xs) && y == Yh+(250-Ys) ) {
			return 1;
		}
		
		int ret = dp[x][y][time];
		if (ret != -1) {
			return ret;
		}
		ret = 0;
				
		for ( int i = 0 ; i < 4 ; i++) {
			int nx = x + xx[i];
			int ny = y + yy[i];
			if ( nx >= 0 && nx < 500 && ny >= 0 && ny < 500) {
				if ( mat[nx][ny] == 0) {
					ret += ( func(nx,ny,time+1) ) ;
				}
			}
		}
				
		return dp[x][y][time] = (int) (ret % (1e9+7));
	}
}
