package back11451;

import java.util.*;

public class Main {
	static int M,N;
	static char mat[][];
	static int X[] = {1,0,-1,0};
	static int Y[] = {0,1,0,-1};
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while ( T > 0) {
			
			String info[] = in.nextLine().split(" ");
			M = Integer.parseInt(info[0]);
			N = Integer.parseInt(info[1]);
			mat = new char[M][N];
			
			int sx1 = -1;
			int sx2 = -1;
			int sy1 = -1;
			int sy2 = -1;
			
			for ( int i = 0 ; i < M ; i++) {
				char[] tmp  = in.nextLine().toCharArray();
				for ( int j = 0 ; j < N ; j++) {
					
					mat[i][j] = tmp[j];
					if ( mat[i][j] == 'P') {
						if ( sx1 == -1) {
							sx1 = i; sy1 = j;
						}else {
							sx2 = i; sy2 = j;
						}
					}
					
				}
			}
			
			
			
			
			
			T--;
		}
	}
	
	public static void BFS(int sx1,int sy1,int sx2,int sy2) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(sx1,sy1,sx2,sy2,5));
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int x1 = now.x1;
			int x2 = now.x2;
			int y1= now.y1;
			int y2= now.y2;
			int life = now.life;
			
			for (int i = 0 ; i < 4 ; i++) {
				
				int nx1 = (x1 + X[i]);
				int nx2 = (x2 + X[i]);
				int ny1 = (y1 + Y[i]);
				int ny2 = (y2 + Y[i]);
				if ( nx1 < 0) {
					nx1 = M-1;
				}
				if ( ny1 < 0) {
					ny1 = N-1;
				}
				if ( nx1 >= M) {
					nx1 = 0;
				}
				if ( ny1 >= N) {
					ny1 = 0;
				}
				if ( nx2 < 0) {
					nx2 = M-1;
				}
				if ( ny2 < 0) {
					ny2 = N-1;
				}
				if ( nx2 >= M) {
					nx2 = 0;
				}
				if ( ny2 >= N) {
					ny2 = 0;
				}
				
				if ( mat[nx1][ny1] == 'X' && mat[nx2][ny2] == '.') {
					q.add(new node(x1,y1,nx2,ny2,life));
				}else if ( mat[nx1][ny1] == 'X' && mat[nx2][ny2] == 'X') {
					
				}else if ( mat[nx1][ny1] == '.' && mat[nx2][ny2] == 'X') {
					q.add(new node(nx1,ny1,x2,y2,life));
				}else if ( mat[nx1][ny1] == '.' && mat[nx2][ny2] == '.') {
					q.add(new node(nx1,ny1,nx2,ny2,life));
				}else if ( mat[nx1][ny1] == 'P' && mat[nx2][ny2] == '.') {
					q.add(new node(nx1,ny1,nx2,ny2,life));
				}else if ( mat[nx1][ny1] == '.' && mat[nx2][ny2] == 'P') {
					
				}else if ( mat[nx1][ny1] == 'X' && mat[nx2][ny2] == 'P') {
					
				}else if ( mat[nx1][ny1] == 'P' && mat[nx2][ny2] == 'X') {
					
				}else if ( mat[nx1][ny1] == 'X' && mat[nx2][ny2] == 'G') {
					
				}else if ( mat[nx1][ny1] == 'G' && mat[nx2][ny2] == 'X') {
					
				}else if ( mat[nx1][ny1] == 'G' && mat[nx2][ny2] == 'G') {
					
				}else if ( mat[nx1][ny1] == 'G' && mat[nx2][ny2] == '.') {
					
				}else if ( mat[nx1][ny1] == '.' && mat[nx2][ny2] == 'G') {
					
				}else if ( mat[nx1][ny1] == 'P' && mat[nx2][ny2] == 'P') {
					
				}else if ( mat[nx1][ny1] == 'G' && mat[nx2][ny2] == 'G') {
					
				}
				
			}
		}
		
	}
	
	public static class node{
		int x1,y1;
		int x2,y2;
		int life;
		node (int x1,int y1,int x2,int y2,int life){
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.life = life;
		}
	}
}
