package back14503;

import java.util.*;

public class Main {
	static int N,M;
	static int sX,sY,d;
	static int mat[][];
	static boolean visit[][];
	public static void main(String args[]) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		mat = new int[N][M];
		sX = in.nextInt();
		sY = in.nextInt();
		d = in.nextInt();
		// 0 ºÏ 1 µ¿ 2 ³² 3 ¼­
		for (int i = 0 ; i< N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		visit = new boolean[N][M];
		Queue<node> q = new LinkedList<>();
		q.add(new node(sX,sY,d,0));
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			int d = now.d;
			int cnt = now.cnt;
			visit[x][y] = true;
			System.out.println(x+","+y+" "+cnt+" d: "+d);
			//Thread.sleep(500);
			if ( d == 0) {
				if ( cnt == 4) {
					if ( x+1 < N &&  mat[x+1][y] == 0 ) {
						q.add(new node(x+1,y,d,0));
					}else if ( x+1 >= N || mat[x+1][y] == 1) {
						break;
					}
				}
				else if ( y-1>= 0 && visit[x][y-1] == false && mat[x][y-1] == 0) {
					q.add(new node(x,y-1,3,0));
				}
				else {
					q.add(new node(x,y,3,cnt+1));
				}
			}else  if ( d == 1) {
				if ( cnt == 4) {
					if ( y-1 >= 0 && mat[x][y-1] == 0 ) {
						q.add(new node(x,y-1,d,0));
					}else if (y-1 < 0 ||  mat[x][y-1] == 1) {
						break;
					}
				}
				else if ( x-1 >= 0 && visit[x-1][y] == false && mat[x-1][y] == 0) {
					q.add(new node(x-1,y,0,0));
				}
				else {
					q.add(new node(x,y,0,cnt+1));
				}
			}else if ( d == 2) {
				if ( cnt == 4) {
					if ( x-1>= 0 && mat[x-1][y] == 0 ) {
						q.add(new node(x-1,y,d,0));
					}else if ( x-1 < 0 || mat[x-1][y] == 1) {
						break;
					}
				}
				else if ( y+1<M && visit[x][y+1] == false && mat[x][y+1] == 0) {
					q.add(new node(x,y+1,1,0));
				}
				else {
					q.add(new node(x,y,1,cnt+1));
				}
			}else if ( d == 3) {
				if ( cnt == 4) {
					if ( y+1 < M && mat[x][y+1] == 0 ) {
						q.add(new node(x,y+1,d,0));
					}else if ( y+1 >= M || mat[x][y+1] == 1) {
						break;
					}
				}
				else if ( x+1 < N && visit[x+1][y] == false && mat[x+1][y] == 0) {
					q.add(new node(x+1,y,2,0));
				}
				else {
					q.add(new node(x,y,2,cnt+1));
				}
			}
			
		}
		int sum = 0;
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				if ( visit[i][j] ) {
					sum++;
				}
			}
		}
		System.out.println(sum);
		
	}
	
	public static class node{
		int x,y;
		int d;
		int cnt;
		node (int x,int y,int d,int cnt){
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
	}
}
