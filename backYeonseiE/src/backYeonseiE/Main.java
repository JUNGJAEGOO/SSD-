package backYeonseiE;

import java.util.*;

public class Main {
	
	static char mat[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		mat = new char[6][6];
		for ( int i = 0 ; i < 6 ; i++) {
			for ( int j = 0 ; j < 6 ; j++) {
				mat[i][j] = '.';
			}
		}
		
		mat[2][2] = 'W';
		mat[3][3] = 'W';
		mat[2][3] = 'B';
		mat[3][2] = 'B';
	
		
	/*	
		mat[0][2] = 'W';
		mat[1][0] = 'B';
		mat[1][1] = 'W';
		mat[1][2] = 'W';
		mat[1][3] = 'B';
		mat[1][4] = 'B';
		
		mat[2][0] = 'W';
		mat[2][1] = 'B';
		mat[2][2] = 'W';
		mat[2][3] = 'W';
		
		mat[3][0] = 'W';
		mat[3][1] = 'W';
		mat[3][2] = 'B';
		mat[3][3] = 'B';
		mat[3][4] = 'B';
		
		mat[4][2] = 'W';
		mat[4][3] = 'W';
		mat[4][4] = 'B';
		*/
		
		
		
		char flag = 'B';
		while ( T>  0) {
			
			
			int x = in.nextInt() -1;
			int y = in.nextInt() -1;
			mat[x][y] = flag;
			
			leftUP(x,y,flag);
			UP(x,y,flag);
			rightUP(x,y,flag);
			left(x,y,flag);
			right(x,y,flag);
			leftDOWN(x,y,flag);
			DOWN(x,y,flag);
			rightDOWN(x,y,flag);
			
			/*for ( int i = 0 ; i < 6 ; i++) {
				for (int j= 0 ; j < 6 ; j++) {
					System.out.print(mat[i][j]);
				}System.out.println();
			}System.out.println();
			*/
			if ( flag == 'W') {
				flag = 'B';
			}else {
				flag = 'W';
			}
			
			T--;
		}
		
		for ( int i = 0 ; i < 6 ; i++) {
			for (int j= 0 ; j < 6 ; j++) {
				System.out.print(mat[i][j]);
			}System.out.println();
		}
		
		int sumW = 0;
		int sumB = 0;
		for ( int i = 0 ; i < 6 ; i++) {
			for (int j= 0 ; j < 6 ; j++) {
				if (mat[i][j] == 'B') {
					sumB++;
				}else if ( mat[i][j] =='W') {
					sumW++;
				}
			}
		}
		
		if ( sumW > sumB) {
			System.out.print("White");
		}else if ( sumB > sumW) {
			System.out.print("Black");
		}
	}
	
	public static void leftUP(int x,int y,char flag) {
		
		int nowX = x;
		int nowY = y;
		ArrayList<node> list = new ArrayList<>();
		boolean pass = false;
		int cnt = 0;
		while ( true ) {
			
			nowX--;
			nowY--;
			cnt++;
			if ( nowX < 0 || nowY < 0) {
				break;
			}
			if ( mat[nowX][nowY] == flag) {
				pass = true;
				break;
			}
			
			if ( mat[nowX][nowY] != flag &&  mat[nowX][nowY] != '.') {
				
				list.add(new node(nowX,nowY));
			}
			
		}
		
		if ( pass  && cnt  == list.size() + 1) {
			for ( int i = 0 ; i < list.size(); i++) {
				int X = list.get(i).x;
				int Y = list.get(i).y;
				mat[X][Y] = flag;
			}
		}
	}
	
	public static void UP(int x,int y,char flag) {
			
		int nowX = x;
		int nowY = y;
		ArrayList<node> list = new ArrayList<>();
		boolean pass = false;
		int cnt = 0;
		while ( true ) {
			
			nowX--;
			cnt++;
			if ( nowX < 0) {
				break;
			}
			if ( mat[nowX][nowY] == flag) {
				pass = true;
				break;
			}
			
			if ( mat[nowX][nowY] != flag &&  mat[nowX][nowY] != '.') {
				
				list.add(new node(nowX,nowY));
			}
			
		}
		
		if ( pass  && cnt  == list.size() + 1) {
			for ( int i = 0 ; i < list.size(); i++) {
				int X = list.get(i).x;
				int Y = list.get(i).y;
				mat[X][Y] = flag;
			}
		}
		
	}
	
