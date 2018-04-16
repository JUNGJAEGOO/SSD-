package back15685;

import java.util.*;

public class Main {
	static int N;
	static boolean visit[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		visit = new boolean[101][101];
		for ( int i = 0 ; i < N ; i++) {
			int y = in.nextInt();
			int x = in.nextInt();
			int dir = in.nextInt();
			int g = in.nextInt();
			
			BFS(x,y,dir,g);
		}
		
		int sum = 0;
		for ( int i = 0 ; i < 100 ; i++) {
			for ( int j = 0 ; j < 100 ; j++) {
				/*if ( visit[i][j]) {
					System.out.print(1);
				}else {
					System.out.print(0);
				}*/
				if ( visit[i][j] && visit[i+1][j] && visit[i][j+1] && visit[i+1][j+1]) {
					sum++;
				}
				
			}
			//System.out.println();
		}
		System.out.print(sum);
	}
	
	public static void BFS(int x,int y,int dir,int g) {

		ArrayList<point> v = new ArrayList<>();
		v.add(new point(x,y));
		
		if ( dir == 0) {
			v.add(new point(x,y+1));
		}else if ( dir == 1) {
			v.add(new point(x-1,y));
		}else if ( dir == 2) {
			v.add(new point(x,y-1));
		}else if ( dir == 3) {
			v.add(new point(x+1,y));
		}

		int cnt = 0;
		
		while (  cnt < g ) {
			
			/*System.out.println("size "+v.size());
			for ( int i = 0 ; i < v.size() ; i++) {
				System.out.println(v.get(i).x+" "+v.get(i).y);
			}*/
			
			
			int nowX = v.get(v.size()-1).x;
			int nowY = v.get(v.size()-1).y;
			
			ArrayList<point> diff  = new ArrayList<>();
			
			for ( int i = v.size()-1 ; i >=  1 ; i--) {
				int diffX = v.get(i).x - v.get(i-1).x;
				int diffY = v.get(i).y - v.get(i-1).y;
				
				if ( dir == 0) {
				
						diffY = -diffY;
					
				}else if ( dir == 1) {
					
						diffY = -diffY;
					
				}else if ( dir == 2) {
					
						diffY = -diffY;
					
				}else if ( dir == 3) {
					
						diffY = -diffY;
					
				}
				
				//System.out.println("hashah"+diffY+" "+diffX);
				diff.add(new point(diffY,diffX));
				
			}
			
			
			//System.out.println("diff size "+diff.size());
			
			for ( int i = 0 ; i < diff.size() ; i++) {
				
				int nX = nowX + diff.get(i).x;
				int nY = nowY + diff.get(i).y;
				//System.out.println(nowX+" to "+nX+" , "+nowY+" to "+nY);
				
				v.add(new point(nX,nY));
				nowX = nowX + diff.get(i).x;
				nowY = nowY + diff.get(i).y;
				
			}
			
			//System.out.println(v.size());

			cnt++;
		}
		
		for ( int i = 0 ; i < v.size() ; i++) {
			//System.out.println(v.get(i).x +" " + v.get(i).y);
			if ( v.get(i).x >= 0 && v.get(i).y >= 0 && v.get(i).x <= 100 && v.get(i).y <= 100) {
				visit[v.get(i).x][v.get(i).y] = true;
			}
		}
		//System.out.println();
	}
	
	
	public static class point{
		int x,y;
		point ( int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
