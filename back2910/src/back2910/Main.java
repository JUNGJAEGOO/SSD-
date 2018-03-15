package back2910;

import java.util.*;

public class Main {
	static HashMap<Integer,Integer> hm = new HashMap<>();
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int C = in.nextInt();
		
		
		for (int i = 0 ; i < N; i++) {
			int x = in.nextInt();
			if ( hm.get(x) == null ) {
				hm.put(x,1);
			}else {
				hm.put(x, hm.get(x)+1);
			}
			
			if ( !list.contains(x) ) {
				list.add(x);
			}
		}
		
		ArrayList<Integer> adj[] = new ArrayList[1001];
		for (int i = 0 ; i < 1001 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		Iterator itr = hm.keySet().iterator();
		
		while ( itr.hasNext() ) {
			int key = (int)itr.next();
			int res = hm.get(key);
			adj[res].add(key);
		}
		
		StringBuilder sb = new StringBuilder();
		for ( int i = 1000 ; i >= 1 ; i--) {
			if ( adj[i].size() == 1 ) {
				for (int j = 0 ; j < i ; j++) {
					sb.append(adj[i].get(0)+" ");
				}
			}else if ( adj[i].size() > 1) {
				
				ArrayList<node> tmp = new ArrayList<>();
				for ( int j = 0 ; j < adj[i].size() ; j++) {
					
					int num = adj[i].get(j);
					int idx = 0;
					for ( int k = 0 ; k < list.size() ; k++) {
						if ( list.get(k) == num) {
							idx = k;
							break;
						}
					}
					tmp.add(new node(num,idx));
				}
				Collections.sort(tmp);
				
				for ( int j = 0 ; j < tmp.size();  j++) {
					
					for (int k = 0 ; k < i ; k++) {
						sb.append(tmp.get(j).idx+" ");
					}
					
				}
			}
		}
		System.out.print(sb);
	}
	
	public static class node implements Comparable<node>{
		int idx;
		int cnt;
		node ( int idx, int cnt){
			this.idx = idx;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(node o) {
			if ( this.cnt > o.cnt) {
				return 1;
			}
			return -1;
		}
	}
}
