package back14431;

import java.util.*;

public class Main {
	static ArrayList<no> adj[];
	static long dist[];
	static boolean isp[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int X1 = in.nextInt();  // 1번
		int Y1 = in.nextInt();
		int X2 = in.nextInt();  // 2번
		int Y2 = in.nextInt();
		int N = in.nextInt();
		isp = new boolean[200000];
		eratos();
		
		adj = new ArrayList[4003];
		for (int i = 1 ; i<= 4002 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		ArrayList<node> list = new ArrayList<>();
		list.add(new node(X1,Y1));
		list.add(new node(X2,Y2));
		for (int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			list.add(new node(x,y));
		}
		
		
		for (int i = 0 ; i < list.size() ; i++) {
			
			double fromX = list.get(i).x;
			double fromY = list.get(i).y;
			for ( int j = 0 ; j < list.size(); j++) {
				if( i == j) {
					continue;
				}
				double toX = list.get(j).x;
				double toY = list.get(j).y;
				
				long dist = (int) (Math.sqrt((fromX-toX)*(fromX-toX) + (fromY-toY)*(fromY-toY)));
				
				//System.out.println(fromX+","+fromY+" 에서 "+toX+","+toY+" 로 "+dist);
				
				if( isp[(int) dist] == false ) {
					adj[i+1].add(new no(j+1,dist));
				}
			}
		}
		
		int inf = 1000000000;
		dist = new long[4003];
		Arrays.fill(dist, inf);
		diik();

		if ( dist[2] != inf) {
			System.out.println(dist[2]);
		}else {
			System.out.println(-1);
		}
		
	}
	
	public static void diik() {
		
		PriorityQueue<no> pq = new PriorityQueue<>();
		dist[1] = 0;
		pq.add(new no(1,0));
		
		while ( !pq.isEmpty() ) {
			no tmp = pq.poll();
			int now = tmp.idx;
			long cost = tmp.cost;
			if ( dist[now] < cost) {
				continue;
			}
			
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				long nextcost = adj[now].get(i).cost;
				if ( dist[next] > dist[now] + nextcost) {
					dist[next] = dist[now] + nextcost;
					pq.add(new no(next,nextcost));
				}
			}
			
		}
		
	}
	
	public static void eratos() {
		
		isp[1] = false;
		
		for (int i = 2 ; i< 200000 ; i++) {
			if ( isp[i] == false) {
				for (int j = i+i  ; j < 200000 ; j += i) {
					if ( j >= 200000 ) {
						break;
					}
					isp[j] = true;
				}
			}
		}
		
	}
	
	public static class no implements Comparable<no>{
		int idx;
		long cost;
		no(int idx,long cost){
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(no o) {
			if (this.cost > o.cost) {
				return 1;
			}
			return -1;
		}
	}
	
	public static class node{
		double x,y;
		node( double x, double y){
			this.x= x;
			this.y =y;
		}
	}
}
