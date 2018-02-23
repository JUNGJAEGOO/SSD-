package back5054;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int i = 0 ; i < n ; i++) {
				arr[i] = in.nextInt();
			}
			Arrays.sort(arr);
			int sum = 0;
			sum = 2*(arr[n-1] - arr[0]);
			System.out.println(sum);
			
			T--;
		}
	}
}
