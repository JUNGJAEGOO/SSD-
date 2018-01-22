package back3977;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> adj[];
	static ArrayList<Integer> rev[];
	static ArrayList<Integer> res[];
	static boolean visit[];
	static Stack<Integer> stk;
	static int N;
	static HashMap<String,Integer> hm;
	
	public static void main(String args[])throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(br.readLine());
		while ( T> 0) {
			StringBuilder sb = new StringBuilder();
			hm = new HashMap<>();
			N = Integer.parseInt(br.readLine());
			int idx = 0;
			adj = new ArrayList[100000];
			rev = new ArrayList[100000];
			res = new ArrayList[100000];
			for (int i = 0 ; i < 100000 ; i++) {
				adj[i] = new ArrayList<>();
				rev[i] = new ArrayList<>();
				res[i] = new ArrayList<>();
			}
			
			for ( int i = 0 ; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				String from = st.nextToken();
				String to = st.nextToken();
				int x = -1,y = -1;
				
				if ( hm.get(from) == null) {
					hm.put(from,idx);
					x = idx;
					idx++;
				}else {
					x = hm.get(from);
				}
				if ( hm.get(to) == null){
					hm.put(to,idx);
					y = idx;
					idx++;
				}else {
					y = hm.get(to);
				}

				adj[x].add(y);
				adj[y].add(x);
				rev[y].add(x);
				rev[x].add(y);
				
				
				stk = new Stack<Integer>();
				visit = new boolean[100000];
				for (int j = 0 ; j< idx ; j++) {
					DFS(j);
				}
				
				//System.out.println(stk);
				
				visit = new boolean[100000];
//				while ( !stk.isEmpty()) {
//					int now = stk.pop();
//					revDFS(now,now);
//					System.out.println(res[now]);
//				}
				//System.out.println(y);
				revDFS(y,y);
				//System.out.println(res[y].size());
				sb.append(res[y].size()+"\n");
			}
			System.out.print(sb);

			T--;
		}
	}

	public static void DFS(int start) {
		if ( visit[start] == true) {
			return;
		}
		visit[start] = true;
		for ( int i = 0 ; i < adj[start].size(); i++) {
			int next = adj[start].get(i);
			DFS(next);
		}
		
		stk.add(start);
	}
	
	public static void revDFS(int start,int real) {
		if ( visit[start] == true) {
			return;
		}
		visit[start] = true;
		for ( int i = 0 ; i < rev[start].size(); i++) {
			int next = rev[start].get(i);
			revDFS(next,real);
		}
		
		res[real].add(start);
	}

}