	public static void rightUP(int x,int y,char flag) {
		
		int nowX = x;
		int nowY = y;
		ArrayList<node> list = new ArrayList<>();
		boolean pass = false;
		int cnt = 0;
		while ( true ) {
			
			nowX--;
			nowY++;
			cnt++;
			if ( nowX < 0 || nowY >= 6) {
				break;
			}
			if ( mat[nowX][nowY] == flag) {
				pass = true;
				break;
			}
			
			if ( mat[nowX][nowY] != flag &&  mat[nowX][nowY] != '.') {
				
				list.add(new node(nowX,nowY));
			}
			
		}
		
		if ( pass  && cnt  == list.size() + 1) {
			for ( int i = 0 ; i < list.size(); i++) {
				int X = list.get(i).x;
				int Y = list.get(i).y;
				mat[X][Y] = flag;
			}
		}
	}
	
	public static void left(int x,int y,char flag) {
		
		int nowX = x;
		int nowY = y;
		ArrayList<node> list = new ArrayList<>();
		boolean pass = false;
		int cnt = 0;
		while ( true ) {
			
			nowY--;
			cnt++;
			if ( nowY < 0) {
				break;
			}
			if ( mat[nowX][nowY] == flag) {
				pass = true;
				break;
			}
			
			if ( mat[nowX][nowY] != flag &&  mat[nowX][nowY] != '.') {
				
				list.add(new node(nowX,nowY));
			}
			
		}
		
		//System.out.print(cnt +" "+list.size());
		if ( pass  && cnt  == list.size() + 1) {
			for ( int i = 0 ; i < list.size(); i++) {
				int X = list.get(i).x;
				int Y = list.get(i).y;
				mat[X][Y] = flag;
			}
		}
		
	}
	
	public static void right(int x,int y,char flag) {
		
		int nowX = x;
		int nowY = y;
		ArrayList<node> list = new ArrayList<>();
		boolean pass = false;
		
		int cnt = 0;
		while ( true ) {
			
			nowY++;
			cnt++;
			if ( nowY >= 6) {
				break;
			}
			if ( mat[nowX][nowY] == flag) {
				pass = true;
				break;
			}
			
			if ( mat[nowX][nowY] != flag &&  mat[nowX][nowY] != '.') {
				
				list.add(new node(nowX,nowY));
			}
			
			
		}
		
		//System.out.println(cnt+" "+list.size());
		
		if ( pass && cnt == list.size() + 1) {
			for ( int i = 0 ; i < list.size(); i++) {
				int X = list.get(i).x;
				int Y = list.get(i).y;
				mat[X][Y] = flag;
			}
		}
		
	}
	
	public static void leftDOWN(int x,int y,char flag) {
		
		int nowX = x;
		int nowY = y;
		ArrayList<node> list = new ArrayList<>();
		boolean pass = false;
		int cnt = 0;
		while ( true ) {
			
			nowX++;
			nowY--;
			cnt++;
			if ( nowX >= 6 || nowY < 0) {
				break;
			}
			if ( mat[nowX][nowY] == flag) {
				pass = true;
				break;
			}
			
			if ( mat[nowX][nowY] != flag &&  mat[nowX][nowY] != '.') {
				
				list.add(new node(nowX,nowY));
			}
			
			
		}
		
		if ( pass  && cnt == list.size() +1 ) {
			for ( int i = 0 ; i < list.size(); i++) {
				int X = list.get(i).x;
				int Y = list.get(i).y;
				mat[X][Y] = flag;
			}
		}
		
	}
	
	public static void DOWN(int x,int y,char flag) {
		
		int nowX = x;
		int nowY = y;
		ArrayList<node> list = new ArrayList<>();
		boolean pass = false;
		int cnt = 0;
		while ( true ) {
			cnt++;
			nowX++;
			if ( nowX >= 6) {
				break;
			}
			if ( mat[nowX][nowY] == flag) {
				pass = true;
				break;
			}
			
			if ( mat[nowX][nowY] != flag &&  mat[nowX][nowY] != '.') {
				
				list.add(new node(nowX,nowY));
			}
			
		}
		
		if ( pass  && cnt == list.size() +1 ) {
			for ( int i = 0 ; i < list.size(); i++) {
				int X = list.get(i).x;
				int Y = list.get(i).y;
				mat[X][Y] = flag;
			}
		}
		
	}
	
	public static void rightDOWN(int x,int y,char flag) {
		
		int nowX = x;
		int nowY = y;
		ArrayList<node> list = new ArrayList<>();
		boolean pass = false;
		int cnt = 0;
		while ( true ) {
			cnt++;
			nowX++;
			nowY++;
			if ( nowX >= 6 || nowY >= 6) {
				break;
			}
			if ( mat[nowX][nowY] == flag) {
				pass = true;
				break;
			}
			
			if ( mat[nowX][nowY] != flag &&  mat[nowX][nowY] != '.') {
				
				list.add(new node(nowX,nowY));
			}
			
		}
		
		if ( pass && cnt == list.size() +1 ) {
			for ( int i = 0 ; i < list.size(); i++) {
				int X = list.get(i).x;
				int Y = list.get(i).y;
				mat[X][Y] = flag;
			}
		}
		
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
