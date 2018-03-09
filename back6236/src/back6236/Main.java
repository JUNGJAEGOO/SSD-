package back6236;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		int arr[] = new int[N];
		int max = 0;
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
			max = Math.max(max, arr[i]);
		}

		int left = max - 1;
		int right = 1000000001;
		int ans = left;
		while ( left <= right) {
			int mid = (left+right)/2;
			int now = 0;
			int count = 1;
			int sum = 0;
			
			if ( mid < max) {
				count = M+1;
			}
			else {
				for (int i = 0 ; i < N ; i++) {
					sum += arr[i];
					if ( sum > mid) {
						sum = arr[i];
						count++;
					}
					
					now -= arr[i];
				}
			}
			
			System.out.println(left+"~"+right+" "+mid+" "+count);
			if ( count > M) {
				left = mid + 1;
				
			}else {
				ans = mid;
				right = mid - 1;
			}
			
		}
		System.out.println(ans);
	}
}
