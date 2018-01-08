package back10996;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		for (int i = 1 ; i <= 2*N ; i++) {
			for ( int j = 1 ; j <= N ; j++) {
				if ( i % 2 == 0) {
					if ( j % 2 == 0) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}else {
					if ( j % 2 == 0) {
						System.out.print(" ");
					}else {
						System.out.print("*");
					}
				}
			}
			System.out.println();
		}
	}
}
