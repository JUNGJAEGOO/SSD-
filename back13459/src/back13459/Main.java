package back13459;

import java.util.*;

public class Main {
	static int N,M;
	static char mat[][];
	static int Rx,Ry;
	static int Bx,By;
	static int Ox,Oy;
	static boolean pass = false;
	
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(" ");
		N = Integer.parseInt(info[0]);
		M = Integer.parseInt(info[1]);
		
		mat = new char[N][M];
		for ( int i = 0 ; i < N ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			for ( int j = 0 ; j < M ; j++) {
				
				mat[i][j] = tmp[j];
				if ( mat[i][j] == 'R') {
					Rx = i;
					Ry = j;
					mat[i][j] = '.';
				}
				if ( mat[i][j] == 'B') {
					Bx = i;
					By = j;
					mat[i][j] = '.';
				}
				if ( mat[i][j] == 'O') {
					Ox = i;
					Oy = j;
				}
				
			}
		}
		
		BFS();
		
		if( pass) {
			System.out.print(1);
		}else {
			System.out.print(0);
		}
		
		
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		q.add(new node(Rx,Ry,Bx,By,0));
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			
			int cnt = now.cnt;
			if( cnt > 10 ) {
				continue;
			}
			int rx = now.Rx;
			int ry = now.Ry;
			int bx = now.Bx;
			int by = now.By;
			//System.out.println(rx+" "+ry+" "+bx+" "+by+" "+cnt);
			
			if ( bx == Ox && by == Oy) {
				continue;
			}
			
			if ( rx == Ox && ry == Oy) {
				pass = true;
				break;
			}
			
			int one[][] = up(rx,ry,bx,by);
			int two[][] = down(rx,ry,bx,by);
			int three[][] = left(rx,ry,bx,by);
			int four[][] = right(rx,ry,bx,by);
			
