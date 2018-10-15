package back14442;

import java.io.*;
import java.util.*;

public class Main {
	static int mat[][];
	static int X[] = {1,0,-1,0};
	static int Y[] = {0,1,0,-1};
	static int cost[][][];
	static int N,M,K;
	static final int inf = (int)1e9;
	public static void main(String args[])throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		mat = new int[N+1][M+1];
		cost = new int[K+1][N+1][M+1];
		for (int i = 1 ; i <= N ; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 1 ; j <= M ; j++) {
				mat[i][j] = Integer.parseInt(String.valueOf(tmp[j-1]));
			}
		}
		
		for(int i = 1 ; i<= N ; i++) {
			for (int j = 1 ; j<= M ; j++) {
				for ( int k = 0 ; k <= K ; k++) {
					cost[k][i][j] = inf;					
				}
			}
		}
		
		BFS();
		
		int ans = inf;
		
		for ( int i = 0 ; i <= K ; i++) {
			ans = Math.min(ans, cost[i][N][M]);
		}
		
		if ( ans != inf) {
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		q.add(new node(1,1,1,K));
		cost[K][1][1] = 1;
		
		while ( !q.isEmpty() ) {
			node tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int Cost = tmp.cost;
			int crash = tmp.crash;
			
			
			for (int i = 0 ; i < 4 ; i++) {
				
				int nx = x + X[i];
				int ny = y + Y[i];
				
				if (  nx >=1 && nx <= N && ny <= M && ny >= 1) {
					
					if ( crash >= 1) {
						if ( cost[crash-1][nx][ny] > Cost+1 ) {
							if ( mat[nx][ny] == 1) {
								if ( crash >= 1) {
									q.add(new node(nx,ny,Cost+1,crash-1));
									cost[crash-1][nx][ny] = Cost+1;
								}
							}
						}
					}
						
					if ( mat[nx][ny] == 0) {
							if ( cost[crash][nx][ny] > Cost+1 ) {
								q.add(new node(nx,ny,Cost+1,crash));
								cost[crash][nx][ny] = Cost+1;
							}
					}
						
				}
			}
		}
	}
	
	public static class node implements Comparable<node>{
		int x,y;
		int cost;
		int crash;
		node(int x,int y,int cost,int crash){
			this.x =x;
			this.y =y;
			this.cost = cost;
			this.crash = crash;
		}
		@Override
		public int compareTo(node o) {
			if ( this.cost > o.cost) {
				return 1;
			}
			return -1;
		}
	}
}
