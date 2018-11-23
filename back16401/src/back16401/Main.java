package back16401;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int arr[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long left = 0;
		long right = 1_000_000_000;
		
		while ( left <= right) {
			
			long mid = (left+right) >> 1;
			if( mid == 0 ) {
				System.out.print(mid);
				return;
			}
			long sum = 0;
			for ( int i = 0 ; i < N ; i++) {
				sum += arr[i]/mid;
			}
			
			if ( sum >= M) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
			
		}
		
		System.out.print(right);
		
	}
}
