package back1981;

import java.util.*;

public class Main {
	static int mat[][];
	static int diff[][];
	static int inf = 1000000000;
	static int X[] = {0,0,-1,1};
	static int Y[] = {-1,1,0,0,};
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		mat = new int[N][N];
		
		for ( int i = 0 ; i < N ; i++) {
			for( int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		diff = new int[N][N];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				diff[i][j] = inf;
			}
		}
		
		BFS();
		
		/*for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				System.out.print(diff[i][j]+" ");
			}System.out.println();
		}*/
		
		System.out.print(diff[N-1][N-1]);
		
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		q.add(new node(0,0,mat[0][0],mat[0][0]));
		diff[0][0] = 0;
		
		while ( !q.isEmpty() ) {
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			int max = now.max;
			int min = now.min;
			
			for ( int i = 0 ; i < 4 ; i ++) {
				int nx = x + X[i];
				int ny = y + Y[i];
			
				if ( nx >= 0 && ny >= 0 && nx < N && ny < N) {
					
					int nmax = Math.max(mat[nx][ny],max);
					int nmin = Math.min(mat[nx][ny],min);
					
					if ( diff[nx][ny] > nmax - nmin ) {
						q.add(new node(nx,ny,nmax,nmin));
						diff[nx][ny] = nmax - nmin;
					}
					
				}
				
			}
		}

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
