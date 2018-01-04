package back1668;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int left[] = new int[N];
		int right[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			left[i] = x;
			right[N-i-1] = x;
		}
		
		int lsum = 1;
		int rsum = 1;
		int stan = left[0];
		for ( int i = 1 ; i < N ; i++) {
			if ( left[i] > stan) {
				stan = left[i];
				lsum++;
			}
		}
		stan = right[0];
		for ( int i = 1 ; i < N ; i++) {
			if ( right[i] > stan) {
				stan = right[i];
				rsum++;
			}
		}
		System.out.println(lsum+"\n"+rsum);
	}
}
