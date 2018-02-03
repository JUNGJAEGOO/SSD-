package back2110;

import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int C = in.nextInt();
		int arr[] = new int[N];
		for(int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		int left = arr[0];
		int right = arr[N-1];
		int ans = -1;
		while ( left <= right) {
			int mid = (left+right)/2;
			//System.out.println(mid);
			boolean pass = true;
			int before = 0;
			int cnt = 1;
			for (int i = 0 ; i < N-1 ; i++) {
				if ( arr[i+1] - arr[before] >= mid) {
					before = i+1;
					cnt++;
				}
			}
			//System.out.println(cnt);
			if( cnt >= C) {
				
				ans = mid;
				
				left = mid +1;
			}else {
				right = mid - 1;
			}
		}
		
		System.out.println(ans);
	}
}
