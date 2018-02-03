package back2146;

import java.util.*;
// BFS를 두번 하는 게 핵심. ( 첫번째는 플래깅, 두번째는 거리 찾기 )
public class Main {
	static int N;
	static final int inf = 100000000;
	static int flag = 1;
	static int mat[][];
	static boolean visit[][];
	static int X[] = {1,0,-1,0};
	static int Y[] = {0,1,0,-1};
	static int cost[][][];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		mat = new int[N][N];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		/// 먼저 다리를 놓기위해서는 BFS로 섬마다 플래깅이 필요 합니다!!!
		visit = new boolean[N][N];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if ( mat[i][j] == 1 && visit[i][j] == false ) {
					BFS(i,j);
					flag++;
				}
				
			}
		}   
		
		/*for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				System.out.print(mat[i][j]+" ");
			}System.out.println();
		}
		System.out.println();*/
		
		cost = new int[flag][N][N];
		
		// 또 다시 BFS로 플래깅한 섬마다 다른섬으로 갈때에의 코스트 값을 저장합니다.
		int res = inf;
		for (int i = 1 ; i <= flag-1 ; i++) {
			for (int s= 0 ; s < N ; s++) {
				for (int k = 0 ; k <N ; k++) {
					cost[i][s][k] = inf;
				}
			}
			res = Math.min(res,BFS2(i));
		}
		// 어떤 섬 -> 다른 섬으로 갈때의 최솟값을 출력합니다.
		System.out.println(res-1);
		
		/*for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if ( cost[1][i][j] == inf) {
					System.out.print("x ");
				}else {
					System.out.print(cost[1][i][j]+" ");
				}
			}System.out.println();
		}*/
		
	}
	
	public static void BFS(int startX,int startY) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(startX,startY));
		mat[startX][startY] = flag;
		visit[startX][startY] = true;
		while( !q.isEmpty()) {
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			for (int i = 0 ; i < 4 ; i++) {
				if ( x+X[i] >= 0 && x+X[i] < N && y+Y[i] < N && y+Y[i] >= 0) {
					if ( mat[x+X[i]][y+Y[i]] == 1 && visit[x+X[i]][y+Y[i]] == false) {
						mat[x+X[i]][y+Y[i]] = flag;
						q.add(new node(x+X[i],y+Y[i]));
						visit[x+X[i]][y+Y[i]]=true;
					}
					
				}
			}
		}
	}
	
	public static int BFS2(int flagging) {
		Queue<node2> q = new LinkedList<>();
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if ( mat[i][j] == flagging) {
					cost[flagging][i][j] = 0;
					q.add(new node2(i,j,0));
				}
			}
		}
		int ans = inf;
		while( !q.isEmpty()) {
			node2 now = q.poll();
			int x = now.x;
			int y = now.y;
			int Cost = now.cost;
			// 다른섬으로 도착하는 노드의 길이값은 저장한 후 BFS에서 커팅해버림.
			if ( mat[x][y] != flagging && mat[x][y] != 0) {
				ans = Math.min(ans,Cost );
				continue;
			}
			for (int i = 0 ; i < 4 ; i++) {
				if ( x+X[i] >= 0 && x+X[i] < N && y+Y[i] < N && y+Y[i] >= 0) {
					
					if ( mat[x+X[i]][y+Y[i]] != flagging && cost[flagging][x+X[i]][y+Y[i]] > Cost+ 1) {
						cost[flagging][x+X[i]][y+Y[i]] = Cost+1;
						q.add(new node2(x+X[i],y+Y[i],Cost+1));
					}
					
				}
			}
		}
		
		return ans;
	}
	
	public static class node2{
		int x,y;
		int cost;
		node2 (int x,int y,int cost){
			this.x= x;
			this.y =y;
			this.cost =cost;
		}
	}
	
	public static class node{
		int x,y;
		node(int x,int y){
			this.x= x;
			this.y =y;
		}
	}
}
