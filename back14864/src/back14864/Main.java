package back14864;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
	
		int N = in.nextInt();
		int M = in.nextInt();
		
		int arr[] = new int[N];
		for( int i = 0 ; i < N ; i++) {
			arr[i] = i + 1;
		}
		
		for ( int i = 0 ; i < M ; i++) {
			int x = in.nextInt() - 1;
			int y = in.nextInt() -1 ;
			arr[x]++;
			arr[y]--;
		}
		
		StringBuilder sb = new StringBuilder();
		boolean same[] = new boolean[N+1];
		for ( int i = 0 ; i < N ; i++) {
			if ( same[arr[i]] == false) {
				same[arr[i]] = true;
			}else {
				System.out.print(-1);
				return;
			}
			sb.append(arr[i]+" ");
		}
		
		System.out.print(sb);
	}
}
