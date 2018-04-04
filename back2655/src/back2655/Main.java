package back2655;

import java.util.*;

public class Main {
	static ArrayList<node> list = new ArrayList<>();
	static int dp[];
	static int prev[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		prev = new int[101];
		list.add(new node(-1,-1,-1,-1));
		for ( int i = 0 ; i < N ; i++) {
			int width = in.nextInt();
			int height = in.nextInt();
			int weight = in.nextInt();
			list.add(new node(width,height,weight,i+1));
		}
		
		Collections.sort(list);
		
		dp = new int[101];
		
		for ( int i = 1 ; i <= N ; i++) {
			
			int stanWidth = list.get(i).width;
			int stanWeight = list.get(i).weight;
			dp[i] = list.get(i).height;
			
			for ( int j = 1 ; j < i ; j++) {
				if ( list.get(j).weight < stanWeight && list.get(j).width < stanWidth ) {
					if( dp[j]+list.get(i).height > dp[i] ) {
						dp[i] = dp[j] + list.get(i).height;
						prev[i] = j;
					
					}
				}
			}
			
		}
		
		
		for ( int i = 1 ; i <= 100 ; i++) {
			
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		int cur = 0;
		while ( prev[cur] != 0 ) {
			ans.add(list.get(prev[cur]).id);
			cur = prev[cur];
		}

		Collections.sort(ans);
		System.out.println(ans.size());
		for ( int i = ans.size()-1 ; i>=0; i--) {
			System.out.println(ans.get(i));
		}
		
	}
	
	
	
	public static class node implements Comparable<node>{
		int width;
		int height;
		int weight;
		int id;
		node ( int width,int height,int weight,int id){
			this.width = width;
			this.height = height;
			this.weight = weight;
			this.id = id;
		}
		@Override
		public int compareTo(node o) {
			if ( this.width < o.width) {
				return -1;
			}
			return 1;
		}
	}
}
