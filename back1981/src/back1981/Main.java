package back1981;

import java.io.*;
import java.util.*;

public class Main {
	static int mat[][];
	static int dp[][];
	static boolean visit[][];
	static int inf = 1000000000;
	static int X[] = {0,0,-1,1};
	static int Y[] = {-1,1,0,0,};
	static int N;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		mat = new int[N][N];
		
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			for( int j = 0 ; j < N ; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<node> q = new LinkedList<>();
		
		int left = 0;
		int right = 200;
		while ( left <= right) {
			
			int mid = (left+right) >> 1;
			
			dp = new int[N][N];
			
			for ( int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					dp[i][j] = inf;
				}
			}
			
			q.add(new node(1,1,mat[0][0],mat[0][0]));
			
			boolean pass = false;
			while ( !q.isEmpty() ) {
				
				node now = q.poll();
				int x = now.x;
				int y = now.y;
				int max = now.max;
				int min = now.min;
				

				for ( int i = 0 ; i < 4 ; i++) {
					int nx = x + X[i];
					int ny = y + Y[i];
					
					if ( nx >= 0 && ny >= 0 && nx < N && ny < N) {
						int nmin = Math.min(min, mat[nx][ny]);
						int nmax = Math.max(max, mat[ny][ny]);
						if ( dp[nx][ny] > nmax - nmin) {
							if ( nmax - nmin <= mid) {
								dp[nx][ny] = nmax - nmin;
								q.add(new node(nx,ny,nmax,nmin));
							}
						}
					}
				}
				
				
			}
			
			/*for ( int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					System.out.print(dp[i][j]+" ");
				}System.out.println();
			}System.out.println();*/
			
			if ( dp[N-1][N-1] != inf) {
				pass = true;
			}
			
			System.out.println(left+" "+right+" "+mid+" "+pass);
			
			if ( pass ) {
				right = mid -1;
			}else {
				left = mid + 1;
			}
			
		}
		
		System.out.print(left);
		
		
	}
	

	
	public static class node{
		int x,y;
		int min;
		int max;
		node (int x,int y,int max,int min){
			this.x= x;
			this.y= y;
			this.max = max;
			this.min = min;
			
		}
	}
}
