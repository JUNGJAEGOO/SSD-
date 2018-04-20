package back2194;

import java.util.*;

public class Main {
	static int N,M,A,B;
	static int mat[][];
	static int sX,sY,eX,eY;
	static int X[] = {0,0,1,-1};
	static int Y[] = {1,-1,0,0};
	static boolean visit[][];
	static int ans = -1;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		A = in.nextInt();
		B = in.nextInt();
		mat = new int[N][M];
		int k = in.nextInt();
		for ( int i = 0 ; i < k ; i++) {
			
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			mat[x][y] = 1;
		}
		
		sX = in.nextInt() -1;
		sY = in.nextInt() -1;
		eX = in.nextInt() -1;
		eY = in.nextInt()- 1;
		
		visit = new boolean[N][M];
		
		BFS();
		
		System.out.print(ans);
		
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		q.add(new node(sX,sY,0));
		visit[sX][sY] = true;
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			int cnt = now.cnt;
			System.out.println(x+" "+y+" "+cnt);
			
			if ( x == eX && y == eY) {
				ans = cnt;
				break;
			}
			
			for ( int i = 0 ; i < 4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				boolean pass = true;
				
				if ( nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;
				}
				
				if ( visit[nx][ny] == true) {
					continue;
				}
				
				lop:
				for ( int j = nx ; j < nx + A ; j++) {
					for ( int k = ny ; k < ny + B ; k++) {
						if ( j >= N || j < 0 || k >= M || k < 0 ) {
							pass = false;
							break lop;
						}
						if ( mat[j][k] == 1 ) {
							pass = false;
							break lop;
						}
					}
				}
				
				if ( pass) {
					
					visit[nx][ny] = true;
					q.add(new node(nx,ny,cnt+1));
				}
			}
			
		}
	}
	
	public static class node{
		int x,y;
		int cnt = 0;
		node ( int x,int y,int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
