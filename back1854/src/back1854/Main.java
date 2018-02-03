package back1854;

import java.util.*;

public class Main {
	static int n,m,k;
	static PriorityQueue<haha> dist[];
	static ArrayList<node> adj[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		dist = new PriorityQueue[n+1];
		adj = new ArrayList[n+1];
		for (int i = 1 ; i<= n ;i++) {
			dist[i] = new PriorityQueue<>();
			adj[i] = new ArrayList<>();
		}
		for ( int i = 0 ; i < m ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost));
		}
		
		diikstra();
		
		for (int i = 1 ; i<= n ; i++) {
			if ( dist[i].size() != k ) {
				System.out.println(-1);
			}else {
			
				System.out.println(dist[i].peek().x);
			}
		}
	}
	
	public static void diikstra() {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(1,0));
		dist[1].add(new haha(0));
		
		while ( !pq.isEmpty() ) {
			node tmp = pq.poll();
			int now = tmp.idx;
			int cost = tmp.cost;
			
			for (int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				int nextcost = adj[now].get(i).cost;
				
				if ( dist[next].size() < k ) {
					//System.out.println(next);
					dist[next].add(new haha(nextcost+cost));
					pq.add(new node(next,nextcost+cost));
					
				}else if ( dist[next].peek().x > cost + nextcost) {
					
					dist[next].poll();
					dist[next].add(new haha(cost+nextcost));
					pq.add(new node(next,nextcost+cost));
				}
				
			}
			
		}
		
	}
	
	public static class haha implements Comparable<haha>{
		int x;
		haha(int x){
			this.x = x;
		}
		@Override
		public int compareTo(haha o) {
			if ( this.x > o.x) {
				return -1;
			}
			return 1;
		}
		
	}
	
	public static class node implements Comparable<node>{
		int idx;
		int cost;
		node(int idx,int cost){
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
