package back12018;

import java.util.*;

public class Main {
	static boolean visit[];
	static int N,M;
	static int MAX = 0;
	static int want[];
	static int dp[][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		want = new int[N];
		for (int i = 0 ; i < N ; i++) {
			int now = in.nextInt();
			int full = in.nextInt();
			if ( now < full) {
				for (int j = 0 ; j < now ; j++) {
					in.nextInt();
				}
				want[i] = 1;
				continue;
			}
			else {
				ArrayList<Integer> tmp = new ArrayList<>();
				for (int j = 0 ; j < now ; j++) {
					tmp.add(in.nextInt());
				}
				Collections.sort(tmp);
				Collections.reverse(tmp);
				want[i] = tmp.get(full-1);
			}
		}
		
		for (int i = 0 ; i < N ; i++) {
			System.out.print(want[i]+" ");
		}System.out.println();
		
		visit = new boolean[N];
		dp = new int[101][101];
		for (int i = 0 ; i < 101 ; i++) {
			for (int j = 0 ; j < 101 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.print(func(0,M));
	}
	
	public static int func(int pos,int limit) {
		
		if ( pos == N) {
			return 0;
		}
		
		int ret = dp[pos][limit];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		ret = func(pos+1,limit);
		if ( limit-want[pos] >= 0) {
		ret = Math.max(ret, 1+func(pos+1,limit-want[pos]));
		}
		
		return dp[pos][limit] = ret;
	}
	

}
