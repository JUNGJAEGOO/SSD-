package back13300;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int K = in.nextInt();
		
		int student[][] = new int[2][7];
		
		for ( int i = 0 ; i < N ; i++) {
			int sex = in.nextInt();
			int grade = in.nextInt();
			student[sex][grade]++;
		}
		int sum = 0;
		for ( int i = 0 ; i < 2 ; i++) {
			for ( int j = 1 ; j <= 6 ; j++) {
				if ( student[i][j] % K == 0) {
					sum += student[i][j] / K;
				}else {
					sum += (student[i][j] / K);
					sum++;
				}
			}
		}
		
		System.out.print(sum);
	}
}
