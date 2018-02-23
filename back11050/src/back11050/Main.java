package back11050;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int sum = 0;
		int boonmo = 1;
		int boonza = 1;
		for (int i = N ; i >= N-K+1 ; i-- ) {
			boonmo *= i;
		}
		for (int i = K ; i >= 1 ; i--) {
			boonza *= i;
		}
		System.out.print(boonmo/boonza);
	}
}
