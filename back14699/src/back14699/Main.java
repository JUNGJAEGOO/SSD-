package back14699;

import java.util.*;

public class Main {
	static ArrayList<Integer> adj[];
	static int dp[];
	static int hike[];
	static int h[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		h = new int[N+1];
		adj = new ArrayList[N+1];
		hike = new int[N+1];
		for (int i = 1;  i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 1 ; i <= N ; i++) {
			h[i] = in.nextInt();
		}
		
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			adj[from].add(to);
			adj[to].add(from);
			if ( h[from] < h[to]) {
				hike[from]++;
			}else {
				hike[to]++;
			}
		}
		
		dp = new int[N+1];
		Arrays.fill(dp, -1);
		
		for (int i = 1 ; i<= N ; i++) {
			
			System.out.println(1+func(i));
		}
	}
	
	public static int func(int idx) {
		
		//System.out.print(idx);
		
		if ( hike[idx] == 0) {
			return 0;
		}
		
		int ret = dp[idx];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		for (int i = 0 ; i < adj[idx].size() ; i++) {
			int next = adj[idx].get(i);
			if ( h[next] > h[idx]) {
				ret = Math.max(ret, 1+func(next) );
			}
		}
		
		return dp[idx] = ret;
	}
}
