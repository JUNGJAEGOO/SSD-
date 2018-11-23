package back16433;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,R,C;
	static char[][] mat;
	static boolean visit[][];
	static int xx[] = {1,1,-1,-1};
	static int yy[] = {-1,1,1,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mat = new char[N][N];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = '.';
			}
		}
		visit = new boolean[N][N];
		mat[R-1][C-1] = 'v';
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				if ( visit[i][j] == false && mat[i][j] == 'v') {
					BFS(i,j);
				}
			}
		}
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				System.out.print(mat[i][j]);
			}System.out.println();
		}
 	}
	
	public static void BFS(int x,int y) {
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(x,y));
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int X = now.x;
			int Y = now.y;
			
			for ( int i = 0 ; i <4 ; i++) {
				int nx = X + xx[i];
				int ny = Y + yy[i];
				
				if ( nx >= 0 && ny >= 0 && nx < N && ny < N ) {
					if ( visit[nx][ny] == false) {
						visit[nx][ny] = true;
						q.add(new node(nx,ny));
						mat[nx][ny] = 'v';
					}
				}
			}
			
		}
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
