package back1236;

import java.util.*;

public class Main {
	static int N,M;
	static char mat[][];
	static boolean visit[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		mat = new char[N][M];
		for ( int i = 0 ; i < N ; i++) {
			
			char tmp[] = in.nextLine().toCharArray();
			for ( int j = 0 ; j < M ; j++) {
				mat[i][j] = tmp[j];
			}
			
		}
		
		int row[] = new int[N];
		int col[] = new int[M];
		
		visit = new boolean[N][M];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < M ; j++) {
				if ( mat[i][j] == 'X') {
					row[i]=1;
					col[j]=1;
				}
			}
		}
		
		int cnt1 = 0;
		for ( int i = 0 ; i < N ; i++) {
			if ( row[i] == 1) {
				cnt1++;
			}
		}
		
		int cnt2 = 0;
		for ( int i = 0 ; i < M ; i++) {
			if ( col[i] == 1) {
				cnt2++;
			}
		}
		
		
		System.out.print(Math.max(N-cnt1, M-cnt2));
		
	}
	
}
