package back9521;

import java.util.*;

public class Main {
	static int no[];
	static int N,K;

	static int dp[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		no = new int[N+1];
		for (int i = 1 ; i <= N ; i++) {
			no[i] = in.nextInt();
		}
		dp = new int[N+1];
		Arrays.fill(dp, -1);
		ArrayList<Integer> visit = new ArrayList<>();
		System.out.println(func(0,visit));
	}
	
	public static int func(int len,ArrayList<Integer> visit) {
		
		System.out.println(len+" "+visit);
		
		if ( len == N){
			return 1;
		}
		
		/*int ret = dp[len];
		if ( ret != -1) {
			return ret;
		}
		*/
		int ret = 0;
		
		for (int i = 1 ; i <= K ; i++) {
			if ( i != no[len+1] && !visit.contains(i) ) {
				System.out.println(i);
				visit.add(i);
				ret += func(len+1,visit);
				visit.remove(visit.size()-1);
			}
		}
		
		return ret;
	}
}
