package back12851;

import java.util.*;

public class Main {
	static int N,K;
	static int dp[];
	static int inf = 100000000;
	static int res = 0;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		dp = new int[100001];
		Arrays.fill(dp, inf);
		
		System.out.println(func(N));
		System.out.println(res);
	}
	
	public static int func(int start) {
	
		Queue<node> q= new LinkedList<>();
		q.add(new node(start,0));
		dp[start] = 0;
		int ans = inf;
		
		while ( !q.isEmpty() ) {
			node now = q.poll();
			int idx = now.idx;
			int cost = now.cost;
			
			if ( idx == K) {
				//System.out.println("hi");
				if ( ans > cost) {
					ans = cost;
					res = 1;
				}else if ( ans == cost) {
					res++;
				}
			}
			
			if ( idx+1 <= 100000 && dp[idx+1] >= cost + 1) {
				q.add(new node(idx+1,cost+1));
				dp[idx+1] = cost + 1;
			}
			if ( idx-1 >= 0 && dp[idx-1] >= cost + 1) {
				q.add(new node(idx-1,cost+1));
				dp[idx-1] = cost + 1;
			}
			if ( idx*2 <= 100000 && dp[idx*2] >= cost+1) {
				q.add(new node(idx*2,cost+1));
				dp[idx*2] = cost+1;
			}
		}
		
		return ans;
	}
	
	public static class node{
		int idx;
		int cost;
		node (int idx,int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
	
}
