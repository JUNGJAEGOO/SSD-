package back1103;

import java.util.*;

public class Main {
	static int cost[][];
	static boolean visit[][][];
	static char [][] mat;
	static int N,M;
	static int X[] = {0,0,1,-1};
	static int Y[] = {1,-1,0,0};
	static int res = 0;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(" ");
		N = Integer.parseInt(info[0]);
		M = Integer.parseInt(info[1]);
		mat = new char[N][M];
		cost = new int[N][M];
		visit  = new boolean[5][N][M];
		
		for ( int i = 0 ; i < N ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			for ( int j = 0 ; j < M ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		
		BFS();
		
//		for ( int i = 0 ; i < N ; i++) {
//			for ( int j = 0 ; j < M ; j++) {
//				System.out.print(cost[i][j]+" ");
//			}System.out.println();
//		}
		
		if ( res == 100000000) {
			System.out.println(-1);
		}else {
		System.out.println(res);
		}
		
	}
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		q.add(new node(0,0,0,1));  // µ¿
		q.add(new node(0,0,0,2));  // ¼­
		q.add(new node(0,0,0,3));  // ³²
		q.add(new node(0,0,0,4));  // ºÏ
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int x = now.x;
			int y= now.y;
			int cnt = now.cnt;
			int dir = now.dir;
			//System.out.println(x+" "+y);
			res = Math.max(res, cnt);
			
			if ( x < 0 || y < 0 || x >= N || y >= M || mat[x][y] == 'H' ) {
				continue;
			}
			
			if ( cost[x][y] < cnt && visit[dir][x][y] == true ) {
				//System.out.println(dir+" "+x+" "+y);
				res = 100000000;
				continue;
			}
			
			if ( cnt != 0 && cost[x][y] < cnt + 1 && visit[dir][x][y] == false) {
				//System.out.println("hi");
				cost[x][y] = cnt + 1;
				visit[dir][x][y] = true;
			}
			
			int gob = Integer.parseInt(String.valueOf(mat[x][y]));
			//System.out.println(gob);
			
			for (int i = 0 ; i <4 ; i++) {
				
				int nx = x + gob * X[i];
				int ny = y + gob * Y[i];
				
				//System.out.println("next is "+nx+" "+ny);
					if ( i == 0) {

						q.add(new node(nx,ny,cnt+1,1));
						
					}else if ( i == 1) {
						q.add(new node(nx,ny,cnt+1,2));
						
					}else if ( i == 2) {

						q.add(new node(nx,ny,cnt+1,3));
						
					}else if ( i == 3) {

						q.add(new node(nx,ny,cnt+1,4));
						
					}
				
				
				
			
			}
		}
		
	}
	
	public static class node{
		int x,y;
		int cnt;
		int dir;
		node ( int x,int y,int cnt,int dir){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
}
