package back15779;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		int max = 0;
		int inc = 1;
		int dec = 1;
		
		for (int i = 0 ; i < N ; i++) {
			int cnt = 1;
			inc = 1;
			dec = 1;
			
			for ( int j = i+1 ; j < N ; j++) {
				
				if ( arr[j] > arr[j-1]) {
					
					if ( inc == 2) {
						
						break;
					}
					
					dec = 1;
					inc++;
					cnt++;
					max = Math.max(cnt, max);
					
				}else if (arr[j] < arr[j-1]){
					
					if ( dec == 2) {
						
						break;
					}
					
					inc = 1;
					dec++;
					cnt++;
					max = Math.max(cnt, max);
					
				}else if ( arr[j] == arr[j-1]) {
					
					if ( inc == 2 || dec == 2) {
						break;
					}
					
					dec++;
					inc++;
					cnt++;
					max = Math.max(cnt, max);
				}
				
			}
			
			//System.out.println(i+" "+cnt);
		}
		
		System.out.print(max);
	}
}
