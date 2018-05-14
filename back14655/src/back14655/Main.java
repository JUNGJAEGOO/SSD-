package back14655;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int sum = 0;
		for (int i = 0 ; i < N ; i++) {
			sum += Math.abs(in.nextInt());
		}
		
		int sum2 = 0;
		for ( int i = 0 ; i < N ; i++) {
			sum2 += -Math.abs(in.nextInt());
		}
		
		System.out.print(sum-sum2);
	}
}
