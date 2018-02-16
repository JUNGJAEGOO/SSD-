package back2589;

import java.io.*;
import java.util.*;

public class Main {
	static char mat[][];
	static boolean visit[][];
	static int cost[][];
	static int inf = 100000000;
	static int X[] = {0,1,0,-1};
	static int Y[] = {1,0,-1,0};
	static int R,C;
	static int max = 0;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mat = new char[R][C];
		visit = new boolean[R][C];
		cost = new int[R][C];
		for (int i = 0 ; i < R ; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0 ; j < C ; j++) {
				mat[i][j] = tmp[j];
			}
		}

		
		for (int i = 0 ; i < R ; i++) {
			for (int j = 0 ; j < C ; j++) {
				if (  mat[i][j] == 'L' ) {
					visit = new boolean[R][C];
					visit[i][j] = true;
					//System.out.println(i+" "+j);
					BFS(i,j);
					
					int tmpmax = 0;
					for (int s = 0 ; s < R ; s++) {
						for (int k = 0 ; k < C ; k++) {
							if ( cost[s][k] > tmpmax) {
								tmpmax = cost[s][k];
 							}
						}
					}
					
					max = Math.max(max, tmpmax);
				}
			}
		}

		System.out.println(max);
	}
	
	public static void BFS(int sx,int sy) {
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(sx,sy,0));
		cost[sx][sy] = 0;
		visit[sx][sy] = true;
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			int c = now.cost;
			
			for ( int i = 0; i <4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				if ( nx >= 0 && ny >= 0 && nx < R && ny < C) {
					if ( mat[nx][ny] == 'L' && visit[nx][ny] == false) {
						visit[nx][ny] = true;
						cost[nx][ny] = c + 1;
						q.add(new node(nx,ny,c+1));
					}
				}
			}
			
		}
		
	}
	
	public static class node{
		int x,y;
		int cost;
		node(int x,int y,int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}

