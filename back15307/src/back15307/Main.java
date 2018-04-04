package back15307;

import java.util.*;

public class Main {
	static int N;
	static int arr[];
	static int dp[];
	static int res = 0;

	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[N+1];
		for ( int i = 1 ; i <= N ; i++) {
			arr[i] = in.nextInt();
		}
		
		dp = new int[N+1];
		for ( int i = 0 ; i <= N ; i++) {
			for( int j = 0 ; j < 2 ; j++) {
				dp[i] = -1;
			}
		}
		
		ArrayList<Integer> visit = new ArrayList<>();
		
		int ans = 0;
		for ( int i = 1 ; i<= N ; i++) {
			visit.add(i);
			ans += func(i,1,0,visit);
			visit.remove(0);
		}
		System.out.print(ans);
	}
	
	public static int func(int idx,int len,int dir,ArrayList<Integer> visit) {
		
		System.out.println(idx+" "+len+" "+visit);
		
		if ( len == N) {
			return 1;
		}
		
		int ret = dp[idx];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;

		for ( int i = idx-arr[idx] ; i <= idx + arr[idx] ; i++ ) {
			if ( i >= 1 && i <= N && !visit.contains(i)) {
				visit.add(i);
				if ( i > idx) {
					ret += func(i,len+1,0,visit);
				}else {
					ret += func(i,len+1,1,visit);
				}
				visit.remove(visit.size()-1);
			}
		}
	
		return dp[idx] = ret;
	}
}
