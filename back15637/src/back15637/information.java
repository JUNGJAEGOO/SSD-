package back15637;

import java.util.Scanner;

public class information {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int arr[] = new int[46];
		
		while ( true ) {
			int x = in.nextInt();
			if( x == -1) {
				break;
			}
			arr[x]++;
		}
		
		for ( int i = 1 ; i<= 45 ; i++) {
			System.out.println(arr[i]);
		}
	}
}
