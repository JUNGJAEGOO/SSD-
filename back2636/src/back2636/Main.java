package back2636;

import java.util.*;

public class Main {
	static int R,C;
	static int mat[][];
	static int X[] = { 0 , 0 , -1 , 1};
	static int Y[] = {1, -1 , 0 , 0 };
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		R = in.nextInt();
		C = in.nextInt();
		mat = new int[R+2][C+2];
		
		int sum = 0;
		
		for ( int i = 1 ; i <= R ; i++) {
			for ( int j = 1 ; j<= C ; j++) {
				mat[i][j] = in.nextInt();
				if ( mat[i][j] == 1) {
					sum++;
				}
			}
		}
		
		BFS(0,0);
		
		/*for ( int i = 1 ; i<= R ; i++) {
			for ( int j = 1 ; j <= C ; j++) {
				System.out.print(mat[i][j]+" ");
			}System.out.println();
		}*/
		
		int day = 1;
		int lastsum = sum;
		while ( true ) {
			
			/*for ( int i = 1 ; i<= R ; i++) {
			for ( int j = 1 ; j <= C ; j++) {
				System.out.print(mat[i][j]+" ");
			}System.out.println();
			}System.out.println();
			*/
			ArrayList<node> list = new ArrayList<>();
			
			for ( int i = 1 ; i<= R ; i++) {
				for ( int j = 1 ; j <= C ; j++) {
					if ( i+1 <= R && i - 1 >= 1 && j-1 >= 1 && j+1 <= C) {
						if ( mat[i][j] == 1) {
							if ( mat[i+1][j] == 7 || mat[i-1][j] == 7 || mat[i][j-1] == 7 || mat[i][j+1] == 7 ) {
								list.add(new node(i,j));
							}
						}
					}
				}
			}
			
			
			for ( int i = 0 ; i < list.size() ; i++) {
				mat[list.get(i).x][list.get(i).y] = 0;
			}
			
			lastsum = sum;
			sum -= list.size();
			
			if ( sum == 0) {
				break;
			}
			
			for ( int i = 0 ; i < list.size() ; i++) {
				BFS(list.get(i).x,list.get(i).y);
			}
			
			day++;
		}
		
		System.out.println(day);
		System.out.println(lastsum);
	}
	
	public static void BFS(int sX,int sY) {
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(sX,sY));
		mat[sX][sY] = 7;
		
		//System.out.println("start");
		while (!q.isEmpty() ) {
			
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			//System.out.println(x+" "+y);
			
			for ( int i = 0 ; i < 4 ; i++) {
				
				int nx = x + X[i];
				int ny = y + Y[i];
				
				if ( nx >= 0 && ny >= 0 && nx <= R+1 && ny <= C+1) {
					if ( mat[nx][ny] == 0) {
						mat[nx][ny] = 7;
						q.add(new node(nx,ny));
					}
				}

			}
			
		}
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
