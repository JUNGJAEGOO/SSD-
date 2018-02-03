package back13907;

import java.util.*;

import back13907.Main.node;

public class Main2 {
	static int N,M,K;
	static int start,end;
	static long dist[][];
	static int inf = 100000000;
	static ArrayList<node> adj[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		K = in.nextInt();
		start = in.nextInt();
		end = in.nextInt();
		dist = new long[1001][1001];
		for (int i = 0 ; i < 1001  ; i++) {
			for (int j = 0 ; j < 1000  ; j++) {
				dist[i][j] = inf;
			}
		}
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
		
		diikstra();
		
		int k[] = new int[K+1];
		for (int i = 1 ; i <= K ; i++) {
			k[i] = in.nextInt();
		}
		
		
		long min = inf;
		for (int i = 0 ; i <= K ; i++) {
			min = inf;
			for (int j = 0 ; j < N ; j++) {
				if ( dist[end][j] == inf) {
					continue;
				}
				dist[end][j] = dist[end][j] + j*k[i];
				//System.out.println(dist[end][j]);
				min = Math.min(min, dist[end][j]); 
			}
			
			/*for (int s = 0 ; s <= N ; s++) {
				for (int z = 0 ; z < N ; z++) {
					System.out.print(dist[s][z]+" ");
				}System.out.println();
			}*/
			System.out.println(min);
		}
		
	}
	
	public static void diikstra() {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start,0,0));
		dist[start][0] = 0;
		while( !pq.isEmpty()) {
			int now = pq.peek().idx;
			long nowcost = pq.peek().cost;
			int nowcnt = pq.peek().cnt;
			pq.poll();
			
			for (int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				long nextcost = adj[now].get(i).cost;
				if ( dist[next][nowcnt+1] > dist[now][nowcnt] + nextcost) {
					dist[next][nowcnt+1] = dist[now][nowcnt] + nextcost;
					pq.add(new node(next,dist[next][nowcnt+1],nowcnt+1));
				}
			}
			
		}
	}
	
	public static class node implements Comparable<node>{
		int idx;
		long cost;
		int cnt;
		node( int idx,long cost,int cnt){
			this.idx = idx;
			this.cost = cost;
			this.cnt =cnt;
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
