package back4307;

import java.util.*;

public class Main {
	static int n,length;
	static int arr[];
	static int Min,Max;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testcase = in.nextInt();
		for ( int T = 0 ;  T < testcase ; T++) {
			
			length = in.nextInt();
			n = in.nextInt();
			arr = new int[n];

			Max = 0;
			Min = 0;
			
			for ( int i = 0 ;i < n ; i++) {
				arr[i] = in.nextInt();
				Min = Math.max(Min, Math.min(arr[i], length-arr[i]));
				Max = Math.max(Max, Math.max(arr[i], length-arr[i]));
			}
			
			System.out.println(Min+" "+Max);
			
		}
	}

}
