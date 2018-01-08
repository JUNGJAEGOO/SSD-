package back1963;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean prime[];
	static int ans;
	static int visit[];
	static int inf = 1900000000;
	public static void main(String args[]) {
		prime = new boolean[10000];
		eratos();
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			visit = new int[10000];
			ans = inf;
			int x = in.nextInt();
			int y = in.nextInt();
			BFS(x,y);
			System.out.println(ans);
			T--;
		}
	}
	
	public static void eratos() {
		Arrays.fill(prime, true);
		prime[2] = true;
		for (int i = 2 ; i < 10000 ; i++) {
			if ( prime[i] == true) {
				//System.out.println(i);
				for ( int j = i+i ; i < 10000 ; j = j+i) {
					if ( j >= 10000) {
						break;
					}
					prime[j] = false;
				}
			}
		}
	}
	
	public static void BFS(int start,int target) {
		Queue<node> q = new LinkedList<>();
		q.add(new node(start,0));
		Arrays.fill(visit, inf);
		visit[start] = 0;
		
		while (!q.isEmpty() ) {
			node now = q.poll();
			int num = now.num;
			int cost = now.cost;
			if ( num == target) {
				//System.out.println(num+", "+cost);
				ans = Math.min(ans,cost);
			}
			
			//System.out.println(num);
			int cheon = num/1000;
			int bak = (num - cheon*1000) / 100;
			int sib = (num - cheon*1000 - bak*100) / 10;
			int ill = ( num % 10 );
			//System.out.println(cheon+","+bak+","+sib+","+ill);
			
			// 천의 자리
			for ( int i = 1 ; i<= 9 ; i++) {
				if ( i == cheon ) {
					continue;
				}else {
					int next = i*1000 + bak*100 + sib*10 + ill;
					if ( prime[next] && visit[next] > cost+1  ) {
						q.add(new node(next,cost+1));
						visit[next] = cost+1;
					}
				}
			}
			// 백의 자리
			for ( int i = 0 ; i<= 9 ; i++) {
				if ( i == bak ) {
					continue;
				}else {
					int next = cheon*1000 + i*100 + sib*10 + ill;
					if ( prime[next] && visit[next] > cost+1  ) {
						q.add(new node(next,cost+1));
						visit[next] = cost+1;
					}
				}
			}
			// 십의 자리
			for ( int i = 0 ; i<= 9 ; i++) {
				if ( i == sib ) {
					continue;
				}else {
					int next = cheon*1000 + bak*100 + i*10 + ill;
					if ( prime[next] && visit[next] > cost+1 ) {
						q.add(new node(next,cost+1));
						visit[next] = cost+1;
					}
				}
			}
			// 일의 자리
			for ( int i = 0 ; i<= 9 ; i++) {
				if ( i == ill ) {
					continue;
				}else {
					int next = cheon*1000 + bak*100 + sib*10 + i;
					if ( prime[next] && visit[next] > cost+1  ) {
						q.add(new node(next,cost+1));
						visit[next] = cost+1;
					}
				}
			}
		}
	}
	
	public static class node{
		int num;
		int cost;
		node(int num,int cost){
			this.num = num;
			this.cost =cost;
		}
	}
}
