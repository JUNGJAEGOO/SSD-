package back2559;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		long sum = 0;
		long max = -100000000;
		int arr[] = new int[N];
		for (int i = 0 ; i< N ; i++) {
			arr[i] = in.nextInt();
			if ( i < K ) {
				sum += arr[i];
				if ( i == K -1) {
					max = sum;
				}
			}else {
				sum -= arr[i-K];
				sum += arr[i];
				if ( sum > max ) {
					max = sum;
				}
			}
		}
		System.out.println(max);
		
	}
}
