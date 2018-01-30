package back10451;

import java.util.*;

public class Main {
	static boolean visit[];
	static int N;
	static ArrayList<Integer> adj[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T> 0) {
			
			N = in.nextInt();
			visit = new boolean[N+1];
			adj = new ArrayList[N+1];
			for (int i = 1 ; i <= N ; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 1 ; i <= N ; i++) {
				int from = i;
				int to = in.nextInt();
				adj[from].add(to);
			}
			
			int cnt = 0;
			for (int i =1 ; i<= N ; i++) {
				if ( visit[i] == false) {
					cnt++;
					BFS(i);
				}
			}
			
			System.out.println(cnt);
			
			T--;
		}
	}
	
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;
		while (!q.isEmpty() ) {
			int now = q.poll();
			
			for (int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i);
				if ( visit[next] == false) {
					visit[next] = true;
					q.add(next);
				}
			}
		}
	}
}
