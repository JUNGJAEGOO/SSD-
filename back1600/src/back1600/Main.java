package back1600;

import java.util.*;

public class Main {
	static int mat[][];
	static int cost[][][];
	static int W,H,K;
	static int inf = 1000000000;
	
	static int X[] = {-1,0,1,0};
	static int Y[] = {0,1,0,-1};
	static int horseX[] = { -1,-1,-2,-2,1,1,2,2};
	static int horseY[] = { 2,-2,1,-1,2,-2,1,-1};
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		K = in.nextInt();
		H = in.nextInt();
		W = in.nextInt();
		mat = new int[W][H];
		cost = new int[34][W][H];
		for ( int i = 0 ; i <= 33 ; i++) {
			for ( int j = 0 ; j < W ; j++) {
				for ( int k = 0; k< H ; k++) {
					cost[i][j][k] = inf;
				}
			}
		}
		
		for ( int i = 0 ; i <W ; i++) {
			for ( int j = 0 ; j < H ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		BFS();
		
		int min = inf;
		
		for ( int i = 0 ; i <= K ; i++) {
			if ( cost[i][W-1][H-1] < min) {
				min = cost[i][W-1][H-1];
			}
		}
		
		/*for ( int i = 0 ; i <= K ; i++) {
			for ( int j = 0 ; j < W ; j++) {
				for ( int k = 0 ; k < H ; k++) {
					if( cost[i][j][k] == inf) {
						System.out.print("X ");
					}else {
						System.out.print(cost[i][j][k]+" ");
					}
				}System.out.println();
			}
			System.out.println();
		}*/
		
		if ( min == inf) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		q.add(new node(0,0,K,0));
		if ( mat[0][0] == 0 ) {
			cost[K][0][0] = 0;
		}
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int x =now.x;
			int y = now.y;
			int cnt = now.cnt;
			int c = now.cost;
			
			if ( cnt > 0 ) {
				
				for ( int i = 0 ; i < 8 ; i++) {
					int nx = x + horseX[i];
					int ny = y + horseY[i];
					if ( nx >= 0 && nx < W && ny >= 0 && ny < H && mat[nx][ny] == 0 && cost[cnt-1][nx][ny] > c + 1) {
						cost[cnt-1][nx][ny] = c + 1;
						q.add(new node(nx,ny,cnt-1,c+1));
					}
				}
			}
			for ( int i = 0 ; i < 4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				if ( nx >= 0 && nx < W && ny >= 0 && ny < H &&  mat[nx][ny] == 0 &&  cost[cnt][nx][ny] > c + 1) {
					cost[cnt][nx][ny] = c + 1;
					q.add(new node(nx,ny,cnt,c+1));
				}
			}

		}
	}
	
	public static class node{
		int x,y;
		int cnt;
		int cost;
		node ( int x,int y,int cnt,int cost){
			this.x= x;
			this.y= y;
			this.cnt = cnt;
			this.cost = cost;
		}
	}
}
