package back1940;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		int arr[] = new int[N];
		boolean visit[] = new boolean[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		int sum = 0;
		
		for  (int i = 0 ; i < N ; i++) {
			if ( visit[i]) {
				continue;
			}
			for ( int j = 0 ; j < N ; j++) {
				if ( i == j ) {
					continue;
				}
				
				if ( visit[j]) {
					continue;
				}
				
				if ( arr[i] + arr[j] == M) {
					visit[i] = true;
					visit[j] = true;
					sum++;
				}
			}
		}
		
		System.out.print(sum);
	}
}
