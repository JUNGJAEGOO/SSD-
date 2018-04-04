package back2564;

import java.util.*;

public class Main {
	static int R,C;
	static int sX=-1,sY=-1;
	static ArrayList<node> list = new ArrayList<>();
	static int X[] = {-1,0,1,0};
	static int Y[] = {0,1,0,-1};
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		C = in.nextInt();
		R = in.nextInt();
		int N = in.nextInt();
		for ( int i = 0 ; i < N ; i++) {
			int dir = in.nextInt();
			int dist = in.nextInt();
			if ( dir == 1) {
				list.add(new node(dist,R,0));
			}else if ( dir == 2) {
				list.add(new node(dist,0,0));
			}else if ( dir == 3) {
				list.add(new node(0,R-dist,0));
			}else if ( dir == 4 ) {
				list.add(new node(C,R-dist,0));
			}
			
		}
		
		int direction = in.nextInt();
		int distance = in.nextInt();
		
		if ( direction == 1) {
			sX = distance;
			sY = R;
		}else if ( direction == 2) {
			sX = distance;
			sY = 0;
		}else if ( direction == 3) {
			sX = 0;
			sY = R-distance;
		}else if ( direction == 4) {
			sX = C;
			sY = R-distance;
		}
		
		int sum = 0;
		boolean visit[][] = new boolean[C+1][R+1];
		for ( int i = 1 ; i < C ; i++) {
			for( int j = 1 ; j < R ; j++) {
				visit[i][j] = true;
			}
		}
		
		for (int i = 0 ; i < N ; i++) {
			int x = list.get(i).x;
			int y = list.get(i).y;
			visit = new boolean[C+1][R+1];
			for ( int s = 1 ; s < C ; s++) {
				for( int k = 1 ; k< R ; k++) {
					visit[s][k] = true;
				}
			}
			
			//System.out.println(x+" , "+y);
			sum += BFS(visit,x,y);
		}
		
		System.out.print(sum);
		
	}
	
	public static int BFS(boolean visit[][],int xx,int yy) {
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(sX,sY,0));
		visit[sX][sY] = true;
		int min = 10000000;
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			int cnt = now.cnt;
			//System.out.println(x+" "+y);
			if( x == xx && y == yy ) {
				min = Math.min(min, cnt);
				continue;
			}
			
			for ( int i = 0 ; i < 4 ; i++) {
				int nx = x + X[i];
				int ny = y + Y[i];
				if( nx >= 0 && ny >= 0 && nx <= C && ny <= R && visit[nx][ny] == false) {
					visit[nx][ny] = true;
					q.add(new node(nx,ny,cnt+1));
				}
			}
		}
		
		//System.out.println(min);
		return min;
	}
	
	public static class node{
		int x,y;
		int cnt;
		node (int x,int y,int cnt){
			this.x = x;
			this.y =y;
			this.cnt = cnt;
			
		}
	}
}
