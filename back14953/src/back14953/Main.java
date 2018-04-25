package back14953;

import java.util.*;

public class Main {
	
	static ArrayList<Integer> adj[];
	static int arr[];
	static int dist[];
	static int ans = 0;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		
		adj = new ArrayList[N+1];
		for (int i = 0 ; i < N+1 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		arr = new int[N+1];
		
		for ( int i = 0 ; i < M ; i++) {
			
			int from = in.nextInt();
			int to = in.nextInt();
			adj[from].add(to);
			adj[to].add(from);
			arr[from]++;
			arr[to]++;
			
		}
		
		dist = new int[N+1];
		for ( int i = 0 ; i < N ; i++) {
			diik(i);
		}
		
		for ( int i = 0 ; i < N ; i++) {
			System.out.print(dist[i]+" ");
		}System.out.println();
		
		System.out.print(ans);
	}
	
	public static void diik(int start) {
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(start,1));
		dist[start] = 1;
		
		while ( !q.isEmpty() ) {
			
			node tmp = q.poll();
			
			int now = tmp.idx;
			int cost = tmp.cost;
			
			
			ans = Math.max(ans, cost);
			
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				
				int next = adj[now].get(i);
				if ( arr[next] > arr[now] ) {
					if( dist[next] < cost + 1) {
						dist[next] = cost + 1;
						q.add(new node(next,cost+1));
					}
				}
				
			}
			
			
		}
		
		
	}

	public static class node implements Comparable<node>{
		int idx;
		int cost;
		node ( int idx,int cost){
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
