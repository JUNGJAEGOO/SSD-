package back14226;

import java.util.*;

public class Main {
	
	static boolean visit[][];
	static int inf = 1000000000;
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		visit = new boolean[2001][2001];
		BFS();
		
	}
	
	public static void BFS() {
		
		Queue<node> q = new LinkedList<>();
		q.add(new node(1,0,0));
		//cost[1] = 0;
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int sum = now.sum;
			int cnt = now.cnt;
			int clip = now.clip;
			if ( sum == N) {
				System.out.println(cnt);
				break;
			}
			
			q.add(new node(sum,cnt+1,sum));
			
			if ( sum+clip <= 1000 && visit[sum+clip][clip] == false) {
				q.add(new node(sum+clip,cnt+1,clip));
				visit[sum+clip][clip] = true;
			}
			
			if ( sum-1 >= 1 && visit[sum-1][clip] == false) {
				q.add(new node(sum-1,cnt+1,clip) );
				 visit[sum-1][clip] = true;
			}
			
		}
	}
	
	public static class node{
		int sum;
		int cnt;
		int clip;
		node (int sum,int cnt,int clip){
			this.clip = clip;
			this.sum = sum;
			this.cnt = cnt;
		}
	}

}
