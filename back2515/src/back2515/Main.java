package back2515;

import java.util.*;

public class Main {
	static int dp[];
	static ArrayList<node> arr = new ArrayList<>();
	static int N,K;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		K = in.nextInt();
		dp = new int[N+1];

		for (int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			arr.add(new node(x,in.nextInt()));
			
		}
		arr.add(new node(-1,-1));
		Collections.sort(arr);
		/*for(int i = 0 ; i < N ; i++) {
			System.out.println(arr.get(i).h+" "+arr.get(i).cost);
		}*/
		
		int j = 0;
		for (int i = 1 ; i <= N ; i++) {
			while ( arr.get(i).h - arr.get(j+1).h >= K ) {
				j++;
			}
			dp[i] = Math.max(dp[i-1], dp[j]+arr.get(i).cost);
			//System.out.println(dp[i]);
		}
		//System.out.println(dp[1]);
		System.out.println(dp[N]);
		
	}
	

	
	public static class node implements Comparable<node>{
		int h;
		int cost;
		node (int h,int cost){
			this.h =h;
			this.cost =cost;
		}
		@Override
		public int compareTo(node o) {
			if ( this.h > o.h) {
				return 1;
			}
			return -1;
		}
	}
}
