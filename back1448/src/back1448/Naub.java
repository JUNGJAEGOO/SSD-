package back1448;

import java.util.Arrays;
import java.util.Scanner;

public class Naub {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		for (int i = N-1 ; i > 1 ; i--) {
			if ( arr[i] < arr[i-1] + arr[i-2]) {
				System.out.println(arr[i] + arr[i-1] + arr[i-2]);
				return;
			}
		}
		System.out.println(-1);
	}
}
