package back6087;

import java.util.*;

public class Main {
	static char mat[][];
	static int H,W;
	static int sX=-1,sY=-1,eX=-1,eY=-1;
	static int dir[][][];
	static int inf = 100000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(" ");
		W = Integer.parseInt(info[0]);
		H = Integer.parseInt(info[1]);
		mat = new char[H][W];
		
		for ( int i = 0 ; i < H ; i++ ) {
			
			char[] tmp = in.nextLine().toCharArray();
			for ( int j = 0 ; j < W ; j++) {
				mat[i][j] = tmp[j];
				if ( mat[i][j] == 'C') {
					if ( sX == -1) {
						sX = i;
						sY = j;
					}else {
						eX = i;
						eY = j;
					}
				}
			}
		}
		
		dir = new int[5][H][W];
		for ( int d = 0 ; d < 5 ; d++) {
			for ( int i = 0 ; i < H ; i++) {
				for ( int j = 0 ; j < W ; j++) {
					dir[d][i][j] = inf;
				}
			}
		}

		BFS();

		int min = inf;
		for  (int i = 1 ; i<= 4 ; i++ ) {
			if ( dir[i][eX][eY] < min ) {
				min = dir[i][eX][eY];
			}
		}
		System.out.print(min);
		
		
		
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		q.add(new node(sX,sY,1,0));
		q.add(new node(sX,sY,2,0));
		q.add(new node(sX,sY,3,0));
		q.add(new node(sX,sY,4,0));
		dir[1][sX][sY] = 0;
		dir[2][sX][sY] = 0;
		dir[3][sX][sY] = 0;
		dir[4][sX][sY] = 0;
		
		while ( !q.isEmpty() ) {
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			int cnt = now.cnt;
			int d = now.dir;
			System.out.println(d+" "+x+" "+y);
			
			if ( d == 1) { // ³²
				
				if ( x + 1 < H ) {
					if ( dir[1][x+1][y] > cnt && mat[x+1][y] != '*') {
						dir[1][x+1][y] = cnt;
						q.add(new node(x+1,y,1,cnt));
					}
				}
				if ( x - 1 >= 0  ) {
					if ( dir[2][x-1][y] > cnt+1 && mat[x-1][y] != '*') {
						dir[2][x-1][y] = cnt+1;
						q.add(new node(x-1,y,2,cnt+1));
					}
				}
				if ( y + 1 < W  ) {
					if ( dir[3][x][y+1] > cnt+1 && mat[x][y+1] != '*') {
						dir[3][x][y+1] = cnt+1;
						q.add(new node(x,y+1,3,cnt+1));
					}
				}
				if ( y - 1 >= 0  ) {
					if ( dir[4][x][y-1] > cnt+1 && mat[x][y-1] != '*') {
						dir[4][x][y-1] = cnt+1;
						q.add(new node(x,y-1,4,cnt+1));
					}
				}
				
				
			}else if ( d == 2) {  // ºÏ
				
				if ( x + 1 < H   ) {
					if ( dir[1][x+1][y] > cnt+1 && mat[x+1][y] != '*') {
						dir[1][x+1][y] = cnt+1;
						q.add(new node(x+1,y,1,cnt+1));
					}
				}
				if ( x - 1 >= 0  ) {
					if ( dir[2][x-1][y] > cnt && mat[x-1][y] != '*') {
						dir[2][x-1][y] = cnt;
						q.add(new node(x-1,y,2,cnt));
					}
				}
				if ( y + 1 < W  ) {
					if ( dir[3][x][y+1] > cnt+1 && mat[x][y+1] != '*') {
						dir[3][x][y+1] = cnt+1;
						q.add(new node(x,y+1,3,cnt+1));
					}
				}
				if ( y - 1 >= 0  ) {
					if ( dir[4][x][y-1] > cnt+1 && mat[x][y-1] != '*') {
						dir[4][x][y-1] = cnt+1;
						q.add(new node(x,y-1,4,cnt+1));
					}
				}
				
			}else if ( d == 3) { // µ¿
				if ( x + 1 < H   ) {
					if ( dir[1][x+1][y] > cnt+1 && mat[x+1][y] != '*') {
						dir[1][x+1][y] = cnt+1;
						q.add(new node(x+1,y,1,cnt+1));
					}
				}
				if ( x - 1 >= 0  ) {
					if ( dir[2][x-1][y] > cnt+1 && mat[x-1][y] != '*') {
						dir[2][x-1][y] = cnt+1;
						q.add(new node(x-1,y,2,cnt+1));
					}
				}
				if ( y + 1 < W  ) {
					if ( dir[3][x][y+1] > cnt && mat[x][y+1] != '*') {
						dir[3][x][y+1] = cnt;
						q.add(new node(x,y+1,3,cnt));
					}
				}
				if ( y - 1 >= 0  ) {
					if ( dir[4][x][y-1] > cnt+1 && mat[x][y-1] != '*') {
						dir[4][x][y-1] = cnt+1;
						q.add(new node(x,y-1,4,cnt+1));
					}
				}
			}else if ( d == 4) { // ¼­
				
				if ( x + 1 < H  ) {
					if ( dir[1][x+1][y] > cnt+1 && mat[x+1][y] != '*') {
						dir[1][x+1][y] = cnt+1;
						q.add(new node(x+1,y,1,cnt+1));
					}
				}
				if ( x - 1 >= 0  ) {
					if ( dir[2][x-1][y] > cnt+1 && mat[x-1][y] != '*') {
						dir[2][x-1][y] = cnt+1;
						q.add(new node(x-1,y,2,cnt+1));
					}
				}
				if ( y + 1 < W ) {
					if ( dir[3][x][y+1] > cnt+1  && mat[x][y+1] != '*') {
						dir[3][x][y+1] = cnt+1;
						q.add(new node(x,y+1,3,cnt+1));
					}
				}
				if ( y - 1 >= 0  ) {
					if ( dir[4][x][y-1] > cnt && mat[x][y-1] != '*') {
						dir[4][x][y-1] = cnt;
						q.add(new node(x,y-1,4,cnt));
					}
				}
				
			}
			
			
		}
	}
	
	public static class node{
		int x,y;
		int cnt;
		int dir;
		node ( int x,int y,int dir,int cnt){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
}
