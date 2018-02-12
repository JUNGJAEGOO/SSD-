package back9205;

import java.util.*;

public class Main {
	static int startX,startY;
	static int N;
	static int endX,endY;
	static ArrayList<node> visit;
	static boolean v[];
	static boolean pass;
	static int inf = 100000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0 ) {
			
			N = in.nextInt()+2;
			visit = new ArrayList<>();
			for (int i = 0 ; i < N ; i++) {
				visit.add(new node(in.nextInt(),in.nextInt()));
			}

			v = new boolean[N];
			pass = false;
			
			int d[][] = new int[102][102];
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					d[i][j] = inf;
				}
			}
			
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					if ( i == j ) {
						continue;
					}
					node v = visit.get(i);
					node next = visit.get(j);
					int dist = Math.abs(v.x-next.x) + Math.abs(v.y-next.y);
					if ( dist <= 1000 ) {
						d[i][j] = 1;
					}
				}
			}
			
			
			for (int  k = 0 ;  k < N ; k++ ) {
				for (int i = 0 ; i < N ; i++) {
					for (int j = 0 ; j < N ; j++) {
						
						int x = visit.get(j).x;
						int y = visit.get(j).y;
						
						if ( d[i][j] > d[i][k] + d[k][j]) {
							d[i][j] = d[i][k] + d[k][j];
						}
					}	
				}
			}
			
			
			N-=2;
			if ( d[0][N+1] < inf && d[0][N+1] > 0) {
				pass = true;
			}
			
			if(pass) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			T--;
		}
	}

	public static class node{
		int x,y;
		node(int x,int y){
			this.x =x;
			this.y =y;
		}
	}
}
