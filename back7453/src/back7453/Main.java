package back7453;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		HashMap<Long,Long> A = new HashMap<>();
		HashMap<Long,Long> B = new HashMap<>();
		
		Long arr1[] = new Long[N];
		Long arr2[] = new Long[N];
		Long arr3[] = new Long[N];
		Long arr4[] = new Long[N];
		
		for ( int i = 0 ; i < N ; i++) {
			long a = in.nextLong();
			long b = in.nextLong();
			long c = in.nextLong();
			long d = in.nextLong();
			arr1[i] = a;
			arr2[i] = b;
			arr3[i] = c;
			arr4[i] = d;
			
		}
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				if( A.get(arr1[i] + arr2[j]) == null ) {
					A.put(arr1[i] + arr2[j],(long) 1);
				}else {
					A.replace(arr1[i] + arr2[j], A.get(arr1[i] + arr2[j])+1 );
				}

			}
		}
		
		long sum = 0;
		
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				if ( A.get(-(arr3[i]+arr4[j])) != null) {
					sum+=A.get(-(arr3[i]+arr4[j]));
				}
			}
		}
		
	
		System.out.print(sum);
		
	}
}
