package back16397;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int dp[];
	static int G,T;
	static final int inf = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input[] = sc.nextLine().split(" ");
		int N = Integer.parseInt(input[0]);
		T = Integer.parseInt(input[1]);
		G = Integer.parseInt(input[2]);
		
		dp = new int[100_000];
		Arrays.fill(dp, inf);
		
		func(N);
		
		if ( dp[G] == inf || dp[G] > T ) {
			System.out.print("ANG");
		}else {
			System.out.print(dp[G]);
		}
	}
	
	public static void func(int start) {
		
		PriorityQueue<node> pq = new PriorityQueue();
		pq.add(new node(start,0));
		dp[start] = 0;
		
		while ( !pq.isEmpty() ) {
			
			node now = pq.poll();
			int num = now.num;
			int cnt = now.cnt;
			
			if ( num + 1 <= 99_999 ) {
				if ( dp[num+1] > cnt + 1 ) {
					dp[num+1] = cnt + 1;
					pq.add(new node(num+1,cnt+1));
				}
			}
			
			if ( num != 0 && num * 2 <= 99_999) {
				
				int length = String.valueOf(num*2).length();
				int next = num*2 - (int)Math.pow(10, length-1);
				if ( dp[next] > cnt + 1) {
					dp[next] = cnt + 1;
					pq.add(new node(next,cnt+1));
				}
				
			}
			
			
		}
		
		
	}
	
	public static class node implements Comparable<node>{
		int num;
		int cnt;
		node ( int num , int cnt){
			this.num = num;
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
