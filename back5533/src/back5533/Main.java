package back5533;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[][] = new int[N][3];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < 3 ;j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		int sum[] = new int[N];
		for (int i = 0 ;  i < N ; i++) {
			
			for (int k = 0 ; k < 3 ; k++) {
				
				boolean pass = true;
				for ( int j = 0 ; j < N ; j++) {
					if ( i == j ) {
						continue;
					}
					
					if ( arr[j][k] == arr[i][k]) {
						pass = false;
					}
				}
				
				if ( pass ) {
					sum[i] += arr[i][k];
				}
			
			}
		}
		
		for (int i = 0 ; i < N ; i++) {
			System.out.println(sum[i]);
		}
	}
}
