package back13460;

import java.util.*;

public class Main {
	static char origin[][];
	static int N,M;
	static int ans = 1000;
	
	public static void main(String args[]) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(" ");
		N = Integer.parseInt(info[0]);
		M = Integer.parseInt(info[1]);
		origin = new char[N][M];
		for ( int i = 0 ; i < N ; i++) {
			char[] tmp = in.nextLine().toCharArray();
			for ( int j = 0 ; j < M ; j++) {
				origin[i][j] = tmp[j];
			}
		}

		
		BFS();
		
		if ( ans  == 1000) {
			System.out.println(-1);
		}else {
			System.out.print(ans);
		}
	}
	
	public static void BFS() throws InterruptedException {
		Queue<node> q  = new LinkedList<>();
		int x=0,y=0,z=0,w=0;
		for ( int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				if ( origin[i][j] == 'R') {
					origin[i][j] = '.';
					x= i; y =j;
				}
				if ( origin[i][j] == 'B') {
					origin[i][j] = '.';
					z = i; w = j;
				}
			}
		}
		q.add(new node(0,x,y,z,w));
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int Rx = now.Rx;
			int Ry = now.Ry;
			int Bx = now.Bx;
			int By = now.By;
			int cnt = now.cnt;
			//System.out.println(Rx+" "+Ry+" "+Bx+" "+By);
			
			if (  cnt > ans || cnt > 10) {
				continue;
			}
			
			if ( Bx == -1 || By == -1 ) {
				continue;
			}
			if ( (Bx != -1 && By != -1) && (Rx == -1 || Ry == -1) ) {
				ans = Math.min(ans, cnt);
				continue;
			}

			int up[][] = up(Rx,Ry,Bx,By);
			int down[][] = down(Rx,Ry,Bx,By);
			int left[][] = left(Rx,Ry,Bx,By);
			int right[][] = right(Rx,Ry,Bx,By);
			/*System.out.println("up: "+up[0][0]+" "+up[0][1]+" "+up[1][0]+" "+up[1][1]);
			System.out.println("down: "+down[0][0]+" "+down[0][1]+" "+down[1][0]+" "+down[1][1]);
			System.out.println("left: "+left[0][0]+" "+left[0][1]+" "+left[1][0]+" "+left[1][1]);
			System.out.println("right: "+right[0][0]+" "+right[0][1]+" "+right[1][0]+" "+right[1][1]);
			Thread.sleep(500);*/
			
			
			q.add(new node(cnt+1,up[0][0],up[0][1],up[1][0],up[1][1]));
			q.add(new node(cnt+1,down[0][0],down[0][1],down[1][0],down[1][1]));
			q.add(new node(cnt+1,left[0][0],left[0][1],left[1][0],left[1][1]));
			q.add(new node(cnt+1,right[0][0],right[0][1],right[1][0],right[1][1]));
			
		}
	}
	
	public static int[][] up(int Rx,int Ry,int Bx,int By){
		
		int nowRx = Rx,nowRy = Ry;
		int nowBx = Bx,nowBy = By;
		
		if ( Ry == By) {
			
			if ( Rx < Bx ) {
				while ( true ) {
					
					if ( origin[nowRx-1][nowRy] == '#') {
						break;
					}
					if ( origin[nowRx-1][nowRy] == 'O') {
						nowRx = -1;
						break;
					}

					nowRx--;
				}
				
				while ( true ) {
					
					if ( origin[nowBx-1][nowBy] == '#' || nowBx-1 == nowRx) {
						break;
					}
					if ( origin[nowBx-1][nowBy] == 'O') {
						nowBx = -1;
						break;
					}
					
					nowBx--;
				}
			}else {

				while ( true ) {
					
					if ( origin[nowBx-1][nowBy] == '#' ) {
						break;
					}
					if ( origin[nowBx-1][nowBy] == 'O') {
						nowBx = -1;
						break;
					}
					
					nowBx--;
				}
				
				while ( true ) {
					
					if ( origin[nowRx-1][nowRy] == '#' || nowRx-1 == nowBx ) {
						
						break;
					}
					if ( origin[nowRx-1][nowRy] == 'O') {
						nowRx = -1;
						break;
					}

					nowRx--;
				}
			}
	
		}else {
			
			while ( true ) {
				
				if ( origin[nowRx-1][nowRy] == '#') {
					break;
				}
				if ( origin[nowRx-1][nowRy] == 'O') {
					nowRx = -1;
					break;
				}

				nowRx--;
			}
			
			while ( true ) {
				
				if ( origin[nowBx-1][nowBy] == '#') {
					break;
				}
				if ( origin[nowBx-1][nowBy] == 'O') {
					nowBx = -1;
					break;
				}
				
				nowBx--;
			}
			
		}
		
		int res[][] = new int[2][2];
		res[0][0] = nowRx;
		res[0][1] = nowRy;
		res[1][0] = nowBx;
		res[1][1] = nowBy;
		return res;
	}
	
	public static int[][] down(int Rx,int Ry,int Bx,int By){
		
		int nowRx = Rx,nowRy = Ry;
		int nowBx = Bx,nowBy = By;
		
		if ( Ry == By) {
			
			if ( Rx > Bx ) {
				while ( true ) {
					
					if ( origin[nowRx+1][nowRy] == '#') {
						break;
					}
					if ( origin[nowRx+1][nowRy] == 'O') {
						nowRx = -1;
						break;
					}

					nowRx++;
				}
				
				while ( true ) {
					
					if ( origin[nowBx+1][nowBy] == '#' || nowBx+1 == nowRx) {
						break;
					}
					if ( origin[nowBx+1][nowBy] == 'O') {
						nowBx = -1;
						break;
					}
					
					nowBx++;
				}
			}else {

				while ( true ) {
					
					if ( origin[nowBx+1][nowBy] == '#') {
				
						break;
					}
					if ( origin[nowBx+1][nowBy] == 'O') {
						nowBx = -1;
						break;
					}
					
					nowBx++;
				}
				
				while ( true ) {
					
					if ( origin[nowRx+1][nowRy] == '#' || nowRx+1 == nowBx) {
						
						break;
					}
					if ( origin[nowRx+1][nowRy] == 'O') {
						nowRx = -1;
						break;
					}

					nowRx++;
				}
			}
	
		}else {
			
			while ( true ) {
				
				if ( origin[nowRx+1][nowRy] == '#') {
					break;
				}
				if ( origin[nowRx+1][nowRy] == 'O') {
					nowRx = -1;
					break;
				}

				nowRx++;
			}
			
			while ( true ) {
				
				if ( origin[nowBx+1][nowBy] == '#') {
					
					break;
				}
				if ( origin[nowBx+1][nowBy] == 'O') {
					nowBx = -1;
					break;
				}
				
				nowBx++;
			}
			
		}
		
		
		int res[][] = new int[2][2];
		res[0][0] = nowRx;
		res[0][1] = nowRy;
		res[1][0] = nowBx;
		res[1][1] = nowBy;
		return res;

	}
	
	public static int[][] left(int Rx,int Ry,int Bx,int By){
		
		int nowRx = Rx,nowRy = Ry;
		int nowBx = Bx,nowBy = By;
		
		if ( Rx == Bx) {
			
			if ( Ry < By ) {
				while ( true ) {
					
					if ( origin[nowRx][nowRy-1] == '#') {
						
						break;
					}
					if ( origin[nowRx][nowRy-1] == 'O') {
						nowRy = -1;
						break;
					}

					nowRy--;
				}
				
				while ( true ) {
					
					if ( origin[nowBx][nowBy-1] == '#' || nowBy-1 == nowRy) {
						
						break;
					}
					if ( origin[nowBx][nowBy-1] == 'O') {
						nowBy = -1;
						break;
					}
					
					nowBy--;
				}
			}else {

				while ( true ) {
					
					if ( origin[nowBx][nowBy-1] == '#') {
						
						break;
					}
					if ( origin[nowBx][nowBy-1] == 'O') {
						nowBy = -1;
						break;
					}
					
					nowBy--;
				}
				
				while ( true ) {
					
					if ( origin[nowRx][nowRy-1] == '#' || nowRy-1 == nowBy) {
						break;
					}
					if ( origin[nowRx][nowRy-1] == 'O') {
						nowRy = -1;
						break;
					}

					nowRy--;
				}
			}
	
		}else {
			
			while ( true ) {
				
				if ( origin[nowRx][nowRy-1] == '#') {
					break;
				}
				if ( origin[nowRx][nowRy-1] == 'O') {
					nowRy = -1;
					break;
				}

				nowRy--;
			}
			
			while ( true ) {
				
				if ( origin[nowBx][nowBy-1] == '#') {
					
					break;
				}
				if ( origin[nowBx][nowBy-1] == 'O') {
					nowBy = -1;
					break;
				}
				
				nowBy--;
			}
			
		}
		
		int res[][] = new int[2][2];
		res[0][0] = nowRx;
		res[0][1] = nowRy;
		res[1][0] = nowBx;
		res[1][1] = nowBy;
		return res;
		
	}
	
	public static int[][] right(int Rx,int Ry,int Bx,int By){
		int nowRx = Rx,nowRy = Ry;
		int nowBx = Bx,nowBy = By;
		
		if ( Rx == Bx) {
			
			if ( Ry > By ) {
				while ( true ) {
					
					if ( origin[nowRx][nowRy+1] == '#') {
						
						break;
					}
					if ( origin[nowRx][nowRy+1] == 'O') {
						nowRy = -1;
						break;
					}

					nowRy++;
				}
				
				while ( true ) {
					
					if ( origin[nowBx][nowBy+1] == '#' || nowBy+1 == nowRy) {
						
						break;
					}
					if ( origin[nowBx][nowBy+1] == 'O') {
						nowBy = -1;
						break;
					}
					
					nowBy++;
				}
			}else {

				while ( true ) {
					
					if ( origin[nowBx][nowBy+1] == '#') {
						break;
					}
					if ( origin[nowBx][nowBy+1] == 'O') {
						nowBy = -1;
						break;
					}
					
					nowBy++;
				}
				
				while ( true ) {
					
					if ( origin[nowRx][nowRy+1] == '#' || nowRy+1 == nowBy) {
						
						break;
					}
					if ( origin[nowRx][nowRy+1] == 'O') {
						nowRy = -1;
						break;
					}

					nowRy++;
				}
			}
	
		}else {
			
			while ( true ) {
				
				if ( origin[nowRx][nowRy+1] == '#') {
					break;
				}
				if ( origin[nowRx][nowRy+1] == 'O') {
					nowRy = -1;
					break;
				}

				nowRy++;
			}
			
			while ( true ) {
				
				if ( origin[nowBx][nowBy+1] == '#') {
					
					break;
				}
				if ( origin[nowBx][nowBy+1] == 'O') {
					nowBy = -1;
					break;
				}
				
				nowBy++;
			}
			
		}
		
		int res[][] = new int[2][2];
		res[0][0] = nowRx;
		res[0][1] = nowRy;
		res[1][0] = nowBx;
		res[1][1] = nowBy;
		return res;
	}
	
	public static class node{
		int Rx,Ry,Bx,By;
		int cnt;
		node ( int cnt,int Rx,int Ry,int Bx,int By){
			this.Rx = Rx;
			this.Ry = Ry;
			this.Bx = Bx;
			this.By = By;
			this.cnt = cnt;
		}
	}
}
