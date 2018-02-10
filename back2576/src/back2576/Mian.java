package back2576;

import java.util.*;

public class Mian {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int arr[] = new int[7];
		int sum = 0;
		int min = 1000000000;
		for (int i = 0 ; i < 7 ; i++) {
			arr[i] = in.nextInt();
			if ( arr[i] %2 == 1) {
				sum+=arr[i];
				if ( arr[i] < min) {
					min = arr[i];
				}
			}
		}
		if ( sum == 0 ) {
			System.out.println(-1);
		}else {
			System.out.println(sum+"\n"+min);
		}
		
	}
}
