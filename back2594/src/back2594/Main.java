package back2594;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		
		int arr[] = new int[1441];
		
		for ( int i = 0 ; i < N ; i++) {
			String input[] = in.nextLine().split(" ");
			String S = input[0];
			String E = input[1];
			
			int start = Integer.parseInt(S.substring(0,2))*60 + Integer.parseInt(S.substring(2,4));
			int end = Integer.parseInt(E.substring(0,2))*60 + Integer.parseInt(E.substring(2,4));;
			//System.out.println(start+" "+end);
			start = start - 10;
			end = end + 10;
			if ( start < 0) {
				start = 1440 + start;
			}
			if ( end > 1440) {
				end = end - 1440;
			}
			for (int j = start ; j <= end-1 ; j++) {
				arr[j]++;
			}
		}
		
		int ans = 0;
		int sum = 0;
		for (int i = 600 ; i <= 1320 ; i++) {
			
			if ( arr[i] == 0 ) {
				//System.out.println(i);
				sum++;
			}else if (arr[i] == 1) {
				if( sum != 0 ) {
					//System.out.println(sum);
				}
				ans = Math.max(ans, sum);
				sum = 0;
			}
			
			if ( i == 1320 && sum != 0) {
				//System.out.println(sum-1);
				ans = Math.max(ans, sum-1);
				sum = 0;
			}
		}
		System.out.println(ans);
		
	}
}
