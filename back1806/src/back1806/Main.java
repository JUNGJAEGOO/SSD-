package back1806;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int S = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		int start = 0;
		int end = 0;
		int sum = 0;
		int length = 0;
		int ans = 1000000000;
		while ( true) {
			
			if ( sum < S) {
				if ( end >= N) {
					break;
				}
				sum += arr[end];
				end++;
				
			}else {
				System.out.println(start+" "+end);

				length = end - start;
				ans = Math.min(ans, length);
				sum -= arr[start];
				start++;
				
			}
			
			if ( start == N && end == N) {
				break;
			}
		}
		
		if ( ans == 1000000000) {
			System.out.println(0);
		}else {
			System.out.print(ans);
		}
	}
}
