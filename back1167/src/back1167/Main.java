package back1167;

import java.util.*;

public class Main {
	static ArrayList<node> tree[];
	static boolean visit[];
	static int maxidx = 0;
	static int max = 0;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int V = in.nextInt();
		tree = new ArrayList[V+1];

		for (int i = 1 ; i <= V ; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int i = 1 ; i <= V; i++) {
			
			int now = in.nextInt();
			while (  true) {
				
				int idx = in.nextInt();
				if ( idx == -1) {
					break;
				}
				int cost = in.nextInt();
				
				tree[now].add(new node(idx,cost));
			}
			
			/*for (int j = 0 ; j < tree[now].size(); j++) {
				System.out.print(tree[now].get(j).idx+" ");
			}System.out.println();
			*/
		}
		
		visit = new boolean[V+1];
		visit[1] = true;
		DFS(1,0);
		
		visit = new boolean[V+1];
		visit[maxidx] = true;
		max = 0;
		DFS(maxidx,0);
		System.out.println(max);
	}
	
	public static void DFS(int now,int cost) {
		
		//System.out.println(now+" "+cost);
		
		if ( cost > max) {
			max = cost;
			maxidx = now;
		}
		
		for (int i = 0 ; i < tree[now].size() ; i++) {
			int next = tree[now].get(i).idx;
			int nextcost = tree[now].get(i).cost;
			//System.out.println("³Ø½ºÆ® "+next);
			if ( visit[next] == false) {
				visit[next] = true;
				DFS(next,cost+nextcost);
				visit[next] = false;
			}
			
		}
		
	}
	
	
	public static class node{
		int idx;
		int cost;
		node (int idx,int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}
}
