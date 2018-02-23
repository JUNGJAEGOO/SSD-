package back11970;

import java.util.*;

public class Main {
	// 겹치지 않아도 합을 출력 해야함
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		// a < b , c < d
		int arr[] = new int[101];
		for (int i = a ; i <= b ; i++) {
			arr[i]++;
		}
		for (int i = c ; i <= d;  i++) {
			arr[i]++;
		}
		
		boolean pass = false;
		int sum = 0;
		for (int i = 0 ; i <= 100 ; i++) {
			if (arr[i] > 1) {
				pass = true;
			}
			if ( arr[i] > 0) {
				sum++;
			}
		}
		
		if ( !pass ) {
			System.out.println(sum-2);
		}else {
			System.out.println(sum-1);
		}
	}
}
