package back2234;

import java.util.*;
import java.io.*;
public class Main {
	static int N,M;
	static boolean visit[][];
	static int mat[][];
	static int nums[][];
	static int X[] = {-1,0,1,0};
	static int Y[] = {0,1,0,-1};
	public static void main(String args[]) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		//System.out.println((1<<0)+" "+(1<<1)+" "+(1<<2)+" "+(1<<3));
		
		
		mat = new int[N][M];
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0 ; j < M ; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		nums = new int[N][M];
		visit = new boolean[N][M];
		int rooms = 0;
		int large = 0;
		int cnt = 0;
		ArrayList<Integer> larges = new ArrayList<>();
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				if ( visit[i][j] == false) {
					int tmp = BFS(cnt,i,j);
					larges.add(tmp);
					large = Math.max(large, tmp);
					rooms++;
					cnt++;
				}
			}
		}
		System.out.println(rooms+"\n"+large);
		//System.out.println(larges+" "+cnt);
		ArrayList<Integer> adj[] = new ArrayList[cnt];
		for (int i = 0 ; i < cnt ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		/*for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				System.out.print(nums[i][j]+" ");
			}System.out.println();
		}*/
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				
				for (int k = 0 ; k  <4 ; k++) {
					int nx = i + X[k];
					int ny = j + Y[k];
					if ( nx >= 0 && nx < N && ny >= 0 && ny < M) {
						//System.out.println(i+", "+j);
						if ( nums[nx][ny] != nums[i][j]) {
							if ( !adj[nums[i][j]].contains(nums[nx][ny])) {
								adj[nums[i][j]].add(nums[nx][ny]);
							}
						}
					}
				}
				
			}
		}
		
		/*for (int i = 0 ; i < cnt ; i++) {
			System.out.println(adj[i]);
		}*/
		
		for (int i = 0 ; i < cnt ; i++) {
			for (int j = 0 ; j < adj[i].size() ; j++) {
				if ( larges.get(i) + larges.get(adj[i].get(j)) > large ){
					large = larges.get(i) + larges.get(adj[i].get(j));
				}
			}
		}
		
		System.out.println(large);
		
	}
	
	public static int BFS(int roomnum,int startX,int startY) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(startX,startY));
		visit[startX][startY] = true;
		nums[startX][startY] = roomnum;
		int width = 0;
		while(!q.isEmpty()) {
			
			node now = q.poll();
			int x=  now.x;
			int y=  now.y;
			nums[x][y] = roomnum;
			//System.out.println(x+" , "+y);
			//System.out.println(mat[x][y]&(1<<0));
			width++;
			// 0 은 북쪽 1 은 동쪽 2 는 남쪽 3 은 서쪽
			for (int i = 0 ; i < 4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				
				if ( i == 0) {
					if ( nx >= 0 && nx < N && ny >=0 && ny < M) {
						if ( visit[nx][ny] == false && ( (mat[x][y] & 1<<1 ) == 0 ) ) {
								visit[nx][ny] = true;
								q.add(new node(nx,ny));
						}
					}
				}else if ( i == 1) {
					if ( nx >= 0 && nx < N && ny >=0 && ny < M) {
						if ( visit[nx][ny] == false && ( (mat[x][y] & 1<<2 ) == 0 ) ) {
								visit[nx][ny] = true;
								q.add(new node(nx,ny));
						}
					}
				}else if ( i == 2) {
					if ( nx >= 0 && nx < N && ny >=0 && ny < M) {
						if ( visit[nx][ny] == false && ( (mat[x][y] & 1<<3 ) == 0 ) ) {
								visit[nx][ny] = true;
								q.add(new node(nx,ny));
						}
					}
				}else {
					if ( nx >= 0 && nx < N && ny >=0 && ny < M) {
						if ( visit[nx][ny] == false && ( (mat[x][y] & 1<<0 ) == 0 ) ) {
								visit[nx][ny] = true;
								q.add(new node(nx,ny));
						}
					}
				}	

			}
			
			
		}
		return width;
	
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
