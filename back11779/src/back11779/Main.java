package back11779;

import java.util.*;

public class Main {
	static ArrayList<node> adj[];
	static int dist[];
	static int prev[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		adj = new ArrayList[N+1];
		for ( int i = 0 ; i < N+1 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost));
			
		}
		
		prev = new int[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		int start = in.nextInt();
		int end = in.nextInt();
		
		diik(start);
		
		System.out.println(dist[end]);
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(end);
		for ( int i = end ; i != start ; i = prev[i]) {
			//System.out.print(prev[i]+" ");
			list.add(prev[i]);
		}
		
		System.out.println(list.size());
		Collections.reverse(list);
		for ( int i = 0 ; i < list.size() ; i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}
	
	public static void diik(int start) {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start,0));
		dist[start] = 0;
		prev[start] = start;
		
		while ( !pq.isEmpty() ) {
			
			node now = pq.poll();
			int cost = now.cost;
			int nowidx = now.idx;
			
			if ( dist[nowidx] < cost) {
				continue;
			}
			
			for ( int i = 0 ; i<adj[nowidx].size() ; i++) {
				
				int next = adj[nowidx].get(i).idx;
				int nextcost = adj[nowidx].get(i).cost;
				
				if ( dist[next] > cost + nextcost ) {
					prev[next] = nowidx;
					dist[next]  = cost + nextcost;
					pq.add(new node(next,cost+nextcost));
				}
				
			}
		}
	}
	
	public static class node implements Comparable<node>{
		int idx;
		int cost;
		node (int idx,int cost){
			this .idx = idx;
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
