package back9629;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(" ");
		
		char[] A = info[0].toCharArray();
		char[] B = info[1].toCharArray();
		long sum = 0;
		if ( A.length > B.length) {
			
		}else if ( A.length == B.length) {
			for ( int i = 0 ; i < A.length ; i++) {
				int x = Math.abs(Integer.parseInt(String.valueOf(A[i])) - Integer.parseInt(String.valueOf(B[i])));
				sum += x % 1000000007;
			}
		}else {
			
		}
		
		System.out.print(sum);
	}
}
