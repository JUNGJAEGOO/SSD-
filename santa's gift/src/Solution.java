import java.io.*;
import java.util.*;


public class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testcase = 1 ; testcase <= T ; testcase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			ArrayList<node> list = new ArrayList<>();
			for ( int i = 0 ; i < N ; i++) {
				
				st = new StringTokenizer(br.readLine()," ");
				int Ai = Integer.parseInt(st.nextToken());
				int Bi = Integer.parseInt(st.nextToken());
				list.add(new node((double)Ai,(double)Bi));
			}
			
			double left = 0.01;
			double right = 100;
			double ans = 0;
			
			while ( left <= right + 0.00001) {
				
				double mid = (left+right)/2;
				boolean pandan = false;
				
				PriorityQueue<Double> pq = new PriorityQueue<>();
				for ( int i = 0 ; i < list.size() ; i++) {
					pq.add ( -(list.get(i).v - list.get(i).w * mid) ) ;
				}
				
				double sum = 0;
				for ( int i = 0 ; i < K ; i++) {
					sum += -(pq.poll());
				}
				
				if ( sum >= 0) {
					pandan = true;
				}
				//System.out.println(mid);
				
				if ( pandan ) {
					
					left = mid + 0.0001;
					ans = mid;
				}else {
					
					right = mid - 0.0001;
				}
				
			}
			
			System.out.print("#"+testcase+" ");
			System.out.format("%.3f", ans);
		}
	}
	
	public static class node{
		double v,w;
		node (double v,double w){
			this.v = v;
			this.w = w;
		}
	}
}
