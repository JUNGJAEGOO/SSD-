package back10219;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while ( T > 0) {
			
			String input[] = in.nextLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			
			char mat[][] = new char[N][M];
			for (int i = 0 ; i< N ; i++) {
				char tmp[] = in.nextLine().toCharArray();
				for (int j = 0 ; j < M ; j++) {
					mat[i][j] = tmp[j];
				}
			}
			
			char newer[][] = new char[N][M];
			
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < M ; j++) {
					newer[i][j] = mat[N-i-1][j];
				}
			}
			
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < M ; j++) {
					System.out.print(newer[i][j]);
				}System.out.println();
			}
			
			T--;
		}
	}
}
