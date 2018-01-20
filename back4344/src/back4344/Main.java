package back4344;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int arr[];
		for (int i = 0 ; i < T; i++) {
			int N = in.nextInt();
			arr = new int[N];
			int sum = 0;
			for ( int j = 0 ; j < N ; j++) {
				arr[j] = in.nextInt();
				sum += arr[j];
			}
			double avg = sum / N;
			
			int cnt = 0;
			for ( int j = 0 ; j < N ; j++) {
				if ( arr[j] > avg) {
					cnt++;
				}
			}
			//System.out.println(cnt);
			double x = (double)cnt/N;
			//System.out.println(x);
			x = x*100;
			System.out.format("%.3f", x);
			System.out.println("%");
		}
	}
}
