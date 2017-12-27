package back14502;

import java.util.*;

public class Main {
	static int mat[][];
	static boolean visit[][];
	static ArrayList<node> list;
	static int N,M;
	static int res = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		mat = new int[N+2][M+2];
		list = new ArrayList<>();
		visit = new boolean[N+2][M+2];
		for ( int i = 0 ; i <= N+1 ; i++) {
			for ( int j = 0 ; j <= M+1 ; j++) {
				mat[i][j] = -1;
			}
		}
		
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= M ; j++) {
				mat[i][j] = in.nextInt();
				if ( mat[i][j] == 0) {
					list.add(new node(i,j));
				}
			}
		}
		
		loop:
		for ( int i = 0 ; i < list.size() ; i++) {
			for ( int j = 0 ; j < list.size() ; j++) {
				for ( int k = 0 ; k < list.size() ; k++) {
					if ( list.get(i).x != list.get(j).x || list.get(i).y != list.get(j).y) {
						if  ( list.get(j).x != list.get(k).x || list.get(j).y != list.get(k).y) {
							if  ( list.get(i).x != list.get(k).x || list.get(i).y != list.get(k).y) {
									
								int x1 = list.get(i).x;
								int y1 = list.get(i).y;
								int x2 = list.get(j).x;
								int y2 = list.get(j).y;
								int x3 = list.get(k).x;
								int y3 = list.get(k).y;
								BFS(x1,y1,x2,y2,x3,y3);
								//break loop;
								/*System.out.println(list.get(i).x+","+list.get(i).y+" "+list.get(j).x+","+list.get(j).y
									+" "+list.get(k).x+","+list.get(k).y);*/
							}
						}
					}
				}	
			}
		}
		
		System.out.println(res);
	}
	
	public static void BFS(int x1,int y1,int x2,int y2,int x3,int y3) {
		Queue<node> q = new LinkedList<>();
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= M ; j++) {
				visit[i][j] = false;
			}
		}

		int map[][] = new int[N+2][M+2];
		for ( int i = 0 ; i <= N+1 ; i++) {
			for ( int j = 0 ; j <= M+1 ; j++) {
				map[i][j] = mat[i][j];
			}
		}

		map[x1][y1] = 1;
		map[x2][y2] = 1;
		map[x3][y3] = 1;

		
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= M ; j++) {
				if ( map[i][j] == 2) {
					q.add(new node(i,j));
					visit[i][j] = true;
				}
			}
		}
		while ( !q.isEmpty() ) {
			node tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			
			if ( map[x+1][y] == 0 && visit[x+1][y] == false) {
				q.add(new node(x+1,y));
				map[x+1][y] = 2;
				visit[x+1][y] = true;
			}
			if ( map[x-1][y] == 0 && visit[x-1][y] == false) {
				q.add(new node(x-1,y));
				map[x-1][y] = 2;
				visit[x][y] = true;
			}
			if ( map[x][y+1] == 0 && visit[x][y+1] == false) {
				q.add(new node(x,y+1));
				map[x][y+1] =2;
				visit[x][y+1] = true;
			}
			if ( map[x][y-1] == 0 && visit[x][y-1] == false) {
				q.add(new node(x,y-1));
				map[x][y-1] = 2;
				visit[x][y-1] = true;
			}
			
		}
		int sum = 0;
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= M ; j++) {
				if ( map[i][j] == 0) {
					sum++;
				}
			}
		}
		
		if ( sum > res) {
			res = sum;
		}
	}
	
	public static class node{
		int x,y;
		node(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
