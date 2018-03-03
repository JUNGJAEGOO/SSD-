package back15559;

import java.util.*;

public class Main {
	static int R,C;
	static int cost[][];
	static char mat[][];
	static int flagging[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		mat = new char[R][C];
		
		for (int i = 0 ; i < R ; i++) {
			char[] tmp = in.nextLine().toCharArray();
			for (int j = 0 ; j < C ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		
		flagging = new int[R][C];
		
		cost = new int[R][C];
		int flag = 1;
		for (int i = 0 ; i < R ; i++) {
			for (int j = 0 ; j < C ; j++) {
				if ( cost[i][j] == 0) {
					BFS(i,j,flag);
					flag++;
				}
			}
		}
		
		
		/*for (int i = 0 ; i < R ; i++) {
			for (int j = 0 ; j < C;  j++) {
				System.out.print(cost[i][j]+" ");
			}System.out.println();
		}*/
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0 ; i < R ; i++) {
			for (int j = 0 ; j < C;  j++) {
				//System.out.print(flagging[i][j]+" ");
				hs.add(flagging[i][j]);
			}//System.out.println();
		}
		System.out.println(hs.size());
		
	}
	
	public static void BFS(int Sx,int Sy,int flag) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(Sx,Sy,1));
		cost[Sx][Sy] = 1;
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			int c = now.cost;
			flagging[x][y] = flag;
			//System.out.println(x+" "+y+" "+flag);
			
			char direction = mat[x][y];
			
			if ( direction == 'S') {
				int nx = x + 1;
				int ny = y ;
				if ( nx >= 0 && nx < R && ny >= 0 && ny < C && cost[nx][ny] < c+1 && flagging[nx][ny] != flag) {
					q.add(new node(nx,ny,c+1));
					cost[nx][ny] = c+1;
				}
			}else if ( direction == 'W' ) {
				int nx = x;
				int ny = y-1 ;
				if ( nx >= 0 && nx < R && ny >= 0 && ny < C && cost[nx][ny] < c+1 && flagging[nx][ny] != flag) {
					q.add(new node(nx,ny,c+1));
					cost[nx][ny] = c+1;
				}
			}else if ( direction == 'E' ) {
				int nx = x;
				int ny = y+1 ;
				if ( nx >= 0 && nx < R && ny >= 0 && ny < C && cost[nx][ny] < c+1 && flagging[nx][ny] != flag) {
					q.add(new node(nx,ny,c+1));
					cost[nx][ny] = c+1;
				}
			}else if ( direction == 'N' ) {
				int nx = x -1;
				int ny = y ;
				if ( nx >= 0 && nx < R && ny >= 0 && ny < C && cost[nx][ny] < c+1 && flagging[nx][ny] != flag) {
					q.add(new node(nx,ny,c+1));
					cost[nx][ny] = c+1;
				}
			}
			
			
		}
		
	}
	
	public static class node{
		int x,y;
		int cost;
		node (int x,int y,int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
