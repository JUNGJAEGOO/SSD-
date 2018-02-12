package back3184;

import java.util.*;

public class Main {
	static int R,C;
	static char mat[][];
	static int X[] = {-1,0,1,0};
	static int Y[] = {0,1,0,-1};
	static boolean visit[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		mat = new char[R][C];
		for (int i = 0 ; i < R; i++) {
			char[] tmp = in.nextLine().toCharArray();
			for (int j = 0 ; j < C ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		
		int Ramb = 0;
		int Wolf = 0;
		visit = new boolean[R][C];
		for (int i = 0 ; i < R; i++) {
			for (int j = 0 ; j < C ; j++) {
				if ( visit[i][j] == false && mat[i][j] != '#') {
					int tmp[] = BFS(i,j);
					if ( tmp[0] < tmp[1] ) {
						Ramb += tmp[1];
					}else if ( tmp[0] >= tmp[1]) {
						Wolf += tmp[0];
					}
				}
			}
		}
		
		System.out.print(Ramb+" "+Wolf);
		
	}
	
	public static int[] BFS(int startX,int startY) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(startX,startY));
		visit[startX][startY] = true;
		int ramb = 0;
		int wolf = 0;
		while ( !q.isEmpty() ) {
			node tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			if ( mat[x][y] == 'v') {
				wolf++;
			}else if ( mat[x][y] == 'o') {
				ramb++;
			}
			
			for (int i = 0 ; i <4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				if (  nx >= 0 && nx < R && ny >= 0 && ny < C) {
					if ( visit[nx][ny] == false && mat[nx][ny] != '#') {
						visit[nx][ny] = true;
						q.add(new node(nx,ny));
					}
				}
			}
			
		}
		
		int res[] = new int[2];
		res[0] = wolf;
		res[1] = ramb;
		
		return res;
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x =x;
			this.y = y;
		}
	}
}
