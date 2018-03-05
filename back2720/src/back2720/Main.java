package back2720;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while ( T > 0) {
			
			int N = in.nextInt();
			
			int one = 0;
			int two = 0;
			int three = 0;
			int four = 0;
			
			one = N/25;
			N = N%25;
			two = N/10;
			N = N%10;
			three = N/5;
			N = N%5;
			four = N;
			System.out.println(one+" "+two+" "+three+" "+four);
			T--;
		}
	}
}
