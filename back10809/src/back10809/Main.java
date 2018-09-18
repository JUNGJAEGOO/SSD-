package back10809;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		
		char[] C = str.toCharArray();
		
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		
		for ( int i = 0 ; i < C.length ; i++) {
			
			if ( arr[C[i]-'a'] == -1) {
				arr[C[i]-'a'] = i;
			}
			
		}
		
		for ( int i = 0 ; i < 26 ; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
}
