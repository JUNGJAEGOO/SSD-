package back2470;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		
		int left = 0;
		int right = N-1;
		int sum =  arr[left] + arr[right];
		int ans = Integer.MAX_VALUE;
		int ansleft = 0,ansright = 0;
		
		while ( true ) {
			
			if ( Math.abs(sum) < ans ) {
				ans = Math.abs(sum);
				ansleft = left;
				ansright = right;
			}
			
			if ( sum > 0) {
				
				right--;
				if ( left >= right ) {
					break;
				}
				sum = arr[left] + arr[right];
				
			}else if ( sum == 0) {
				
				ansleft = left;
				ansright= right;
				break;
			}else {
				
				left++;
				if ( left >= right ) {
					break;
				}
				sum = arr[left] + arr[right];
				
			}
			
			
			
			
		}
		
		int A = arr[ansleft];
		int B = arr[ansright];
		if ( A > B) {
			int tmp = A;
			A = B;
			B = tmp;
		}
		System.out.print(A+" "+B);
	}
}
