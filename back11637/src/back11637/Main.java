package back11637;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0 ) {
			int n  = in.nextInt();
			int arr[] = new int[n];
			int sum = 0;
			for (int i = 0 ; i < n ; i++) {
				arr[i] = in.nextInt();
				sum += arr[i];
			}
			
			int rank[] = new int[n];
			for (int i = 0 ; i < n ; i++) {
				for (int j = 0 ; j < n ; j++){
					if( i == j ) {
						continue;
					}
					if( arr[i] >= arr[j]) {
						rank[i]++;
					}
					
				}
			}
			
			int same = 0;
			int max = -1;
			int maxidx = 0;
			boolean over = false;
			
			for (int i = 0; i < n ; i++) {
				
				if ( rank[i] > max) {
					max = rank[i];
					maxidx = i;
					same = 0;
					
				}else if ( max == rank[i] ) {
					same++;
				}
			}
			
			if ( arr[maxidx] > sum/2) {
				over = true;
			}
			
			if ( same >= 1) {
				System.out.println("no winner");
			}else if ( over ) {
				System.out.println("majority winner "+(maxidx+1));
			}else if ( !over) {
				System.out.println("minority winner "+(maxidx+1));
			}
			
			
			
			T--;
		}
	}
	

}
