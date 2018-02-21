package back2587;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = 5;
		int arr[] = new int[N];
		int sum = 0;
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);
		System.out.print(sum/5+"\n"+arr[5/2]);
		
	}
}
