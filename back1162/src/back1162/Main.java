package back1162;

import java.util.*;

public class Main {
	static ArrayList<node> adj[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int K = in.nextInt();
		adj = new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost));
			adj[to].add(new node(from,cost));
		}
		
		int start = 1;
		int end = N;
		
	}
	
	public static void diikstra() {
		
	}

	public static class node{
		int idx;
		int cost;
		node(int idx,int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}
}
