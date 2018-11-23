package back16398;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<node> adj[];
	static boolean visit[];
	
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[N+1];
		for ( int i = 0 ; i < N+1 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for ( int j = 0 ; j < N ; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if ( i != j ) {
					adj[i].add(new node(j,cost));
				}
			}
		}
		
		visit = new boolean[N+1];
		System.out.print(bfs());
	}
	
	public static int bfs() {
		
		PriorityQueue<node> pq = new PriorityQueue();
		int sum = 0;
		pq.add(new node(1,0));
		
		while ( !pq.isEmpty() ) {
			
			node now = pq.poll();
			int idx = now.idx;
			int cost = now.cost;
			
			if ( visit[idx] ) {
				continue;
			}
			visit[idx] = true;
			
			sum+= cost;
			
			for ( int i = 0 ; i < adj[idx].size() ; i++) {
				int nx = adj[idx].get(i).idx;
				int nxCost = adj[idx].get(i).cost;
				pq.add(new node(nx,nxCost));
			}
			
		}
		
		return sum;
	}
	
	public static class node implements Comparable<node>{
		int idx;
		int cost;
		node ( int idx,int cost){
			this.idx = idx;
			this.cost= cost;
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
