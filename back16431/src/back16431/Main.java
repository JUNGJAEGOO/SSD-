package back16431;

import java.io.*;
import java.util.*;

public class Main {
	static int dist1[][];
	static int dist2[][];
	
	static int xx[] = {-1,0,1,0};
	static int yy[] = {0,1,0,-1};
	static int xxx[] = {-1,-1,-1,0,0,1,1,1};
	static int yyy[] = {-1,0,1,-1,1,0,-1,1};
	
	static int inf = Integer.MAX_VALUE;
	
	static int Bx,By,Dx,Dy,Jx,Jy;
	static int ansOne = -1 , ansTwo = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		Bx = Integer.parseInt(st.nextToken());
		By = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		Dx = Integer.parseInt(st.nextToken());
		Dy = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		Jx = Integer.parseInt(st.nextToken());
		Jy = Integer.parseInt(st.nextToken());
		
		dist1=  new int[1001][1001];
		dist2=  new int[1001][1001];
		
		for ( int i = 0 ; i < 1001 ; i++) {
			for ( int j = 0 ; j < 1001; j++) {
				dist1[i][j] = inf;dist2[i][j] = inf;
			}
		}
		
		DFS(Bx,By);
		BFS(Dx,Dy);
		
		ansOne = dist2[Jx][Jy];
		ansTwo = dist1[Jx][Jy];
		
		//System.out.println(ansOne+" "+ansTwo);
		
		if ( ansOne > ansTwo) {
			System.out.println("daisy");
		}else if ( ansOne < ansTwo) {
			System.out.println("bessie");
		}else {
			System.out.println("tie");
		}
		
	}
	
	public static void BFS(int x,int y) {
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(x,y,0));
		dist1[x][y] = 0;
		
		while ( !pq.isEmpty() ) {
			
			node now = pq.poll();
			int X = now.x;
			int Y =  now.y;
			int cost = now.cost;
			
			if ( dist1[X][Y] < cost) {
				continue;
			}
			
			for ( int i = 0 ; i < 4 ; i++) {
				int nx = X + xx[i];
				int ny = Y + yy[i];
				
				if ( nx >= 1 && nx <= 1000 && ny >= 1 && ny <= 1000) {
					if ( dist1[nx][ny] > cost + 1 ) {
						dist1[nx][ny] = cost + 1;
						pq.add(new node(nx,ny,cost+1));
					}
				}
			}
			
			
		}
		
	}
	
	public static void DFS(int x,int y) {
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(x,y,0));
		dist2[x][y] = 0;
		
		while ( !pq.isEmpty() ) {
			
			node now = pq.poll();
			int X = now.x;
			int Y =  now.y;
			int cost = now.cost;
			
			if ( dist2[X][Y] < cost) {
				continue;
			}
			
			for ( int i = 0 ; i < 8 ; i++) {
				int nx = X + xxx[i];
				int ny = Y + yyy[i];
				
				if ( nx >= 1 && nx <= 1000 && ny >= 1 && ny <= 1000) {
					if ( dist2[nx][ny] > cost + 1 ) {
						dist2[nx][ny] = cost + 1;
						pq.add(new node(nx,ny,cost+1));
					}
				}
			}
			
			
		}
		
	}
	
	public static class node implements Comparable<node>{
		int x,y;
		int cost;
		
		node ( int x,int y , int cost){
			this.x = x;
			this.y =y;
			this.cost = cost;
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
