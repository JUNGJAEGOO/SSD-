package back14499;

import java.util.*;
import java.io.*;
public class Main {
	static int updown[];
	static int leftright[];
	static int map[][];
	static int realx,realy;
	static int N,M;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		updown = new int[4];
		leftright = new int[4];
		
		realx = x;
		realy = y;
		
		for ( int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for ( int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//1동2서3북4남
		st= new StringTokenizer(br.readLine()," ");
			
		for(int i = 0 ; i < K ; i++) {
			move(Integer.parseInt(st.nextToken()));
		}
		
	}
	
	public static void move(int op) {
		if ( op == 1) {  // 동
			if ( realy+1<M) {
				realy++;
				dice("right");
			}
		}else if ( op == 2) { // 서
			if ( realy-1>=0) {
				realy--;
				dice("left");
			}
		}else if ( op == 3) { // 북
			if ( realx-1>=0) {
				realx--;
				dice("up");
			}
		}else if ( op == 4) { // 남
			if ( realx+1<N) {
				realx++;
				dice("down");
			}
		}
	}
	
	public static void dice(String input) {
		if ( input.equals("right")) {
			if ( map[realx][realy] != 0) {
			int tmp = map[realx][realy];
			int a = leftright[0];
			int b = leftright[1];
			int c = leftright[2];
			int d = leftright[3];
			leftright[0] = tmp;
			leftright[1] = a;
			leftright[2] = b;  // 위
			leftright[3] = c;
			updown[2] = leftright[2];
			updown[0] = tmp;
			map[realx][realy] = 0;
			}else if (map[realx][realy] == 0) {
				int a = leftright[0];
				int b = leftright[1];
				int c = leftright[2];
				int d = leftright[3];
				leftright[0] = d;
				leftright[1] = a;
				leftright[2] = b;  // 위
				leftright[3] = c;
				updown[2] = leftright[2];
				updown[0] = leftright[0];
				map[realx][realy] = leftright[0];
			}
			
			System.out.println(leftright[2]);
			
			
		}else if(input.equals("left")){
			if ( map[realx][realy] != 0) {
			int tmp = map[realx][realy];
			int a = leftright[0];
			int b = leftright[1];
			int c = leftright[2];
			int d = leftright[3];
			leftright[0] = tmp;
			leftright[1] = c;
			leftright[2] = d;  // 위
			leftright[3] = a;
			updown[2] = leftright[2];
			updown[0] = tmp;
			map[realx][realy] = 0;
			}
			else if (map[realx][realy] == 0) {
				int a = leftright[0];
				int b = leftright[1];
				int c = leftright[2];
				int d = leftright[3];
				leftright[0] = b;
				leftright[1] = c;
				leftright[2] = d;  // 위
				leftright[3] = a;
				updown[2] = leftright[2];
				updown[0] = leftright[0];
				map[realx][realy] = leftright[0];
			}
			
			System.out.println(leftright[2]);
			
		}else if(input.equals("up")){
			if ( map[realx][realy] != 0) {
			int tmp = map[realx][realy];
			int a = updown[0];
			int b = updown[1];
			int c = updown[2];
			int d = updown[3];
			updown[0] = tmp;
			updown[1] = a;
			updown[2] = b;  // 위
			updown[3] = c;
			leftright[2] = updown[2];
			leftright[0] = tmp;
			map[realx][realy] = 0;}
			else if ( map[realx][realy] == 0) {
				int a = updown[0];
				int b = updown[1];
				int c = updown[2];
				int d = updown[3];
				updown[0] = d;
				updown[1] = a;
				updown[2] = b;  // 위
				updown[3] = c;
				leftright[2] = updown[2];
				leftright[0] = updown[0];
				map[realx][realy] = updown[0];
			}
			
			System.out.println(updown[2]);
		}else if(input.equals("down")){
			if ( map[realx][realy] != 0) {
			int tmp = map[realx][realy];
			int a = updown[0];
			int b = updown[1];
			int c = updown[2];
			int d = updown[3];
			updown[0] = tmp;
			updown[1] = c;
			updown[2] = d;  // 위
			updown[3] = a;
			leftright[2] = updown[2];
			leftright[0] = tmp;
			map[realx][realy] = 0;
			}
			else if ( map[realx][realy] == 0) {
				int a = updown[0];
				int b = updown[1];
				int c = updown[2];
				int d = updown[3];
				updown[0] = b;
				updown[1] = c;
				updown[2] = d;  // 위
				updown[3] = a;
				leftright[2] = updown[2];
				leftright[0] = updown[0];
				map[realx][realy] = updown[0];
			}
			
			System.out.println(updown[2]);
		}
	}
}
