package back1347;

import java.util.*;

public class Main {
	static char[] com;
	static char[][] mat;
	
	public static void main(String args[]) {
		Scanner in  = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		com = in.nextLine().toCharArray();
		
		mat = new char[110][110];
		for (int i = 0 ; i < 110 ; i++) {
			for ( int j = 0 ; j < 110 ; j++) {
				mat[i][j] = '#';
			}
		}
		
		int startX = 55;
		int startY = 55;
		int startDir = 2;
		// µ¿ 0 ¼­ 1 ³² 2 ºÏ 3
		BFS(startX,startY,startDir);
		
		int left = 1000;
		int right = -1;
		int up = 1000;
		int down = -1;
		
		for (int i = 0 ; i < 110 ; i++) {
			for (int j = 0 ; j < 110 ; j++) {
				if ( mat[i][j] == '.') {
					left = Math.min(left, j);
					right = Math.max(right, j);
					up = Math.min(up, i);
					down = Math.max(down, i);
				}
			}
		}
		
		System.out.println(up+" "+down+" "+left+" "+right);
		
		for ( int i = up ; i <= down ; i++) {
			for ( int j = left ; j <= right ; j++) {
				System.out.print(mat[i][j]);
			}System.out.println();
		}
	}
	
	public static void BFS(int startX,int startY,int startDir) {
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(startX,startY,startDir));
		
		for ( int i = 0 ; i < com.length+1 ; i++) {
		
			
			node now = q.poll();
			int x = now.x;
			int y = now.y;
			int dir = now.dir;
			mat[x][y] = '.';
			//System.out.println(x+" "+y+" "+dir);
			if ( i == com.length) {
				break;
			}
			
			if ( com[i] == 'F') {
				if ( dir == 0) {
					q.add(new node(x,y+1,dir));
				}else if ( dir == 1) {
					q.add(new node(x,y-1,dir));
				}else if ( dir == 2) {
					q.add(new node(x+1,y,dir));
				}else if ( dir == 3) {
					q.add(new node(x-1,y,dir));
				}
				
			}else if ( com[i] == 'R') {
				if ( dir == 0) {
					q.add(new node(x,y,2));
				}else if ( dir == 1) {
					q.add(new node(x,y,3));
				}else if ( dir == 2) {
					q.add(new node(x,y,1));
				}else if ( dir == 3) {
					q.add(new node(x,y,0));
				}
				
			}else if ( com[i] =='L') {
				if ( dir == 0) {
					q.add(new node(x,y,3));
				}else if ( dir == 1) {
					q.add(new node(x,y,2));
				}else if ( dir == 2) {
					q.add(new node(x,y,0));
				}else if ( dir == 3) {
					q.add(new node(x,y,1));
				}
			}
			
			
		}
		
	}
	
	public static class node{
		int x,y;
		int dir;
		node ( int x, int y, int dir){
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
}
