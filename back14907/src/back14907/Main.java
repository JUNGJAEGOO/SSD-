package back14907;

import java.util.*;

public class Main {
	static ArrayList<Integer> adj[];
	static int inner[];
	static int dist[];
	static int cost[];
	static boolean visit[];
	static boolean first[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		adj = new ArrayList[27];
		
		for ( int i = 1 ; i<= 26 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		inner = new int[27];
		dist = new int[27];
		cost = new int[27];
		visit = new boolean[27];
		first = new boolean[27];
		
		Arrays.fill(visit, true);
		
		while ( in.hasNext() ) {
			
			String input[] = in.nextLine().split(" ");
	
			if ( input[0].equals("FINAL") ) {
				break;
			}
			String to = input[0];
			String from = "";
			if ( input.length > 2) {
				from = input[2];
			}
			int c = Integer.parseInt(input[1]);
			char[] froms = from.toCharArray();
			int TO = Integer.parseInt(String.valueOf(to.charAt(0)-'A'+1));
			first[TO] = true;
			visit[TO] = false;
			cost[TO] = c;
			for ( int i = 0 ; i < froms.length; i++) {
				
				int FROM = Integer.parseInt(String.valueOf(froms[i]-'A'+1));
				
				first[FROM] = true;
				first[TO] = true;
				visit[FROM] = false;
				visit[TO] = false;
				adj[FROM].add(TO);
				inner[TO]++;
			}
			
		}

		BFS();
		
		int max = 0;
		for ( int i = 1 ; i<= 26 ; i++) {
			if ( adj[i].size() == 0 && first[i]) {
				max = Math.max(max, dist[i]);
			}
		}
		System.out.print(max);
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		
		for ( int i = 1 ; i<= 26 ; i++) {
			if ( inner[i] == 0 && visit[i] == false) {
				q.add(new node(i,cost[i]));
				dist[i] = cost[i];
				visit[i] = true;
			}
		}
		
		while ( !q.isEmpty() ) {

			node now = q.poll();
			int idx = now.idx;
			int c = now.cost;
			
			for ( int i = 0 ; i < adj[idx].size() ; i++) {
				
				int next = adj[idx].get(i);
				int nextcost = cost[next];
				
				if ( dist[next] < dist[idx] + nextcost) {
					dist[next] = dist[idx] + nextcost;
				}
				
				inner[next]--;
			}
			
			for ( int i = 1 ; i<= 26 ; i++) {
				if ( inner[i] == 0 && visit[i] == false) {
					q.add(new node(i,cost[i]));
					visit[i] = true;
				}
			}
		}
	}
	
	public static class node{
		int idx;
		int cost;
		node ( int idx,int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}
