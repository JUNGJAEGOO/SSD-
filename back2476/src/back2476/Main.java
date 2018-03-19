package back2476;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[7];
		int max = 0;
		
		for ( int i = 0 ; i < N ; i++) {
			arr = new int[7];
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			arr[a]++;
			arr[b]++;
			arr[c]++;
			
			int sum = 0;
			for ( int j= 1 ; j <= 6 ; j++) {
				if ( arr[j] == 3) {
					sum = 10000+j*1000;
				}
				if ( arr[j] == 2) {
					sum = 1000 + j*100;
				}
			}
			
			if ( sum == 0) {
				for (int j = 6 ; j >= 1 ; j--) {
					if ( arr[j] == 1) {
						sum = j*100;
						break;
					}
				}
			}
			
			max = Math.max(max, sum);
		}
		System.out.print(max);
	}
}
