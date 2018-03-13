package back9613;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0 ) {
			int n = in.nextInt();
			
			int arr[] = new int[n];
			for ( int i = 0 ; i < n ; i++) {
				arr[i] = in.nextInt();
				
			}
			long sum = 0;
			for ( int i = 0 ; i < n ; i++) {
				for (int j = i+1 ; j < n ; j++) {

					sum += gcd(arr[i],arr[j]);
					
				}
			}
			
			System.out.println(sum);
			T--;
		}
	}
	
	public static long gcd(long a,long b) {
		
		while ( b!= 0) {
			long temp = a % b;
			a = b;
			b = temp;
		}
		
		return Math.abs(a);
		
	}
}
