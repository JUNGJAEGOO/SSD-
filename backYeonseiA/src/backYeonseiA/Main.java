package backYeonseiA;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		for (int i = 1 ; i <= 1000 ; i++) {
			if ( i*i + i + 1 == N ) {
				System.out.print(i);
				break;
			}
		}
	}
}