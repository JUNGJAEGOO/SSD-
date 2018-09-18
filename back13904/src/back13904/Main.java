package back13904;
import java.util.*;
import java.io.*;
public class Main {
	static int N;
	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<node> arr = new ArrayList<>();
		for ( int i = 0 ; i< N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int day = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr.add(new node(day,cost));
		}
		
		Collections.sort(arr);
		
		PriorityQueue<node2> pq = new PriorityQueue<>();
		
		for ( int i = 0 ; i < N ; i++) {
			int Day = arr.get(i).day;
			int Cost = arr.get(i).cost;
			System.out.println(pq.size()+" "+Day+" ~ "+Cost);
			
			pq.add(new node2(Day,Cost));
			if ( pq.size() > Day) {
				node2 tmp = pq.poll();
				if ( tmp != null) {
					System.out.println(tmp.cost);
				}
			}
			
			
		}
		
		int sum = 0;
		while ( !pq.isEmpty() ) {
			sum += pq.poll().cost;
		}
		System.out.print(sum);
	}
	
	public static class node implements Comparable<node> {
		int day;
		int cost;
		node (int day,int cost){
			this.day =day;
			this.cost =cost;
		}
		
		@Override
		public int compareTo(node o) {
			if ( this.day > o.day) {
				return 1;
			}
			else if( this.day == o.day) {
				if  (this.cost > o.cost) {
					return 1;
				}
				return -1;
			}
			return -1;
		}
	}

	public static class  node2 implements Comparable<node2>{

		int day;
		int cost;
		
		node2 ( int day,int cost){
			this.day = day;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(node2 o) {
			if ( this.cost > o.cost) {
				return 1;
			}
			else if( this.cost == o.cost) {
				if  (this.day > o.day) {
					return 1;
				}
				return -1;
			}
			return -1;
		}
		
	}
	
}
