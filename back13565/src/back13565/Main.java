package back13565;

import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int mat[][];
	static boolean visit[][];
	static int X[] = {-1,0,1,0};
	static int Y[] = {0,1,0,-1};
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mat = new int[N][M];
		for (int i = 0; i < N ; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0 ; j < M ; j++) {
				mat[i][j] = Integer.parseInt(String.valueOf(tmp[j]));
			}
		}
		visit = new boolean[N][M];
		
		BFS();
		
		
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		for (int i = 0 ; i < M ; i++) {
			if ( mat[0][i] == 0 ) {
				q.add(new node(0,i));
				visit[0][i] = true;
			}
		}
		
		while ( !q.isEmpty() ) {
			node now = q.poll();
			int x = now.x;
			int y= now.y;
			//System.out.println(x+" "+y);
			if ( x == N-1) {
				System.out.println("YES");
				return;
			}
			
			for (int i = 0 ; i <4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				if ( nx>=0 && ny>=0 && nx < N && ny< M) {
					if ( mat[nx][ny] == 0 && visit[nx][ny] == false) {
						visit[nx][ny] = true;
						q.add(new node(nx,ny));
					}
				}
			}
		}
		
		System.out.println("NO");
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x= x;
			this.y= y;
		}
	}
}
