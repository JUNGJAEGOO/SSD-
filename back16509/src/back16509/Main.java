package back16509;

import java.io.*;
import java.util.*;

public class Main {
	static final int inf = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R1 = Integer.parseInt(st.nextToken());
		int C1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int R2 = Integer.parseInt(st.nextToken());
		int C2 = Integer.parseInt(st.nextToken());
		
		int dp[][] = new int[10][9];
		int mat[][] = new int[10][9];
		mat[R1][C1] = 1;
		mat[R2][C2] = 2;
		for ( int i = 0 ; i < 10 ; i++) {
			for ( int j = 0 ; j <  9 ; j++) {
				dp[i][j] = inf;
			}
		}
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(R1,C1,0));
		dp[R1][C1] = 0;
		
		while( !q.isEmpty() ) {
			
			node now = q.poll();
			int X = now.x;
			int Y = now.y;
			int cost = now.cost;
			
			if ( dp[X][Y] < cost) {
				continue;
			}
			
			if ( X - 1 >= 0 && mat[X-1][Y] != 2) {
				
				if ( X - 2 >= 0 && Y - 1 >= 0 && mat[X-2][Y-1] != 2) {
					if ( X - 3 >= 0 && Y - 2 >= 0 ) {
						if ( dp[X-3][Y-2] > cost + 1 ) {
							dp[X-3][Y-2] = cost + 1;
							q.add(new node(X-3,Y-2,cost+1));
						}
					}
				}
				if ( X - 2 >= 0 && Y + 1 < 9 && mat[X-2][Y+1] != 2) {
					if ( X - 3 >= 0 && Y + 2 < 9 ) {
						if ( dp[X-3][Y+2] > cost + 1 ) {
							dp[X-3][Y+2] = cost + 1;
							q.add(new node(X-3,Y+2,cost+1));
						}
					}
				}
				
			}
			
			if ( X + 1 < 10 && mat[X+1][Y] != 2) {
				
				if ( X + 2 < 10 && Y - 1 >= 0 && mat[X+2][Y-1] != 2) {
					if ( X + 3 < 10 && Y - 2 >= 0 ) {
						if ( dp[X+3][Y-2] > cost + 1 ) {
							dp[X+3][Y-2] = cost + 1;
							q.add(new node(X+3,Y-2,cost+1));
						}
					}
				}
				if ( X + 2 < 10 && Y + 1 < 9 && mat[X+2][Y+1] != 2) {
					if ( X + 3 < 10 && Y + 2 < 9 ) {
						if ( dp[X+3][Y+2] > cost + 1 ) {
							dp[X+3][Y+2] = cost + 1;
							q.add(new node(X+3,Y+2,cost+1));
						}
					}
				}
				
			}
			
			if ( Y - 1 >= 0 && mat[X][Y-1] != 2) {
				
				if ( Y - 2 >= 0 && X - 1 >= 0 && mat[X-1][Y-2] != 2) {
					if ( Y - 3 >= 0 && X - 2 >= 0 ) {
						if ( dp[X-2][Y-3] > cost + 1) {
							dp[X-2][Y-3] = cost + 1;
							q.add(new node(X-2,Y-3,cost+1));
						}
					}
				}
				
				if ( Y - 2 >= 0 && X + 1 < 10 && mat[X+1][Y-2] != 2) {
					if ( Y - 3 >= 0 && X + 2 < 10 ) {
						if ( dp[X+2][Y-3] > cost + 1) {
							dp[X+2][Y-3] = cost + 1;
							q.add(new node(X+2,Y-3,cost+1));
						}
					}
				}
			}
			
			if ( Y + 1 < 9 && mat[X][Y+1] != 2) {
				
				if ( Y + 2 < 9 && X - 1 >= 0 && mat[X-1][Y+2] != 2) {
					if ( Y + 3 < 9 && X - 2 >= 0 ) {
						if ( dp[X-2][Y+3] > cost + 1) {
							dp[X-2][Y+3] = cost + 1;
							q.add(new node(X-2,Y+3,cost+1));
						}
					}
				}
				
				if ( Y + 2 < 9 && X + 1 < 10 && mat[X+1][Y+2] != 2) {
					if ( Y + 3 < 9 && X + 2 < 10 ) {
						if ( dp[X+2][Y+3] > cost + 1) {
							dp[X+2][Y+3] = cost + 1;
							q.add(new node(X+2,Y+3,cost+1));
						}
					}
				}
			}
			
		}
		
		/*for ( int i = 0 ; i < 10 ; i++) {
			for ( int j = 0 ; j <  9 ; j++) {
				System.out.print(dp[i][j]+"  ");
			}System.out.println();
		}*/
		
		if ( dp[R2][C2] == inf) {
			System.out.print(-1);
			return;
		}
		System.out.print(dp[R2][C2]);
	}
	
	public static class node{
		int x,y,cost;
		node ( int x,int y,int cost){
			this.x= x;
			this.y= y;
			this.cost = cost;
		}
	}
}
