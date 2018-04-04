package back4991;

import java.util.*;

public class Main {
	static int W,H;
	static char mat[][];
	static int cost[][][];
	static int sX,sY = 0;
	static int X[] = {0,1,0,-1};
	static int Y[] = {1,0,-1,0};
	static int inf = 1000000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while ( true ) {
			
			//System.out.println(1<<2);
			String info[] = in.nextLine().split(" ");
			W = Integer.parseInt(info[0]);
			H = Integer.parseInt(info[1]);
			//System.out.println(W+" "+H);
			if ( W == 0 && H == 0 ) {
				break;
			}
			mat = new char[H][W];
			int garbage = 0;
			
			ArrayList<Integer> Xlist = new ArrayList<>();
			ArrayList<Integer> Ylist = new ArrayList<>();
			
			for ( int i = 0 ; i < H  ; i ++) {
				char tmp[] = in.nextLine().toCharArray();
				for ( int j = 0 ; j < W ; j++) {
					
					mat[i][j] = tmp[j];
					if ( mat[i][j] == '*') {
						Xlist.add(i);
						Ylist.add(j);
						mat[i][j] = String.valueOf(garbage).charAt(0);
						garbage++;
					}
					if ( mat[i][j] == 'o') {
						sX = i;
						sY = j;
						mat[i][j] = '.';
					}
				}
			}
			
			/*for (int i = 0 ; i < H; i++) {
				for ( int j = 0 ; j < W ; j++) {
					System.out.print(mat[i][j]+" ");
				}System.out.println();
			}
			*/
			cost = new int[3001][H][W];
			for ( int i = 0 ; i <= 3000 ; i++) {
				for ( int j = 0 ; j < H ; j++) {
					for ( int k = 0 ; k < W ; k++) {
						cost[i][j][k] = inf;
					}
				}
			}
			
			BFS(garbage);
			
			int min = inf;
			for ( int i = 0 ; i < Xlist.size() ; i++) {
				int x = Xlist.get(i);
				int y = Ylist.get(i);
				if ( cost[(1<<garbage)-1][x][y] < min) {
					min = cost[(1<<garbage)-1][x][y];
				}
				
			}
			
			if ( min == inf) {
				System.out.println(-1);
			}else {
				System.out.println(min);
			}
		}
	}
	
	public static void BFS(int garbage) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(sX,sY,0,0));
		
		
		while ( !q.isEmpty() ) {
		
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			int c = now.cost;
			int left = now.leftGarbage;
			//System.out.println(x+" "+y+" "+left);
			
			for (int i = 0 ; i <4 ; i++) {
				int nx = x+X[i];
				int ny = y+Y[i];
				if ( nx>=0 && ny>= 0 && nx < H && ny < W ) {
					if ( mat[nx][ny] == '.' && cost[left][nx][ny] > c + 1) {
						cost[left][nx][ny] = c+1;
						q.add(new node(nx,ny,c+1,left));
					}
					//System.out.println(nx+" "+ny+" "+mat[nx][ny]);
					if ( mat[nx][ny] != '.' && mat[nx][ny] != 'x'  ) {
						
						int num = Integer.parseInt(String.valueOf(mat[nx][ny]));
						
						if ( cost[left|(1<<num)][nx][ny] > c + 1) {
							cost[(left|(1<<num))][nx][ny] = c + 1;
							q.add(new node(nx,ny,c+1,(left|(1<<num)) ));
						}
					}
				}
			}
			
			
		}
	}
	
	public static class node{
		int x,y;
		int cost;
		int leftGarbage;
		node ( int x,int y,int cost,int leftGarbage){
			this.x = x ;
			this.y = y;
			this.cost = cost;
			this.leftGarbage = leftGarbage;
		}
	}
}
