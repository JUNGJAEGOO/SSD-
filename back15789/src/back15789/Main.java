package back15789;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> adj[];
	static boolean visit[];
	static ArrayList<Integer> group[];
	static int noW = 1;
	static int gogo;
	static int C;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		adj  =new ArrayList[N+1];
		for ( int i = 0 ; i < N+1 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i= 0 ; i < M ; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			//System.out.println(from+" "+to);
			adj[from].add(to);
			adj[to].add(from);
			
		}
		
		
		
		 st = new StringTokenizer(br.readLine()," ");
		 C = Integer.parseInt(st.nextToken());
		 int H = Integer.parseInt(st.nextToken());
		 int K = Integer.parseInt(st.nextToken());
		 
		 group = new ArrayList[N+1];
			for (int i = 0 ; i < N+1 ; i++) {
				group[i] = new ArrayList<>();
			}
			
			visit = new boolean[N+1];
			int groupcnt = 0;
			for ( int i = 1 ; i<= N ; i++) {
				
				if ( visit[i] == false) {
					visit[i] = true;
					BFS(i,groupcnt);
					groupcnt++;
				}
				
			}
			
			ArrayList<node> info = new ArrayList<>();
			for ( int i = 0 ; i < groupcnt ; i++) {
				info.add(new node(i,group[i].size()));
			}
			Collections.sort(info);
		 
		 
		 
		 
		 ArrayList<Integer> res = new ArrayList<>();
		 
		 /*for ( int i = 0 ; i < groupcnt ; i++) {
			 System.out.println(group[i]+" "+info.get(i).idx);
		 }*/
		 
		 int cnt = 0;
		 int ans = 0;
		 
		 while ( true ) {
			 if ( K == 0) {
				 break;
			 }
			 
			 if ( !group[info.get(cnt).idx].contains(H) ) {
				 ans += group[info.get(cnt).idx].size();
				 cnt++;
				 K--;
			 }else {
				 cnt++;
			 }
			 
			 if ( cnt >= info.size()) {
				 break;
			 }
		 }
		 
		 //System.out.println(gogo);
		 if ( ans == 1 && gogo == 1) {
			 System.out.print(1);
		 }else {
			 System.out.print(ans+gogo);
		 }
	}
	
	static class node implements Comparable<node>{
		int idx;
		int size;
		node ( int idx,int size){
			this.idx = idx;
			this.size = size;
		}
		@Override
		public int compareTo(node o) {
			if ( this.size < o.size) {
				return 1;
			}
			return -1;
		}
	}
	
	public static void BFS(int start,int groupcnt) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		group[groupcnt].add(start);
		
		boolean sw = false;
		
		noW = 0;

		while ( !q.isEmpty() ) {
			
			int now = q.poll();
			if ( now == C) {
				sw = true;
			}
			noW++;
			//System.out.println(now+" "+adj[now]);
			
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i);
				//System.out.println(next);
				if ( visit[next] == false) {
					visit[next] = true;
					group[groupcnt].add(next);
					q.add(next);
				}
			}
			
		}
		
		if( sw ) {
			gogo = noW;
		}
		
		
	}
}