			q.add(new node(one[0][0],one[0][1],one[1][0],one[1][1],cnt+1));
			q.add(new node(two[0][0],two[0][1],two[1][0],two[1][1],cnt+1));
			q.add(new node(three[0][0],three[0][1],three[1][0],three[1][1],cnt+1));
			q.add(new node(four[0][0],four[0][1],four[1][0],four[1][1],cnt+1));
			
		}
	}
	
	public static int[][] up(int rx,int ry,int bx,int by) {
		
		if ( ry == by) {
			
			if ( rx < bx) {
				while ( true ) {
					if ( mat[rx-1][ry] == '#' ) {
						break;
					}
					if ( mat[rx-1][ry] == 'O') {
						rx--;
						break;
					}
					rx--;
				}
				while ( true ) {
					if ( mat[bx-1][by] == '#' ) {
						break;
					}
					if( mat[bx-1][by] == 'O' ) {
						bx--;
						break;
					}
					if ( bx-1 == rx  ) {
						break;
					}
					bx--;
				}
			}else {
				
				while ( true ) {
					if ( mat[bx-1][by] == '#' ) {
						break;
					}
					if ( mat[bx-1][by] == 'O') {
						bx--;
						break;
					}
					bx--;
				}
				while ( true ) {
					if ( mat[rx-1][ry] == '#' ) {
						break;
					}
					if( mat[rx-1][ry] == 'O' ) {
						rx--;
						break;
					}
					if ( rx-1 == bx  ) {
						break;
					}
					rx--;
				}
			}
			
			
		}else {
			while ( true) {
				if ( mat[rx-1][ry] == '#') {
					break;
				}
				if ( mat[rx-1][ry] == 'O') {
					rx--;
					break;
				}
				rx--;
			}
			while ( true) {
				if ( mat[bx-1][by] == '#') {
					break;
				}
				if ( mat[bx-1][by] == 'O') {
					bx--;
					break;
				}
				bx--;
			}
		}
		
		int res[][] = new int[2][2];
		res[0][0] = rx;
		res[0][1] = ry;
		res[1][0] = bx;
		res[1][1] = by;
		
		return res;
		
	}

	public static int[][] down(int rx,int ry,int bx,int by) {
		
		if ( ry == by) {
			
			if ( rx > bx) {
				while ( true ) {
					if ( mat[rx+1][ry] == '#' ) {
						break;
					}
					if ( mat[rx+1][ry] == 'O') {
						rx++;
						break;
					}
					rx++;
				}
				while ( true ) {
					if ( mat[bx+1][by] == '#' ) {
						break;
					}
					if( mat[bx+1][by] == 'O' ) {
						bx++;
						break;
					}
					if ( bx+1 == rx  ) {
						break;
					}
					bx++;
				}
			}else {
				
				while ( true ) {
					if ( mat[bx+1][by] == '#' ) {
						break;
					}
					if ( mat[bx+1][by] == 'O') {
						bx++;
						break;
					}
					bx++;
				}
				while ( true ) {
					if ( mat[rx+1][ry] == '#' ) {
						break;
					}
					if( mat[rx+1][ry] == 'O' ) {
						rx++;
						break;
					}
					if ( rx+1 == bx  ) {
						break;
					}
					rx++;
				}
			}
			
			
		}else {
			while ( true) {
				if ( mat[rx+1][ry] == '#') {
					break;
				}
				if ( mat[rx+1][ry] == 'O') {
					rx++;
					break;
				}
				rx++;
			}
			while ( true) {
				if ( mat[bx+1][by] == '#') {
					break;
				}
				if ( mat[bx+1][by] == 'O') {
					bx++;
					break;
				}
				bx++;
			}
		}
		
		int res[][] = new int[2][2];
		res[0][0] = rx;
		res[0][1] = ry;
		res[1][0] = bx;
		res[1][1] = by;
		
		return res;
	}
	
	public static int[][] left(int rx,int ry,int bx,int by) {
		
		
	if ( rx == bx) {
			
			if ( ry < by) {
				while ( true ) {
					if ( mat[rx][ry-1] == '#' ) {
						break;
					}
					if ( mat[rx][ry-1] == 'O') {
						ry--;
						break;
					}
					ry--;
				}
				while ( true ) {
					if ( mat[bx][by-1] == '#' ) {
						break;
					}
					if( mat[bx][by-1] == 'O' ) {
						by--;
						break;
					}
					if ( by-1 == ry  ) {
						break;
					}
					by--;
				}
			}else {
				
				while ( true ) {
					if ( mat[bx][by-1] == '#' ) {
						break;
					}
					if ( mat[bx][by-1] == 'O') {
						by--;
						break;
					}
					by--;
				}
				while ( true ) {
					if ( mat[rx][ry-1] == '#' ) {
						break;
					}
					if( mat[rx][ry-1] == 'O' ) {
						ry--;
						break;
					}
					if ( ry-1 == by  ) {
						break;
					}
					ry--;
				}
			}
			
			
		}else {
			while ( true) {
				if ( mat[rx][ry-1] == '#') {
					break;
				}
				if ( mat[rx][ry-1] == 'O') {
					ry--;
					break;
				}
				ry--;
			}
			while ( true) {
				if ( mat[bx][by-1] == '#') {
					break;
				}
				if ( mat[bx][by-1] == 'O') {
					by--;
					break;
				}
				by--;
			}
		}
		
	
		int res[][] = new int[2][2];
		res[0][0] = rx;
		res[0][1] = ry;
		res[1][0] = bx;
		res[1][1] = by;
		
		return res;
	}
	
	public static int[][] right(int rx,int ry,int bx,int by) {
		
	if ( rx == bx) {
			
			if ( ry > by) {
				while ( true ) {
					if ( mat[rx][ry+1] == '#' ) {
						break;
					}
					if ( mat[rx][ry+1] == 'O') {
						ry++;
						break;
					}
					ry++;
				}
				while ( true ) {
					if ( mat[bx][by+1] == '#' ) {
						break;
					}
					if( mat[bx][by+1] == 'O' ) {
						by++;
						break;
					}
					if ( by+1 == ry  ) {
						break;
					}
					by++;
				}
			}else {
				
				while ( true ) {
					if ( mat[bx][by+1] == '#' ) {
						break;
					}
					if ( mat[bx][by+1] == 'O') {
						by++;
						break;
					}
					
					by++;
				}
				while ( true ) {
					if ( mat[rx][ry+1] == '#' ) {
						break;
					}
					if( mat[rx][ry+1] == 'O' ) {
						ry++;
						break;
					}
					if ( ry+1 == by  ) {
						break;
					}
					ry++;
				}
			}
			
			
		}else {
			while ( true) {
				if ( mat[rx][ry+1] == '#') {
					break;
				}
				if ( mat[rx][ry+1] == 'O') {
					ry++;
					break;
				}
				ry++;
			}
			while ( true) {
				if ( mat[bx][by+1] == '#') {
					break;
				}
				if ( mat[bx][by+1] == 'O') {
					by++;
					break;
				}
				by++;
			}
		}
	
		int res[][] = new int[2][2];
		res[0][0] = rx;
		res[0][1] = ry;
		res[1][0] = bx;
		res[1][1] = by;
		
		return res;
		
	}
	
	public static class node{
		int Rx,Ry,Bx,By;
		int cnt;
		node (int Rx,int Ry,int Bx,int By,int cnt){
			this.Rx = Rx;
			this.Ry = Ry;
			this.Bx = Bx;
			this.By = By;
			this.cnt = cnt;
		}
	}
}
