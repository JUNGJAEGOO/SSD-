package back1162;

import java.util.*;

public class Main {
	static ArrayList<node> adj[];
	static long dist[][];
	static int start,end;
	static long inf = Long.MAX_VALUE;
	static int N,M,K;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		K = in.nextInt();
		adj = new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost,0));
			adj[to].add(new node(from,cost,0));
		}
		
		start = 1;
		end = N;
		
		dist = new long[21][10001];
		for (int i = 0 ; i < 21 ; i++) {
			for (int j = 0 ; j < 10001 ; j++) {
				dist[i][j] = inf;
				
			}
		}
		//System.out.print(dist[1][1]);
		diikstra();
		long min = inf;
		for (int i = 0 ; i  < 21 ; i++) {
			//System.out.print(dist[i][end]+" ");
			if ( dist[i][end] < min) {
				min = dist[i][end];
			}
		}
		System.out.println(min);
	}
	
	public static void diikstra() {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start,0,0));
		dist[0][start] = 0;
		while ( !pq.isEmpty() ) {
			
			node tmp = pq.poll();
			int now = tmp.idx;
			long cost = tmp.cost;
			int pave = tmp.pave;
			if ( dist[pave][now] < cost) {
				continue;
			}
			
			for (int i = 0 ; i < adj[now].size(); i++) {
				int next = adj[now].get(i).idx;
				long nextcost = adj[now].get(i).cost;
				
				if ( dist[pave][next] > dist[pave][now] + nextcost) {
					dist[pave][next] = dist[pave][now]+nextcost;
					pq.add(new node(next,dist[pave][now]+nextcost,pave));
				}
				if ( pave +1 <= K && dist[pave+1][next] > dist[pave][now] ) {
					dist[pave+1][next] = dist[pave][now];
					pq.add(new node(next,dist[pave][now],pave+1));
				}
				
			}
			
		}
		
	}

	public static class node implements Comparable<node>{
		int idx;
		long cost;
		int pave;
		node(int idx,long cost,int pave){
			this.idx = idx;
			this.cost = cost;
			this.pave = pave;
		}
		@Override
		public int compareTo(node o) {
			if ( this.cost > o.cost) {
				return 1;
			}
			return -1;
		}
	}
}
