package back1504;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<node> adj[];

	static int x,y,N;
	static int two,three;
	static int tmp;
	static long inf = 1000000000;
	static long dist[];
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];

		for ( int i = 1 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adj[from].add(new node(to,cost));
			adj[to].add(new node(from,cost));
		}
		
		st = new StringTokenizer(br.readLine()," ");
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		diikstra(1);
		long oneTOx = dist[x];
		long oneTOy = dist[y];
		diikstra(x);
		long xTOy = dist[y];
		long xTOn = dist[N];
		diikstra(y);
		long yTOx = dist[x];
		long yTOn = dist[N];
		
		long ans1 = oneTOx + xTOy + yTOn;
		long ans2 = oneTOy + yTOx + xTOn;
		long res = Math.min(ans1, ans2);
		if ( res >= inf) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}
	}
	
	public static void diikstra(int start) throws InterruptedException {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start,0));
		boolean pass1 = false;
		boolean pass2 = false;
		dist = new long[N+1];
		Arrays.fill(dist, inf);
		dist[start] = 0;
		while ( !pq.isEmpty() ) {
			node now = pq.poll();
			int nowindex = now.idx;
			int nowcost = now.cost;
			
			if (dist[nowindex] < nowcost) { continue; }
			
			//System.out.println(nowindex);
			
			for ( int i = 0 ; i < adj[nowindex].size() ; i++) {
				int there = adj[nowindex].get(i).idx;
				int therecost = adj[nowindex].get(i).cost;
				if ( dist[there] > dist[nowindex] + therecost) {
					dist[there] = dist[nowindex] + therecost;
					pq.add(new node(adj[nowindex].get(i).idx,adj[nowindex].get(i).cost));
				}
				
				//System.out.println(adj[nowindex].get(i).idx+" , "+adj[nowindex].get(i).cost);
			}
		
		}
		
		/*for ( int i = 1 ; i <= N ; i++) {
			System.out.print(dist[i]+" ");
		}System.out.println();
		*/
	}
	
	public static class node implements Comparable<node> {
		int idx;
		int cost;
		node(int idx,int cost){
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(node o) {
			if ( this.cost > o.cost ) {
				return 1;
			}else {
				return -1;
			}
		}
	}
}
