package back1922;

import java.util.*;

public class Main {
	static ArrayList<node> adj[];
	static boolean visit[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		adj = new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		for ( int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost));
			adj[to].add(new node(from,cost));
		}
		visit = new boolean[N+1];
		long sum = 0;
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(1,0));
		while ( !pq.isEmpty() ) {
			node now = pq.poll();
			//System.out.println(now.idx);
			if ( visit[now.idx]) {
				continue;
			}
			int idx = now.idx;
			int cost = now.cost;
			sum += cost;
			visit[idx] = true;
			for (int i = 0 ; i < adj[idx].size() ; i++) {
				int next = adj[idx].get(i).idx;
				int Cost = adj[idx].get(i).cost;
				pq.add(new node(next,Cost));
				
			}
			
		}
		
		System.out.println(sum);
	}
	
	public static class node implements Comparable<node>{
		int idx,cost;
		node(int idx,int cost){
			this.idx = idx;
			this.cost =cost;
		}
		
		public  int compareTo(node o) {
			if ( this.cost > o.cost) {
				return 1;
			}else {
				return -1;
			}
		}


	}
}
