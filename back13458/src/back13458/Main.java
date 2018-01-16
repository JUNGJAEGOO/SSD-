package back13458;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		int head = in.nextInt();
		int sub = in.nextInt();
		long sum = 0;
		
			for ( int i = 0 ; i < N ; i++) {
				arr[i] -= head;
				sum ++;
			}
			
			for ( int i = 0 ; i < N ; i++) {
				if ( arr[i] > 0) {
					int mok = arr[i] / sub;
					arr[i] -= sub*mok;
					sum += mok;
					if ( arr[i] > 0) {
						arr[i] -= sub;
						sum ++;
					}
				}
			}
		
		System.out.print(sum);
	}
}
