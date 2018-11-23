package back15971;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<node> adj[];
	static int dist[];
	static int pre[];
	static int preDist[];
	static final int inf = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		adj  = new ArrayList[N+1];
		for ( int i = 0 ; i < N+1 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < N-1 ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			adj[a].add(new node(b,dist));
			adj[b].add(new node(a,dist));
		}
		dist = new int[N+1];
		pre = new int[N+1];
		preDist = new int[N+1];
		Arrays.fill(dist, inf);
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(A,0));
		dist[A] = 0;
		
		while ( !pq.isEmpty()) {
			
			node now = pq.poll();
			int nowidx = now.idx;
			int nowcost = now.cost;
			
			if ( dist[nowidx] < nowcost ) {
				continue;
			}
			
			for ( int i = 0 ; i < adj[nowidx].size() ; i++ ) {
				
				int next =  adj[nowidx].get(i).idx;
				int nextcost = adj[nowidx].get(i).cost;
				
				if ( dist[next] > nowcost + nextcost) {
					pre[next] = nowidx;
					preDist[next] =  nextcost;
					dist[next] = nowcost + nextcost;
					pq.add(new node(next,nowcost+nextcost));
				}
				
			}
			
		}
		
		//System.out.println(dist[B]);
		int max = 0;
		
		for ( int i = B ; i != A ; i = pre[i] ) {
			//System.out.println(i+" "+preDist[i]);
			
			max = Math.max(max, preDist[i]);
			
		}
		
		System.out.print(dist[B] - max);
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
