package back1005;

import java.util.*;

public class Main {
	static ArrayList<Integer> inner[];
	static ArrayList<Integer> adj[];
	static int cost[];
	static int N,K;
	static int Target;
	static int result[];
	static int inf = 1900000000;
	static boolean visit[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			N = in.nextInt();
			K = in.nextInt();
			
			inner = new ArrayList[N+1];
			adj = new ArrayList[N+1];
			for ( int i = 1 ; i <= N ; i++) {
				inner[i] = new ArrayList<Integer>();
				adj[i] = new ArrayList<Integer>();
			}
			
			result = new int[N+1];
			//Arrays.fill(result, inf);
			cost = new int[N+1];
			visit = new boolean[N+1];
			for ( int i = 1 ; i<= N ; i++) {
				cost[i] = in.nextInt();
			}
			
			for ( int i = 0 ; i < K ; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				adj[from].add(to);
				inner[to].add(from);
			}
			
			Target = in.nextInt();
	
			weesang();
			
//			for ( int i = 1 ; i <= N ; i++) {
//				System.out.print(result[i]+" ");
//			}System.out.println();
			
			System.out.println(result[Target]);
			
			T--;
		}
	}
	
	public static void weesang() {
		
		Queue<Integer> q = new LinkedList<>();
		for ( int i = 1 ; i <= N ; i++) {
			if ( inner[i].size() == 0) {
				result[i] = cost[i];
				q.add(i);
				visit[i] = true;
				break;
			}
		}
		
		while( !q.isEmpty() ) {
			
			
			int now = q.poll();
			//System.out.println("Áö±Ý "+now);
			if ( now == Target) {
				break;
			}
			
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i);
				result[next] = Math.max(result[next],cost[next]+result[now]);
				for ( int j = 0; j < inner[next].size() ; j++) {
					if ( inner[next].get(j) == now ) {
							inner[next].remove(j);
						break;
					}
				}
			}
			
			for ( int i = 1 ; i <= N ; i++) {
				if ( inner[i].size() == 0 && visit[i] == false) {
					
					q.add(i);
					visit[i] = true;
				}
			}
			
		}
		
	}
}
