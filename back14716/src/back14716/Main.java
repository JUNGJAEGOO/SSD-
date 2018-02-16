package back14716;

import java.util.*;

public class Main {
	static int X[] = {0,1,0,-1,1,1,-1,-1};
	static int Y[] = {1,0,-1,0,1,-1,1,-1};
	static int mat[][];
	static boolean visit[][];
	static int M,N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		M = in.nextInt();
		N = in.nextInt();
		mat = new int[M][N];
		visit = new boolean[M][N];
		for (int i = 0 ; i < M ; i++) {
			for (int j = 0 ; j< N ; j++) {
				mat[i][j]= in.nextInt();
			}
		}
		int cnt = 0;
		for (int i = 0 ; i < M ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if ( visit[i][j] == false && mat[i][j] == 1) {
					BFS(i,j);
					//System.out.println(i+","+j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	public static void BFS(int sx,int sy) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(sx,sy));
		visit[sx][sy] = true;
		while( !q.isEmpty() ) {
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			
			for (int i = 0 ; i < 8 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				if ( nx >= 0 && ny >= 0 && nx < M && ny < N) {
					if ( visit[nx][ny] == false && mat[nx][ny] == 1) {
						visit[nx][ny] = true;
						q.add(new node(nx,ny));
					}
				}
			}
		}
	
	}
	
	public static class node{
		int x,y;
		node (int x, int y){
			this.x =x;
			this.y =y;
		}
	}
}
