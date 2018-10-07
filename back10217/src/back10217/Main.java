package back10217;

import java.io.*;
import java.util.*;

public class Main {
	
	static int dp[][];
	static ArrayList<node> adj[];
	static final int inf = Integer.MAX_VALUE - 10;
	static int N,M,K;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		dp = new int [101][10001];
		
		for ( int testcase = 0 ; testcase < T ; testcase++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[N+1];
			
			for ( int i = 0 ; i <= 100 ; i++ ) {
				for ( int j = 0 ; j <= 10000 ; j++) {
					dp[i][j] = inf;
				}
			}
			
			for ( int i = 0 ; i <= N ; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0 ; i < K ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				adj[u].add(new node(v,c,d));
				//adj[v].add(new node(u,c,d));
			
			}
			
			dijkstra();
			
			int ans = inf;
			for ( int i = 0 ; i <= M ; i++) {
				if ( ans > dp[N][i]) {
					ans = dp[N][i];
				}
			}
			
			sb.append(ans != inf ? ans+"\n" : "Poor KCM\n");
		}
		
		System.out.print(sb);
	}
	
	public static void dijkstra() {
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		dp[1][0] = 0;
		pq.add(new node(1,0,0));
		
		while ( !pq.isEmpty() ) {
			
			node now = pq.poll();
			int nowidx = now.idx;
			int nowcost = now.cost;
			int nowtime = now.time;
			
			if ( dp[nowidx][nowcost] < nowtime ) {
				continue;
			}

			for ( int i = 0 ; i < adj[nowidx].size() ; i++) {
				
				int nextidx = adj[nowidx].get(i).idx;
				int nextcost = adj[nowidx].get(i).cost;
				int nexttime = adj[nowidx].get(i).time;
				
				if ( nowcost+ nextcost > M) {
					continue;
				}
				int totalcost = nowcost + nextcost;
				if ( dp[nextidx][totalcost] > nowtime + nexttime ) {
					dp[nextidx][nowcost+nextcost] = nowtime + nexttime;
					pq.add(new node(nextidx,totalcost,nexttime+nowtime));
				}
				
			}
			
		}
		
	}
	
	public static class node implements Comparable<node>{
		int idx;
		int cost;
		int time;
		node ( int idx, int cost,int time){
			this.idx = idx;
			this.cost = cost;
			this.time = time;
		}
		@Override
		public int compareTo(node o) {
			if ( this.time > o.time) {
				return 1;
			}
			return -1;
		}
	}
}

