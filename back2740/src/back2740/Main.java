package back2740;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int a[][] = new int[N][M];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				a[i][j] = in.nextInt();
			}
		}
		in.nextInt();
		int K = in.nextInt();
		
		int b[][] = new int[M][K];
		for (int i = 0 ; i < M ; i++) {
			for (int j = 0 ; j < K ; j++) {
				b[i][j] = in.nextInt();
			}
		}
		
		int res[][] = new int[N][K];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < K ; j++) {
				
				int sum = 0;
				for (int s = 0 ; s < M ; s++) {
					sum += a[i][s]*b[s][j];
				}
				res[i][j] = sum;
			}
		}
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < K ; j++) {
				System.out.print(res[i][j]+" ");
			}System.out.println();
		}
	}
}
