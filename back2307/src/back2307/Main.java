package back2307;

import java.util.*;

public class Main {
	static int N;
	static ArrayList<node> adj[];
	static int c[][];
	static ArrayList<cutter> cut;
	static int dist[];
	static int prev[];
	static int inf = 1000000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int M = in.nextInt();
		adj = new ArrayList[N+1];
		for (int i = 1 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		c = new int[N+1][N+1];
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to =in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost));
			adj[to].add(new node(from,cost));
			c[from][to] = cost;
			c[to][from] = cost;
		}
		
		dist = new int[N+1];
		prev = new int[N+1];
		Arrays.fill(dist, inf);
		
		diik();
		int origin = dist[N];
		int ans = origin;
		cut = new ArrayList<>(); 
		for (int i = N ; i != 1 ; i = prev[i]) {
			//System.out.print(prev[i]+" ");
			cut.add(new cutter(prev[i],i));
		}//System.out.println();
		
		/*for (int j = 1 ; j<= N ; j++) {
			System.out.print(dist[j]+" ");
		}System.out.println();
		*/
		
		for (int i = 0 ; i < cut.size() ; i++) {
			//System.out.println(cut.get(i).from+" ~ "+cut.get(i).to);
			int from = cut.get(i).from;
			int to = cut.get(i).to;
			//System.out.println(c[from][to]);
			int tmp = c[from][to];
			c[from][to] = inf;
			c[to][from] = inf;
			
			Arrays.fill(dist, inf);
			diik();
			
			
			if ( dist[N] == inf) {
				System.out.println(-1);
				return;
			}else if ( dist[N] > ans) {
				ans = dist[N];
			}
			
			c[from][to] = tmp;
			c[to][from] = tmp;
		}
		
		if ( ans == origin) {
			System.out.println(0);
		}else {
			System.out.println(ans-origin);
		}
		
	}
	
	public static void diik() {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(1,0));
		dist[1] = 0;
		prev[1] = 1;
		
		while (!pq.isEmpty() ) {
			
			node tmp = pq.poll();
			int now = tmp.idx;
			int cost = tmp.cost;
			if ( dist[now] < cost) {
				continue;
			}
			
			for (int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				int nextcost = c[now][next];
				if ( dist[next] > dist[now] + nextcost) {
					dist[next] = dist[now] + nextcost;
					prev[next] = now;
					pq.add(new node(next,dist[now]+nextcost));
				}
			}
			
			
		}
	}
	
	public static class cutter {
		int from;
		int to;
		cutter ( int from,int to){
			this.from = from;
			this.to= to;
		}
	}
	
	public static class node implements Comparable<node>{
		int idx;
		int cost;
		node (int idx,int cost){
			this.idx = idx;
			this.cost = cost;
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
