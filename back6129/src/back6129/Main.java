package back6129;

import java.util.*;

public class Main {
	static int N;
	static int dp[][][];
	static char mat[][];
	static int sX,sY;
	static int eX,eY;
	static int X[] = {-1,1,0,0};
	static int Y[] = {0,0,-1,1};
	static int inf = Integer.MAX_VALUE;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = Integer.parseInt(in.nextLine());		
		mat = new char[N][N];
		for ( int i = 0 ; i < N ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = tmp[j];
				if ( mat[i][j] == 'A' ) {
					sX = i; sY = j;
				}
				if ( mat[i][j] == 'B' ) {
					eX = i; eY = j;
				}
			}
		}
		
		dp = new int[4][N][N];
		
		for ( int s = 0 ; s < 4 ; s++) {
			for ( int i = 0 ; i < N ; i++) {
				for ( int j = 0 ; j < N ; j++) {
					dp[s][i][j] = inf;
				}
			}
		}
		
		BFS();
		
		/*for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}*/
		
		int min = dp[0][eX][eY];
		for ( int i = 1 ; i < 4 ; i ++) {
			min = Math.min(dp[i][eX][eY], min);
		}
		System.out.print(min);
	}
	
	public static void BFS() {
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(sX,sY,0,0));
		q.add(new node(sX,sY,1,0));
		q.add(new node(sX,sY,2,0));
		q.add(new node(sX,sY,3,0));
		//System.out.println(sX+" "+sY);
		
		while ( !q.isEmpty() ) {
			
			node now =q.poll();
			int x = now.x;
			int y = now.y;
			int cnt = now.cnt;
			int dir = now.dir;
			
			for ( int i = 0 ; i < 4 ; i ++) {
				int nx = x + X[i];
				int ny = y + Y[i];
			
				// i == 0 1 2 3 ºÏ ³² ¼­ µ¿
				if( nx >= 0 && ny >=0 && nx < N && ny < N ) {
					if ( mat[nx][ny] != 'x') {
						
						if ( dir == i ) {
							if( dp[i][nx][ny] > cnt  ) {
								q.add(new node(nx,ny,i,cnt));
								dp[i][nx][ny] = cnt;
							}
						}else {
							if ( i == 0 && dir == 1) {
								if( dp[i][nx][ny] > cnt + 1 ) {
									q.add(new node(nx,ny,i,cnt+1));
									dp[i][nx][ny] = cnt+1;
								}
							}else if ( i == 1 && dir == 0) {
								if( dp[i][nx][ny] > cnt + 1 ) {
									q.add(new node(nx,ny,i,cnt+1));
									dp[i][nx][ny] = cnt+1;
								}
							}else if ( i == 2 && dir == 3) {
								if( dp[i][nx][ny] > cnt + 1 ) {
									q.add(new node(nx,ny,i,cnt+1));
									dp[i][nx][ny] = cnt+1;
								}
							}else if ( i == 3 && dir == 2) {
								if( dp[i][nx][ny] > cnt + 1 ) {
									q.add(new node(nx,ny,i,cnt+1));
									dp[i][nx][ny] = cnt+1;
								}
							}else {
								if( dp[i][nx][ny] > cnt + 1 ) {
									q.add(new node(nx,ny,i,cnt+1));
									dp[i][nx][ny] = cnt+1;
								}
							}
							
						}
						
					}
				}
			}
			
		}
	}
	public static class node{
		int x,y;
		int dir;
		int cnt;
		node ( int x,int y,int dir,int cnt){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
}
