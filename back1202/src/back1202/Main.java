package back1202;

import java.io.*;
import java.util.*;
// 자바는 이분탐색으로하면 안되는 듯?
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		PriorityQueue<jewelry> pq = new PriorityQueue<>();
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			pq.add(new jewelry(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		ArrayList<Integer> back = new ArrayList<>();
		for (int i = 0 ; i < K ; i++) {
			back.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(back);
		long sum = 0;

		while ( !pq.isEmpty() ) {
			
			jewelry now = pq.poll();
			//System.out.println(now.v);
			
			int left = 0;
			int right  = back.size()-1;
			int idx = -1;
			while ( left <= right) {
				int mid = (left + right) / 2 ;
				if ( back.get(mid) < now.m) {
					left = mid + 1;
				}else {
					right = mid -1;
					idx = mid;
				}
 			}
			
			if ( idx != -1) {
				back.remove(idx);
				sum += now.v;
			}
			
			//System.out.println(idx + " " + now.v);
			
		}
		System.out.print(sum);
	}
	
	public static class jewelry implements Comparable<jewelry>{
		int m;
		int v;
		jewelry(int m,int v){
			this.m = m;
			this.v = v;
		}
		@Override
		public int compareTo(jewelry o) {
			if ( this.v < o.v ) {
				return 1;
			}
			return -1;
		}
	}
}
