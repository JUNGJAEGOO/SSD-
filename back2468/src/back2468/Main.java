package back2468;

import java.util.*;

import javafx.scene.Node;

public class Main {
	static int X[] = {1,0,-1,0};
	static int Y[] = {0,-1,0,1};
	static boolean visit[][];
	static int N;
	static int mat[][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		mat = new int[N][N];
		int min = 10000000,max = 0;
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
				if ( mat[i][j] > max) {
					max = mat[i][j];
				}
				if ( mat[i][j] < min) {
					min = mat[i][j];
				}
			}
		}
		int ans = 1;
		for (int i = min ; i <= max ; i++) {
			visit = new boolean[N][N];
			int cnt = 0;
			while ( true) {
				boolean pass = false;
				for (int s = 0 ; s < N ; s++) {
					for (int j = 0 ; j < N ; j++) {
						if ( mat[s][j] > i && visit[s][j] == false) {
							cnt++;
							BFS(i,s,j);	
							pass = true;
						}
					}
				}
				if (pass == false) {
					break;
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
		
	}
	public static void BFS(int height,int s,int k) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(s,k));
		visit[s][k] = true;
		while ( !q.isEmpty()) {
			node now = q.poll();
			int x= now.x;
			int y= now.y;
			for (int i = 0 ; i <4 ; i++) {
				int nx = x+X[i];
				int ny = y+Y[i];
				if ( nx >= 0 && nx < N && ny >= 0 && ny <N && visit[nx][ny] == false && mat[nx][ny] > height) {
					q.add(new node(nx,ny));
					visit[nx][ny] = true;
				}
			}
		}
	}
	public static class node{
		int x,y;
		node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}
