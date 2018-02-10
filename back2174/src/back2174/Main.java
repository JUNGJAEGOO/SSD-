package back2174;

import java.io.*;
import java.util.*;
public class Main {
	
	static int mat[][];
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		mat = new int[B+1][A+1];
		
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<Integer,node> robots = new HashMap<>();
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			mat[y][x] = i+1;
			char d = st.nextToken().charAt(0);
			if ( d == 'S') {
				robots.put(i+1,new node('N',y,x));
			}else if ( d == 'N') {
				robots.put(i+1,new node('S',y,x));
			}else {
				robots.put(i+1,new node(d,y,x));
			}
		}
		
		int crash;
		
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int idx = Integer.parseInt(st.nextToken());
			char com = st.nextToken().charAt(0);
			int banbok = Integer.parseInt(st.nextToken());
			for (int  j = 0 ; j < banbok ; j++) {
				if ( com == 'F') {
					node tmp = robots.get(idx);
					int X = tmp.x;
					int Y = tmp.y;
					char d = tmp.d;
					//System.out.println(X+" "+Y+" "+d);
					if ( d == 'S') {
						if ( X+1 > B) {
							System.out.println("Robot "+idx+" crashes into the wall");
							return;
						}
						if (mat[X+1][Y] != 0) {
							System.out.println("Robot "+idx+" crashes into robot "+mat[X+1][Y]);
							return;
						}
						mat[X][Y] = 0;
						mat[X+1][Y] = idx;
						tmp.x = X+1;
						robots.replace(idx, tmp);
					}else if ( d == 'E') {
						if ( Y+1 > A) {
							System.out.println("Robot "+idx+" crashes into the wall");
							return;
						}
						if ( mat[X][Y+1] != 0) {
							System.out.println("Robot "+idx+" crashes into robot "+mat[X][Y+1]);
							return;
						}
						mat[X][Y] = 0;
						mat[X][Y+1] = idx;
						tmp.y = Y+1;
						robots.replace(idx, tmp);
					}else if ( d == 'N') {
						if ( X - 1 <= 0) {
							System.out.println("Robot "+idx+" crashes into the wall");
							return;
						}
						if ( mat[X-1][Y] != 0) {
							System.out.println("Robot "+idx+" crashes into robot "+mat[X-1][Y]);
							return;
						}
						mat[X][Y] = 0;
						mat[X-1][Y] = idx;
						tmp.x = X-1;
						robots.replace(idx, tmp);
					}else {
						if ( Y -1 <= 0) {
							System.out.println("Robot "+idx+" crashes into the wall");
							return;
						}
						if ( mat[X][Y-1] != 0) {
							System.out.println("Robot "+idx+" crashes into robot "+mat[X][Y-1]);
							return;
						}
						mat[X][Y] = 0;
						mat[X][Y-1] = idx;
						tmp.y = Y-1;
						robots.replace(idx, tmp);
						
					}
					

				}else if (com == 'L'){ // 이게 오른쪽으로 회전
					node tmp = robots.get(idx);
					if ( tmp.d == 'W') {
						tmp.d = 'N';
					}else if ( tmp.d == 'E') {
						tmp.d = 'S';
					}else if ( tmp.d == 'S') {
						tmp.d = 'W';
					}else if ( tmp.d == 'N') {
						tmp.d = 'E';
					}
					robots.replace(idx, tmp);
				}else {  // 왼쪽으로 회전
					node tmp = robots.get(idx);
					if ( tmp.d == 'W') {
						tmp.d = 'S';
					}else if ( tmp.d == 'E') {
						tmp.d = 'N';
					}else if ( tmp.d == 'S') {
						tmp.d = 'E';
					}else if ( tmp.d == 'N') {
						tmp.d = 'W';
					}
					robots.replace(idx, tmp);
				}
			}
		}
		
		System.out.println("OK");
	}
	
	static class node{
		int x,y;
		char d;
		node (char d,int x,int y){
			this.d = d;
			this.x= x;
			this.y =y;
		}
	}

}
