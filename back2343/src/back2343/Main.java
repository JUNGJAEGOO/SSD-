package back2343;

import java.io.*;
import java.util.*;

public class Main {
	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
	
		st = new StringTokenizer(br.readLine()," ");
		int max = 1;
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
			
		}
		
		
		int left = max;
		int right = 1000000000;
		int ans = 0;
		
		while ( left <= right) {
			
			int mid = (left+right) >> 1;
		
			long TempSum = 0;
			int count = 1;
			
			for ( int i = 0 ; i < N ; i++) {
				if ( TempSum + arr[i] > mid) {
					count++;
					TempSum = arr[i];
				}else if ( TempSum + arr[i] == mid) {
					TempSum = 0;
					if ( i < N-1) {
					count++;
					}
				}
				else {
					
					TempSum += arr[i];
				}
			}
			
			//System.out.println(mid+" "+count);
			
			if ( count > M) {
				left = mid + 1;
				
			}else {
				right = mid -1;
				ans = mid;
			}
			
		}
		
		System.out.print(ans);
		
	}
}
