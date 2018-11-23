package back14215;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int max = 0;
		
		for ( int i = 1 ; i<= a ; i++) {
			for ( int j = 1 ; j<= b ; j++) {
				for ( int k = 1 ; k<= c ; k++) {
					if ( i >= j && i >= k) {
						if ( i < j + k) {
							max = Math.max(max, i+j+k);
						}
					}else if ( j >= k && j >= i ) {
						if ( j < k + a) {
							
							max = Math.max(max, i+j+k);
						}
					}else if ( k >= i && k >= j) {
						if ( k < i + j) {
							
							max = Math.max(max, i+j+k);
						}
					}
				}
			}
		}
		
		System.out.print(max);
	}
}
