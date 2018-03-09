package back11383;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		char mat[][] = new char[N][M];
		for (int i = 0 ; i < N ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			
			for ( int j = 0 ; j < M ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		char target[][] = new char[N][M*2];
		for (int i = 0 ; i < N ; i++) {
			char tmp[] = in.nextLine().toCharArray();
			
			for (int j = 0 ; j < M*2 ; j++) {
				target[i][j] = tmp[j];
			}
		}
		
		char gob[][] = new char[N][M*2];
		int j = 0;
		int x = 0;
		for (int i = 0 ; i < N ; i++) {
			x = 0;
			for (int s = 0 ; s < M ; s++) {
				gob[i][x] = mat[i][s];
				gob[i][x+1] = mat[i][s];
				//System.out.println(mat[i][s]);
				x+=2;
			}
			
			
		}
		
		for (int i = 0 ; i < N ; i++) {
			for (int s = 0 ; s < 2*M ; s++) {
				System.out.print(gob[i][s]);
			}System.out.println();
		}
		
		int sum = 0;
		for (int i = 0 ; i < N ; i++) {
			for (int s = 0 ; s < 2*M ; s++) {
				if ( gob[i][s] == target[i][s]) {
					sum++;
				}
			}
		}
		
		if ( sum == N * 2 * M) {
			System.out.print("Eyfa");
		}else {
			System.out.print("Not Eyfa");
		}
	}
}
