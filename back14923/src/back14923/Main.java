package back14923;

import java.util.*;

public class Main {
	static int xx[] = {0,1,0,-1};
	static int yy[] = {1,0,-1,0};
	static int inf = 100000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int Hx = in.nextInt()-1;
		int Hy = in.nextInt()-1;
		int Ex = in.nextInt()-1;
		int Ey = in.nextInt()-1;
		
		int mat[][] = new int[N][M];
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < M ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		int cost[][][] = new int[2][N][M];
		for ( int i = 0 ; i < 2 ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				for ( int k = 0 ; k < M ; k++) {
					cost[i][j][k] = inf;
				}
			}
		}
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(Hx,Hy,0,1));
		cost[1][Hx][Hy] = 0;
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			
			int X = now.x;
			int Y = now.y;
			int C = now.cost;
			int magic = now.magic;
			
			for ( int i = 0 ; i < 4 ; i++) {
				int nx = xx[i] + X;
				int ny = yy[i] + Y;
				
				if ( nx >= 0 && ny >= 0 && nx < N && ny < M ) {
					
					if ( mat[nx][ny] == 0 && cost[magic][nx][ny] > C+1 ) {
						q.add(new node(nx,ny,C+1,magic) );
						cost[magic][nx][ny] = C+1;
					}
					
					if ( magic == 1) {
						q.add(new node(nx,ny,C+1,magic-1));
						cost[magic][nx][ny] = C+1;
					}
					
				}
			}
			
			
		}
		
		if ( cost[0][Ex][Ey] == inf && cost[1][Ex][Ey] == inf) {
			System.out.print(-1);
			return;
		}
		
		if ( cost[0][Ex][Ey] >= cost[1][Ex][Ey]) {
			System.out.print(cost[1][Ex][Ey]);
		}else if ( cost[1][Ex][Ey] > cost[0][Ex][Ey]) {
			System.out.print(cost[0][Ex][Ey]);
		}
		
	}
	
	public static class node{
		int x,y,cost;
		int magic;
		node ( int x,int y , int cost,int magic){
			this.x=  x;
			this.y = y;
			this.cost = cost;
			this.magic = magic;
		}
	}
}
