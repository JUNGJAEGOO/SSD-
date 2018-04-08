package back2143;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new  Scanner(System.in);
		int T = in.nextInt();
		
		
		int N = in.nextInt();
		int arr1[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr1[i] = in.nextInt();
		}
		int M = in.nextInt();
		int arr2[] = new int[M];
		for ( int i = 0 ; i < M ; i++) {
			arr2[i] = in.nextInt();
		}
		
		if ( N == 1 && M == 1) {
			if ( arr1[0] + arr2[0] == T) {
				System.out.println(1);
				return;
			}else {
				System.out.println(0);
				return;
			}
		}
		
		ArrayList<Long> sum1 = new ArrayList<>();
		ArrayList<Long> sum2 = new ArrayList<>();
		
		for ( int i = 0 ; i < N ; i++) {
			long tmpsum = arr1[i];
			sum1.add(tmpsum);
			for ( int j = i+1 ; j < N ; j++) {
				tmpsum += arr1[j];
				sum1.add(tmpsum);
			}
		}
		
		for ( int i = 0 ; i < M ; i++) {
			long tmpsum = arr2[i];
			sum2.add(tmpsum);
			for ( int j = i+1 ; j <M ; j++) {
				tmpsum += arr2[j];
				sum2.add(tmpsum);
			}
		}
		
		Collections.sort(sum1);
		Collections.sort(sum2);
		//System.out.println(sum1+" "+sum2);
		
		long sum = 0;
		
		for ( int i = 0 ; i < sum1.size() ; i++) {
			
			long now = sum1.get(i);
			
			int left = 0;
			int right = sum2.size()-1;
			int low = 0;
			
			while ( left <= right) {
				
				int mid = (left+right)/2;
				
				if ( now + sum2.get(mid) >= T) {
					right = mid - 1;
					low = mid;
				}else {
					
					left = mid + 1;
				}
				
			}
			
			left = 0;
			right = sum2.size()-1;
			int upper = 0;
			while ( left <= right) {
				
				int mid = (left+right)/2;
				if ( now + sum2.get(mid) > T) {
					right = mid - 1;
					upper = mid;
				}else {
					
					left = mid + 1;
				}
				
				
			}
			
			//System.out.println(now+" "+low+" "+upper);
			
			
			sum += (upper-low);
					
			
		}
		System.out.print(sum);
	}
}
