package back3079;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		long M = in.nextLong();
		
		long arr[] = new long[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextLong();
		}
		
		long left = 0;
		long right = (long) 1e18;
		long ans = 0;
		while ( left < right) {
			long mid = (left+right)/2;
			
			long cnt = 0;
			for ( int i = 0 ; i < N ; i++) {
				cnt += (mid)/arr[i];
			}
			
			if ( cnt >= M) {
				ans = mid;
				right = mid;
				
			}else {
				left = mid + 1;
			}
			
		}
		
		System.out.print(ans);
		
	}
}
