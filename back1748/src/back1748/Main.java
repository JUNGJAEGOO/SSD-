package back1748;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long sum = 0;
		int limit = 10;
		int zari = 1;
		int diff = 9;
		if ( N < 10) {
			System.out.println(N);
			return;
		}
		while ( true ) {
			
			sum += diff*zari;
			diff *= 10;
			limit *= 10;
			zari++;
			if ( limit > N ) {
				limit /= 10;
				break;
			}
		}
		//System.out.println(limit+" "+sum);
		for (int i = limit ; i <= N ; i++) {
			String tmp = String.valueOf(i);
			int len = tmp.length();
			sum += len;
		}
		//788888898
		System.out.print(sum);
	}
}
