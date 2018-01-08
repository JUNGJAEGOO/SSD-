package back1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<node> adj[];
	static int res = 0;
	static int first;
	static int second;
	public static void main(String args[]) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		for ( int i = 1 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		StringTokenizer st;
		
		if ( N == 1) {
			System.out.println(0);
			return;
		}
		
		for ( int i = 0 ; i < N-1 ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[parent].add(new node(child,cost));
			
		}
		
		/*int fake = 0;
		for ( int i = 1 ; i <= N ; i++) {
			if (i == N)  {
				System.out.println(fake);
				return;
			}else if (adj[i].size() == 1 ) {
				fake += adj[i].get(0).cost;
			}
			else {
				break;
			}
		}*/
	/*	6
		1 2 3
		2 3 4
		2 4 5
		3 5 6
		5 6 7*/
/*		6
		1 2 3
		2 3 4
		2 4 1
		3 5 6
		5 6 7*/
		
		for ( int i = 1 ; i <= N ; i++) {
			
			if ( adj[i].size() <= 0) {
				continue;
			}
			ArrayList<Integer> tmp = BFS(i);
			Collections.sort(tmp);
			//System.out.println(tmp);
			
			if ( tmp.size() >= 2) {
				res = Math.max(res,tmp.get(tmp.size()-1)+tmp.get(tmp.size()-2));
			}else if ( tmp.size() <= 1) {
				res = Math.max(res,tmp.get(tmp.size()-1));
			}
			
		}
		System.out.println(res);
	}
	
	public static ArrayList<Integer> BFS(int start) {
		int cnt = 0;
		ArrayList<Integer> result = new ArrayList<>();
		while ( cnt < adj[start].size() ) {
			
		Queue<tree> q = new LinkedList<>();
		q.add(new tree(adj[start].get(cnt).x,adj[start].get(cnt).cost));
		int max = 0;
		
		while ( !q.isEmpty() ) {
			tree now = q.poll();
			int idx = now.idx;
			int sum = now.sum;
			if ( adj[idx].size() == 0) {
				if ( sum > max) {
					max = sum;
				}
			}
			
			for ( int i = 0 ; i < adj[idx].size() ; i++) {
				int next = adj[idx].get(i).x;
				int cost = adj[idx].get(i).cost;
				q.add(new tree(next,sum+cost));
			}
			
		}
		result.add(max);
		cnt++;
		}
		
		return result;
	}
	
	public static class node{
		int x;
		int cost;
		node ( int x , int cost){
			this.x =x;
			this.cost = cost;
		}
	}
	
	public static class tree{
		int idx;
		int sum;
		tree(int idx,int sum){
			this.idx = idx;
			this.sum = sum;
		}
	}
		
}
