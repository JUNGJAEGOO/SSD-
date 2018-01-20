package back1865;

import java.util.*;

public class Main {
	static int dist[];
	static int N,M,W;
	static int inf = 999999999;
	static ArrayList<node> list;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			N = in.nextInt();
			M = in.nextInt();
			W = in.nextInt();
			
			dist = new int[N+1];
			Arrays.fill(dist, inf);
			list = new ArrayList<>();
			
			for ( int i = 0 ; i < M ; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				int cost = in.nextInt();
				list.add(new node(from,to,cost));
				list.add(new node(to,from,cost));
			}
		
			
			for ( int i = 0 ; i < W; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				int cost = in.nextInt();
				list.add(new node(from,to,-cost));
			}
			
			boolean pass = false;
			dist[1] = 0;
			for (int i = 1 ; i <= N ; i++){
				pass = false;
				for (int j = 0 ; j < list.size() ; j++) {
					
					int from = list.get(j).from;
					int to = list.get(j).to;
					int cost = list.get(j).cost;
					
					if ( dist[from] == inf) {
						continue;
					}
					
					if ( dist[to] > dist[from] + cost) {
						//System.out.println(to+" "+from);
						dist[to] = dist[from] + cost;
						pass = true;
					}
				}
			}
			
/*			for ( int i = 1 ; i <= N ; i++) {
				System.out.print(dist[i]+" ");
			}System.out.println();
			*/
			if ( pass == true) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
			
			T--;
		}
	}
	
	public static class node{
		int from;
		int to;
		int cost;
		node (int from,int to,int cost){
			this.from = from;
			this.to= to;
			this.cost =cost;
		}
	}
}
