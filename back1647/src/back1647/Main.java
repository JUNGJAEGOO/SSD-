package back1647;

import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static boolean visit[];
	static ArrayList<node> adj[];
	static long sum = 0;
	static int last = -1;
	
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N+1];
		adj = new ArrayList[N+1];
		for ( int i = 0 ; i < N+1 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[from].add(new node(to,cost));
			adj[to].add(new node(from,cost));
			
		}
		
		BFS();
		
		System.out.println(sum-last);
		
	}
	
	public static void BFS() {
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(1,0));
		
		while ( !pq.isEmpty()) {
			
			if ( visit[pq.peek().idx] == true) {
				pq.poll();
				continue;
			}else {
				visit[pq.peek().idx] = true;
			}
			
			node now = pq.poll();
			int nowidx = now.idx;
			int nowcost = now.cost;
			sum += nowcost;
			last = Math.max(last, nowcost);
			//System.out.println(nowidx+" "+nowcost);
			
			for ( int i = 0 ; i < adj[nowidx].size() ; i++) {
				int next = adj[nowidx].get(i).idx;
				int nextcost = adj[nowidx].get(i).cost;
				if ( visit[next] == false) {
					pq.add(new node(next,nextcost));
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
