package back15130;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int arr[] = new int[10];
		
		int a=-1,b=-1;
		int aidx=0,bidx=0;
		for ( int i = 0 ; i < 10 ; i++) {
			arr[i] = in.nextInt();
			if ( arr[i] != 0 && a == -1) {
				a = arr[i];
				aidx = i;
			}else if ( arr[i] != 0 && a != -1) {
				b = arr[i];
				bidx = i;
			}
		}
		
		int diff = b-a;
		int diffidx = bidx-aidx;
		double mok = (double)diff/(double)diffidx;
		double nam = (double)diff%(double)diffidx;
		double go = mok;
		if ( nam != 0 ) {
			System.out.println(-1);
			return;
		}
		
		int cho = -100000000;
		for ( int i = -100000 ; i <= 100000 ; i++) {
			if ( i + mok * aidx == a ) {
				cho = i;
				break;
			}
		
		}
		for ( int i = 0 ; i < 10 ; i++) {
			arr[i] = (int) (cho + mok * i);
		}
		
		for ( int i = 0 ; i < 10 ; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
