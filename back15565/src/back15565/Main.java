package back15565;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N =in.nextInt();
		int K = in.nextInt();
		
		int arr[] = new int[N];
		int sum = 0;
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		int left = 0;
		int right= 0;
		if ( arr[0] == 1) {
			sum++;
		}
		int len = 0;
		int min = Integer.MAX_VALUE;
		while ( true ) {
			
			System.out.println(left+" "+right+" "+len+" "+sum);
			
			if (  sum < K) {
				right++;
				if ( right >= N) {
					break;
				}
				int x = arr[right];
				if ( x == 1) {
					sum += x;
				}
			}else if ( sum == K ) {
				int x = arr[left];
				left++;
				if ( x == 1) {
				sum -= x;
				}
				
			}
			
			if ( sum == K) {
				len = right - left;
				min = Math.min(min, len);
			}
			
		}
		
		if ( min == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(min+1);
	}
}
