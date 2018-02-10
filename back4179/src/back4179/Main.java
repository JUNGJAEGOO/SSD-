package back4179;
// BFS 두개 돌리는게 핵심!
import java.util.*;

public class Main {
	static int R,C;
	static char[][] mat;
	static ArrayList<node> fire = new ArrayList<>();
	static int startX,startY;
	static int[][] Cost;
	static int inf = 1000000000;
	static int X[] = {-1,0,1,0};
	static int Y[] = {0,1,0,-1};
	static int ans;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		mat =new char[R][C];
		for (int i = 0 ; i < R ; i++) {
			char[] tmp = in.nextLine().toCharArray();
			for (int j = 0 ; j < C ; j++) {
				mat[i][j] = tmp[j];
				if ( mat[i][j] == 'J') {
					startX = i;
					startY = j;
				}
				if ( mat[i][j] == 'F' ) {
					fire.add(new node(i,j,0));
				}
			}
		}
		
		Cost = new int[R][C];
		for (int i = 0 ; i < R;  i++) {
			for (int j = 0 ; j < C ; j++) {
				Cost[i][j] = inf;
			}
		}
		BFS();
		if ( ans == inf) {
			System.out.println("IMPOSSIBLE");
		}else {
			System.out.println(ans);
		}
	/*	for (int i = 0 ; i < R ; i++) {
			for ( int j = 0 ; j <C ; j++) {
				System.out.print(mat[i][j]);
			}System.out.print("\n");
		}*/
		
		
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		Queue<node> q2 = new LinkedList<>();
		q.add(new node(startX,startY,0));
		Cost[startX][startY] = 0;
		Queue<node> Fire = new LinkedList<>();
		Queue<node> Fire2 = new LinkedList<>();
		for (int i = 0 ; i < fire.size() ; i++) {
			Fire.add(new node(fire.get(i).x,fire.get(i).y,0));
		}
		
		int flag = 1;
		ans = inf;
		//System.out.println(Fire.size() +" "+ q.size());
		while ( true ) {
			
			if ( flag == 1) {
				if ( Fire.isEmpty() && q.isEmpty()) {
					break;
				}
			}else {
				if ( Fire2.isEmpty() && q2.isEmpty()) {
					break;
				}
			}
			
			if ( flag == 1) {
				while ( !Fire.isEmpty() ) {
					node f = Fire.poll();
					int x = f.x;
					int y = f.y;
					//System.out.println(x+" "+y);
					for (int  i = 0 ; i < 4 ; i++) {
						int nx = x + X[i];
						int ny = y + Y[i];
						if ( nx >= 0 && nx < R && ny >= 0 && ny < C) {
							if ( mat[nx][ny] == 'J' || mat[nx][ny] == '.') {
								Fire2.add(new node(nx,ny,0));
								mat[nx][ny] = 'F';
							}
						}
					}
				}
				
				while ( !q.isEmpty() ) {
					node tmp = q.poll();
					int x = tmp.x;
					int y = tmp.y;
					int cost = tmp.cost;
					
					if ( x == R-1 || x == 0 || y == 0 || y == C-1 ) {
						//System.out.println(cost+1);
						ans = Math.min(ans, cost+1);
					}
					
					for (int  i = 0 ; i < 4 ; i++) {
						int nx = x + X[i];
						int ny = y + Y[i];
						if ( nx >= 0 && nx < R && ny >= 0 && ny < C) {
							if ( mat[nx][ny] == 'J' || mat[nx][ny] == '.') {
								if ( Cost[nx][ny] > cost + 1) {
									q2.add(new node(nx,ny,cost+1));
									mat[nx][ny] = 'J';
									Cost[nx][ny] = cost + 1;
								}
							}
						}
					}
				}
				
				flag = 0;
			}else {
				while ( !Fire2.isEmpty() ) {
					node f = Fire2.poll();
					int x = f.x;
					int y = f.y;
					
					for (int  i = 0 ; i < 4 ; i++) {
						int nx = x + X[i];
						int ny = y + Y[i];
						if ( nx >= 0 && nx < R && ny >= 0 && ny < C) {
							if ( mat[nx][ny] == 'J' || mat[nx][ny] == '.') {
								Fire.add(new node(nx,ny,0));
								mat[nx][ny] = 'F';
							}
						}
					}
				}
				
				while ( !q2.isEmpty() ) {
					node tmp = q2.poll();
					int x = tmp.x;
					int y = tmp.y;
					int cost = tmp.cost;
					
					if ( x == R-1 || x == 0 || y == 0 || y == C-1 ) {
						//System.out.println(cost+1);
						ans = Math.min(ans, cost+1);
					}
					
					for (int  i = 0 ; i < 4 ; i++) {
						int nx = x + X[i];
						int ny = y + Y[i];
						if ( nx >= 0 && nx < R && ny >= 0 && ny < C) {
							if ( mat[nx][ny] == 'J' || mat[nx][ny] == '.') {
								if ( Cost[nx][ny] > cost + 1) {
									q.add(new node(nx,ny,cost+1));
									mat[nx][ny] = 'J';
									Cost[nx][ny] = cost + 1;
								}
							}
						}
					}
				}
				flag = 1;
			}
			
			
		}
		
	}
	
	
	
	public static class node{
		int x,y;
		int cost;
		node ( int x, int y, int cost){
			this.x =x;
			this.y =y;
			this.cost = cost;
		}
	}
}
