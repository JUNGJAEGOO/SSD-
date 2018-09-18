package back2178;

import java.util.*;

public class Main {
	static int xx[] = {-1,0,1,0};
	static int yy[] = {0,1,0,-1};
	static boolean visit[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		String[] info = in.nextLine().split(" ");
		
		int N = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);
		
		int mat[][] = new int[N][M];
		visit = new boolean[N][M];
		
		for ( int i = 0 ; i < N ; i++) {
			
			String gogo[] = in.nextLine().split("");
			
			for ( int j = 0 ; j < M ; j++) {
				mat[i][j] = Integer.parseInt(gogo[j]);
			}
			
		}
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(0,0,1));
		visit[0][0] = true;
		
		
		while ( !q.isEmpty()) {
			
			node now = q.poll();
			
			int X = now.x;
			int Y = now.y;
			int COST = now.cost;
			
			//System.out.println(X+","+Y);
			
			
			if ( X == N-1 && Y == M-1) {
				System.out.print(COST);
				break;
			}
			
			for ( int i = 0 ; i < 4 ; i++) {
				int nx = X + xx[i];
				int ny = Y + yy[i];
				if ( nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if ( mat[nx][ny] == 1) {
						if ( visit[nx][ny] == false ) {
							q.add(new node(nx,ny,COST+1));
							visit[nx][ny] = true;
						}
					}
				}
			}
			
		}
		
	}
	
	public static class node{
		int x,y;
		int cost;
		node ( int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
