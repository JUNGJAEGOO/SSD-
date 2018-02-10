package back14939;

import java.util.*;

public class Main {
	static int [][] mat;
	static int [][] tmp;
	static int ans = 1000000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		mat = new int[10][10];
		for (int i = 0 ; i < 10 ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			for (int j = 0 ; j < 10 ; j++) {
				if ( tmp[j] == '#') {
					mat[i][j] = 1;
				}else {
					mat[i][j] = 0;
				}
				
			}
		}
		
		ArrayList<Integer> start = new ArrayList<>();
		back(-1,start);
		
		System.out.println(ans);
	}
	
	public static void back(int len,ArrayList<Integer> list) {
		
		if ( len == 9) {
			int cnt = 0;
			tmp = new int[10][10];
			for (int i = 0 ; i < 10 ; i++) {
				for (int j = 0 ; j < 10 ; j++) {
					tmp[i][j] = mat[i][j];
				}
			}
			
			for (int i = 0 ; i < list.size() ; i++ ) {
				
				int now = list.get(i);
				swap(0,now);
				swap(0,now+1);
				swap(0,now-1);
				swap(1,now);
				cnt++;
			}
			
			for (int i = 1 ; i < 10 ; i++) {
				for (int j = 0 ; j < 10 ; j++) {
					
					if ( tmp[i-1][j] == 0) {
						swap(i,j);
						swap(i-1,j);
						swap(i,j-1);
						swap(i,j+1);
						swap(i+1,j);
						cnt++;
					}
					
				}
			}
			
			int sum = 0;
			for (int i = 0 ; i < 10 ; i++) {
				for (int j = 0 ; j < 10  ;j++) {
					if ( tmp[i][j] == 0) {
						sum++;
					}
				}
			}
			
			if ( sum == 0 ) {
				ans = Math.min(ans, cnt);
			}
					
			return;
		}
		
		list.add(len+1);
		back(len+1,list);
		list.remove(list.size()-1);
		back(len+1,list);
		
	}
	
	public static void check() {
		
	}
	
	public static void swap(int row,int col) {
		
		if ( row < 0 || row >= 10 || col  < 0 || col >= 10 ) {
			return;
		}
		
		tmp[row][col] ^= 1;
		
	}
	
}
