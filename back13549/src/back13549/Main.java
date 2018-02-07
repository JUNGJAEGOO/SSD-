package back13549;


import java.util.*;

public class Main {
	static int N,K;
	static int dp[];
	static int inf = 100000000;
	static int prev[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		if ( N == K) {
			System.out.println(0);
			System.out.println(N);
			return;
		}
		dp = new int[100001];
		prev = new int[100001];
		Arrays.fill(dp, inf);
		
		System.out.println(func(N));
		Stack<Integer> st = new Stack<>();
		//System.out.print(N+" ");
		st.push(K);
		while ( true) {
			st.push(prev[st.peek()]);
			if ( st.peek() == N) {
				break;
			}
		}
		//System.out.println(st);
		for (int i = st.size()-1 ; i >=0 ; i--) {
			System.out.print(st.get(i)+" ");
		}
		
	}
	
	public static int func(int start) {
	
		Queue<node> q= new LinkedList<>();
		q.add(new node(start,0));
		dp[start] = 0;
		prev[start] = start;
		int ans = inf;
		
		while ( !q.isEmpty() ) {
			node now = q.poll();
			int idx = now.idx;
			int cost = now.cost;
						
			if ( idx == K) {	
				if ( cost < ans) {
					ans = cost;
				}
			}
			
			if ( idx+1 <= 100000 && dp[idx+1] > cost + 1) {
				q.add(new node(idx+1,cost+1));
				dp[idx+1] = cost + 1;
				prev[idx+1] = idx;
			}
			if ( idx-1 >= 0 && dp[idx-1] > cost + 1) {
				q.add(new node(idx-1,cost+1));
				dp[idx-1] = cost + 1;
				prev[idx-1] = idx;
			}
			if ( idx*2 <= 100000 && dp[idx*2] > cost+1) {
				q.add(new node(idx*2,cost+1));
				dp[idx*2] = cost+1;
				prev[idx*2] = idx;
			}
		}

		return ans;
	}
	

	
	public static class node{
		int idx;
		int cost;
		ArrayList<Integer> visit;
		node (int idx,int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
	
}
