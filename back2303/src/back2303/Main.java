package back2303;

import java.util.*;

public class Main {
	static boolean visit[];
	static int arr[];
	static int max;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		ArrayList<Integer> res = new ArrayList<>();
		
		for ( int i = 0 ; i < N ; i++) {
			
			max = -1;
			visit = new boolean[5];
			arr = new int[5];
			for ( int j = 0 ; j < 5 ; j++) {
				arr[j] = in.nextInt();
			}
			func(0,0);
			
			res.add(max);
			
		}
		
		int MAX = 0;
		int MAXidx = 0;
		for ( int i = 0 ; i < res.size(); i++ ) {
			if ( res.get(i) > MAX) {
				MAX = res.get(i);
				MAXidx = i;
			}
			else if ( res.get(i) == MAX) {
				if ( i > MAXidx) {
					MAXidx = i;
				}
			}
		}
		
		System.out.print(MAXidx+1);
		
		
		
		
	}
	
	public static void func(int sum,int len) {
	
		if ( len == 3) {
			
			int one = sum%10;
			if ( one > max) {
				max = one;
			}
			return;
		}
		
		for ( int i = 0 ; i < 5 ; i++) {
			if ( visit[i] == false) {
				visit[i] = true;
				func(sum+arr[i],len+1);
				visit[i] = false;
			}
		}
	}
}
