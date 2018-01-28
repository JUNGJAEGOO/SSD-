package back14627;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int S = in.nextInt();
		int C = in.nextInt();
		int arr[] = new int[S];
		for (int i = 0 ; i < S ; i++) {
			arr[i] = in.nextInt();
		}
		
		long SUM = 0;
		for (int i = 0 ; i < S ; i++) {
			SUM += arr[i];
		}
		//System.out.println(SUM);
		
		long ans = 0;
		long left = 1;
		long right = 2147483647;
		long mid = (left+right)/2;
		while( left <= right) {
			
			mid = (left+right)/2;
			//System.out.println(mid);
			long sum = 0;
			for (int i = 0 ; i < S ; i++) {
					sum += arr[i]/mid;
			}
			
			if ( sum >= C) {
				left = mid+1;
				if ( ans > mid) {
					ans = ans;
				}else {
					ans = mid;
				}
			}else {
				right = mid-1;
				
			}
			
			
			
		}
		
		//System.out.println(mid);
		SUM = SUM - ans * C;
		
		
		System.out.println(SUM);
		
	}
}
