package back2146;

import java.util.*;
// BFS�� �ι� �ϴ� �� �ٽ�. ( ù��°�� �÷���, �ι�°�� �Ÿ� ã�� )
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
		/// ���� �ٸ��� �������ؼ��� BFS�� ������ �÷����� �ʿ� �մϴ�!!!
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
		
		// �� �ٽ� BFS�� �÷����� ������ �ٸ������� �������� �ڽ�Ʈ ���� �����մϴ�.
		int res = inf;
		for (int i = 1 ; i <= flag-1 ; i++) {
			for (int s= 0 ; s < N ; s++) {
				for (int k = 0 ; k <N ; k++) {
					cost[i][s][k] = inf;
				}
			}
			res = Math.min(res,BFS2(i));
		}
		// � �� -> �ٸ� ������ ������ �ּڰ��� ����մϴ�.
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
			// �ٸ������� �����ϴ� ����� ���̰��� ������ �� BFS���� Ŀ���ع���.
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
