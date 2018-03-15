package back15562;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		int inner[] = new int[N+1];
		int outer[] = new int[N+1];
		
		for ( int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			inner[to]++;
			outer[from]++;
		}
		
		int sum = 0;
		for (int i = 0 ; i < N ; i++) {
			
			sum += Math.max(0,  outer[i] - inner[i] );
			
		}
		
		System.out.println(sum);
	}
}
