package back1208;

import java.util.*;

public class Main {
	static ArrayList<Long> aa = new ArrayList<>();
	static ArrayList<Long> bb = new ArrayList<>();
	static int A[];
	static int B[];

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int S = in.nextInt();
		
	
		if ( N % 2 == 0) {
			A = new int[N/2];
			B = new int[N/2];
			for ( int i = 0 ; i < N / 2 ; i++) {
				A[i] = in.nextInt();
			}
			for ( int i = 0 ; i < N / 2 ; i++) {
				B[i] = in.nextInt();
			}
		}else {
			A = new int[N/2+1];
			B = new int[N/2];
			for ( int i = 0 ; i < N / 2 + 1; i++) {
				A[i] = in.nextInt();
			}
			for ( int i = 0 ; i < N / 2 ; i++) {
				B[i] = in.nextInt();
			}
		}
		
		//System.out.println(A.length+" "+B.length);
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		aamake(0,0);
		bbmake(0,0);
		
		Collections.sort(aa);
		Collections.sort(bb);
		
		System.out.println(aa);
		System.out.println(bb);
		
		
		long ans = 0;
		
		for ( int i = 0 ; i < aa.size() ; i++) {
			
			int left = 0;
			int right = bb.size();
			int MIN = Integer.MAX_VALUE;
			int MAX = Integer.MIN_VALUE;
			
			while(  left < right) {
				int mid = (left+right)/2;
				if ( aa.get(i) + bb.get(mid) <= S) {
					left = mid + 1;
				}else {
					right = mid;
				}
			}
			
			MAX = right;
		
			left = 0;
			right = bb.size();
			while ( left < right) {
				int mid = (left+right)/2;
				if ( aa.get(i) +  bb.get(mid) < S) {
					left = mid+1;
				}else {
					right = mid;
				}
			}
			
			MIN = right;

			System.out.println(MIN+" "+MAX);
			
			ans += MAX - MIN;
			
		}
		
		if ( S == 0) {
			ans--;
		}
		System.out.print(ans);
	}
	
	public static void aamake(long now,int idx) {
	
			aa.add(now);
		
		
		for ( int i = idx ; i < A.length ; i++) {
			
			aamake(now+A[i],i+1);
			
		}
	}
	
	public static void bbmake(long now,int idx) {

	
			bb.add(now);
		
		
		for ( int i = idx ; i < B.length ; i++) {
			
			bbmake(now+B[i],i+1);
				
		}
	}
}
