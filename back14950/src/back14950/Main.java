package back14950;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean visit[];
	static long result = 0;
	static int N,T;
	static ArrayList<data> adj[];
	static int inf = 1900000000;
	public static void main(String args[]) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		
		visit = new boolean[N+1];
		adj = new ArrayList[N+1];
		for ( int j = 0 ; j <= N ; j++) {
			adj[j] = new ArrayList<data>();
		}

		for ( int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			//System.out.println(x+" "+y+" "+cost);
			adj[x].add(new data(y,cost));
			adj[y].add(new data(x,cost));
		}
		
		
		BFS();
		
		
		System.out.println(result);
		
	}
	
	public static void BFS() {
		visit[1] = true;
		PriorityQueue<data> pq = new PriorityQueue<>();
		int min = inf;
		int minidx = 0;
		for ( int i = 0 ; i < adj[1].size() ; i++) {
			pq.add(new data(adj[1].get(i).index,adj[1].get(i).cost));
		}
		
		int plus= T*(-1);
		//System.out.println(plus);
		//System.out.println(min+" "+minidx);
		while ( !pq.isEmpty() ) {
			data tmp = pq.poll();
			result+=tmp.cost;
			plus+=T;
			result+=plus;
			
			//System.out.println(plus);
			visit[tmp.index] = true;
			//System.out.println(visit[tmp.index]);
			//System.out.println("@"+tmp.cost+" "+tmp.index);
			
			for ( int i = 0 ; i < adj[tmp.index].size() ; i++) {
				//System.out.println(adj[tmp.index].get(i).index+","+visit[adj[tmp.index].get(i).index]);
				if ( visit[ adj[tmp.index].get(i).index ] != true) {
					//System.out.println(adj[tmp.index].get(i).index);
					pq.add(new data(adj[tmp.index].get(i).index,adj[tmp.index].get(i).cost));
					
				}
			}
			
			boolean pass = true;
			for ( int i = 1 ; i <= N ; i++) {
				if ( visit[i] == false) {
					pass = false;
				}
			}
			if ( pass ) {
				break;
			}
		}
	}
	
	public static class data implements Comparable<data>{
		int index;
		int cost;
		data(int index, int cost){
			this.index = index;
			this.cost =cost;
		}
		
		public int compareTo(data o) {
			if ( o.cost > this.cost) {
				return -1;
			}else {
				return 1;
			}
		}
	}
}
