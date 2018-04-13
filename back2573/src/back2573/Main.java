package back2573;

import java.util.*;

public class Main {
	static int mat[][];
	static int R,C;
	static int X[] = {0,0,1,-1};
	static int Y[] = {1,-1,0,0};
	static boolean visit[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		R = in.nextInt();
		C = in.nextInt();
		mat = new int[R][C];
		for ( int i = 0 ; i < R ; i++) {
			for ( int j = 0 ; j < C ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		
		int cnt = 0;
		while ( true ) {
			
			visit = new boolean[R][C];
			//System.out.println(cnt);
			
		/*	for ( int i = 0 ; i <R ; i++) {
				for( int j = 0 ; j < C; j++) {
					System.out.print(mat[i][j]+" ");
				}System.out.println();
			}System.out.println();
			*/
			
			lop:
			for ( int i = 0 ; i < R ; i++) {
				for ( int j = 0 ; j < C ; j++) {
					if ( mat[i][j] >= 1) {
						BFS(i,j);
						break lop;
					}
				}
			}
			
			
			boolean pass = true;
			lopp:
			for ( int i = 0 ; i < R ; i++) {
				for ( int j = 0 ; j < C ; j++ ) {
					if ( visit[i][j] == false && mat[i][j] >= 1) {
						pass = false;
						break lopp;
					}
				}
			}
			
			if ( !pass) {
				
				
				break;
			}
			
			
			ArrayList<node> list = new ArrayList<>();
			for ( int i = 0 ; i < R ; i++) {
				for ( int j = 0 ; j < C ; j++) {
					if ( mat[i][j] >= 1) {
						
						int count = 0;
						if ( i-1 >= 0 && mat[i-1][j] == 0) {
							count++;
						}
						if ( i+1 < R &&  mat[i+1][j] == 0) {
							count++;
						}
						if ( j-1 >= 0 && mat[i][j-1] == 0) {
							count++;
						}
						if ( j+1 < C && mat[i][j+1] == 0) {
							count++;
						}
						
						list.add(new node(i,j,count));
					}
				}
			}
			
			int sum = 0;
			for ( int i = 0 ; i < list.size() ; i++) {
				int x = list.get(i).x;
				int y = list.get(i).y;
				int count = list.get(i).count;
				mat[x][y] -= count;
				if ( mat[x][y] < 0) {
					mat[x][y] = 0;
				}else {
					sum++;
				}
			}
			
			cnt++;
			
			if ( sum == 0 ) {
				cnt = 0;
				break;
			}
			
		}
		
		System.out.println(cnt);
		
	}
	
	public static void BFS(int sX,int sY) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(sX,sY,0));
		visit[sX][sY] = true;
		
		while (!q.isEmpty() ) {
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			
			for ( int i = 0 ; i < 4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				if ( nx >= 0 && ny >= 0 && nx < R && ny < C) {
					if ( mat[nx][ny] >= 1 && visit[nx][ny] == false ) {
					visit[nx][ny] = true;
					q.add(new node(nx,ny,0));
					}
				}
				
			}
		}
	}
	
	public static class node{
		int x,y;
		int count;
		node ( int x,int y,int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
