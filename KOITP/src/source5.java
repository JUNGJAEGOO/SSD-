import java.util.*;
import java.io.*;

public class source5 {
	static ArrayList<Integer> adj[];
	static boolean visit[];
	static ArrayList<Integer> parent[];
	static int R;
	static boolean res;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		parent = new ArrayList[N+1];
		adj = new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for ( int i = 0 ; i < N+1 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 1 ; i <= N ; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			adj[i].add(x);
		}
		
		
		
		for ( int i = 0 ; i < Q ; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			int par = Integer.parseInt(st.nextToken());
			int chil = Integer.parseInt(st.nextToken());
			res = false;
			dfs(par,chil);
			if (  res ) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
	}
	
	public static void dfs(int target,int now) {
		
		//System.out.println(now+" "+target);
		
		if ( now == target) {
			//System.out.println("bye");
			res = true;
			return;
		}else if ( now == R) {
			return;
		}else {
			dfs(target,adj[now].get(0));
		}
	
	}
}
