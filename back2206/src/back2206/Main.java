package back2206;

import java.io.*;
import java.util.*;

public class Main {
	static int mat[][];
	static int X[] = {1,0,-1,0};
	static int Y[] = {0,1,0,-1};
	static int cost0[][];
	static int cost1[][];
	static int N,M;
	static int inf = 100000000;
	public static void main(String args[])throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mat = new int[N+1][M+1];
		cost0 = new int[N+1][M+1];
		cost1 = new int[N+1][M+1];
		for (int i = 1 ; i <= N ; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 1 ; j <= M ; j++) {
				mat[i][j] = Integer.parseInt(String.valueOf(tmp[j-1]));
			}
		}
		
		for(int i = 1 ; i<= N ; i++) {
			for (int j = 1 ; j<= M ; j++) {
				cost0[i][j] = inf;
				cost1[i][j] = inf;
			}
		}
		
		BFS();
		
		/*for(int i = 1 ; i<= N ; i++) {
			for (int j = 1 ; j<= M ; j++) {
				System.out.print(cost0[i][j]+" ");
			}System.out.println();
		}
		System.out.println();
		for(int i = 1 ; i<= N ; i++) {
			for (int j = 1 ; j<= M ; j++) {
				System.out.print(cost1[i][j]+" ");
			}System.out.println();
		}*/
		int ans = Math.min(cost0[N][M],cost1[N][M]);
		if ( ans != inf) {
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		q.add(new node(1,1,1,1));
		cost1[1][1] = 1;
		
		while ( !q.isEmpty() ) {
			node tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int Cost = tmp.cost;
			int crash = tmp.crash;
			//System.out.println(x+","+y+" : "+Cost+" crash: "+crash);
			
			for (int i = 0 ; i < 4 ; i++) {
				if (  x+X[i] >=1 && x+X[i] <= N && y+Y[i] <= M && y+Y[i] >= 1) {
					if ( crash == 1) {
						if ( cost1[x+X[i]][y+Y[i]] > Cost+1 ) {
							if ( mat[x+X[i]][y+Y[i]] == 1) {
								if ( crash == 1) {
									q.add(new node(x+X[i],y+Y[i],Cost+1,0));
									cost1[x+X[i]][y+Y[i]] = Cost+1;
								}
							}else {
								q.add(new node(x+X[i],y+Y[i],Cost+1,crash));
								cost1[x+X[i]][y+Y[i]] = Cost+1;
							}
						}
					}else {
						if ( cost0[x+X[i]][y+Y[i]] > Cost+1 ) {
							if ( mat[x+X[i]][y+Y[i]] == 0) {
									q.add(new node(x+X[i],y+Y[i],Cost+1,crash));
								cost0[x+X[i]][y+Y[i]] = Cost+1;
							}
						}
					}
					
				}
			}
		}
	}
	
	public static class node{
		int x,y;
		int cost;
		int crash;
		node(int x,int y,int cost,int crash){
			this.x =x;
			this.y =y;
			this.cost = cost;
			this.crash = crash;
		}
	}
}
