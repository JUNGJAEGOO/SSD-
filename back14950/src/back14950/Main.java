package back14950;

import java.io.*;
import java.util.*;

public class Main {
	static int N,M,t;
	static long increase = 0;
	static ArrayList<node> adj[];
	static boolean visit[];
	static long ans = 0;
	static long count = 0;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		visit = new boolean[N+1];
		
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[from].add(new node(to,cost));
			adj[to].add(new node(from,cost));
		}
		
		go();
		
		System.out.println(ans);
	}
	
	public static void go() {
		
		PriorityQueue<node> pq = new PriorityQueue<node>();
		pq.add(new node(1,0));
		
		while ( !pq.isEmpty() ) {
			node now = pq.poll();
			//pq = new PriorityQueue<node>();
			int idx = now.to;
			
			if ( visit[now.to] == true) {
				continue;
			}
			
			long cost = now.cost;
			visit[idx] = true;
			count++;
			//System.out.println(idx+" "+cost);
			//System.out.println(cost+"+"+increase);
			
			ans += (cost+increase);
			if ( count > 1) {
			increase += t;
			}
			if ( count == N ) {
				break;
			}
			
			
			//System.out.println(increase);
			
			for ( int i = 0 ; i < adj[idx].size() ; i++) {
				int next = adj[idx].get(i).to;
				long nextcost = adj[idx].get(i).cost;
				if ( visit[next] == false) {
					pq.add(new node(next,nextcost));
				}
				
			}
		}
		
	}
	
	public static class node implements Comparable<node>{
		int to;
		long cost;
		node(int to,long cost){
			this.to = to;
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
