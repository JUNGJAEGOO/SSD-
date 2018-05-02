package back13333;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int arr[] = new int[N];
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
			list.add(arr[i]);
		}
		
		Arrays.sort(arr);
		
		for ( int i = N ; i >= 0 ; i--) {
			
			if ( arr[N-i] >= i) {
				System.out.print(i);
				return;
			}
			
		}
		
	}
}
