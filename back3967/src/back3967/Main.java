package back3967;

import java.util.*;

public class Main {
	
	static ArrayList<Character> list = new ArrayList<>();
	static boolean visit[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char mat[][]= new char[5][9];
		
		//System.out.println('A'-'A');
		//System.out.println('Z'-'x');
		//System.out.println((char)('A'+11));
		visit = new boolean[12];
		
		for ( int i = 0 ; i < 5 ; i++) {
			char[] tmp = in.nextLine().toCharArray();
			for ( int j = 0 ; j < 9 ; j++) {
				mat[i][j] = tmp[j];
				if ( tmp[j] != '.') {
					if ( tmp[j] != 'x') {
						visit[tmp[j]-'A'] = true;
					}
					list.add(tmp[j]);
				}
			}
		}
		
		
		make(0);
		
	}
	
	public static void make(int idx ) {
		
		int sumA = 0;
		int sumB = 0;
		int sumC = 0;
		int sumD = 0;
		int sumE = 0;
		int sumF = 0;
		//System.out.println("NEW "+list);
		
		if ( list.get(1) != 'x' && list.get(2) != 'x' && list.get(3) != 'x' && list.get(4) != 'x') {
			sumA = (int)(list.get(1)-'A') + (int)(list.get(2)-'A') + (int)(list.get(3)-'A') + (int)(list.get(4)-'A');
			if ( sumA != 22) {
				return;
			}
		}
		
		if ( list.get(7) != 'x' && list.get(8) != 'x' && list.get(9) != 'x' && list.get(10) != 'x') {
			sumB = (int)(list.get(7)-'A') + (int)(list.get(8)-'A') + (int)(list.get(9)-'A') + (int)(list.get(10)-'A');
			if ( sumB != 22) {
				return;
			}
		}
		
		if ( list.get(0) != 'x' && list.get(2) != 'x' && list.get(5) != 'x' && list.get(7) != 'x') {
			sumC = (int)(list.get(0)-'A') + (int)(list.get(2)-'A') + (int)(list.get(5)-'A') + (int)(list.get(7)-'A');
			if ( sumC != 22) {
				return;
			}
		}
		
		if ( list.get(0) != 'x' && list.get(3) != 'x' && list.get(6) != 'x' && list.get(10) != 'x') {
			sumD = (int)(list.get(0)-'A') + (int)(list.get(3)-'A') + (int)(list.get(6)-'A') + (int)(list.get(10)-'A');
			if ( sumD != 22) {
				return;
			}
		}
		
		if ( list.get(1) != 'x' && list.get(5) != 'x' && list.get(8) != 'x' && list.get(11) != 'x') {
			sumE = (int)(list.get(1)-'A') + (int)(list.get(5)-'A') + (int)(list.get(8)-'A') + (int)(list.get(11)-'A');
			if ( sumE != 22) {
				return;
			}
		}
		
		if ( list.get(4) != 'x' && list.get(6) != 'x' && list.get(9) != 'x' && list.get(11) != 'x') {
			sumF = (int)(list.get(4)-'A') + (int)(list.get(6)-'A') + (int)(list.get(9)-'A') + (int)(list.get(11)-'A');
			if ( sumF != 22) {
				return;
			}
		}
		
		//System.out.println(idx+" "+list);
		
		if ( idx == 12) {
			//System.out.println(list);
			char[][] res = new char[5][9];
			for ( int i = 0 ; i < 5 ; i ++) {
				for ( int j = 0 ; j < 9 ; j ++) {
					res[i][j] = '.';
				}
			}
			
			res[0][4] = list.get(0);
			
			res[1][1] = list.get(1);
			res[1][3] = list.get(2);
			res[1][5] = list.get(3);
			res[1][7] = list.get(4);
			
			res[2][2] = list.get(5);
			res[2][6] = list.get(6);
			
			res[3][1] = list.get(7);
			res[3][3] = list.get(8);
			res[3][5] = list.get(9);
			res[3][7] = list.get(10);
			
			res[4][4] = list.get(11);
			
			for ( int i = 0 ; i < 5 ; i++) {
				for ( int j = 0 ; j < 9 ; j++) {
					System.out.print(res[i][j]);
				}System.out.println();
			}
			
			System.exit(0);
		}

		if ( list.get(idx) == 'x') {
			
			for ( int i = 0 ; i < 12 ; i++) {
				if ( visit[(char)('A'+i)-'A'] == false) {
					list.set(idx, (char)('A'+i) );
					visit[(char)('A'+i)-'A'] = true;
					make(idx+1);
					list.set(idx, 'x');
					visit[(char)('A'+i)-'A'] = false;
				}
			}
		}else {
			make(idx+1);
		}
		
	}
}
