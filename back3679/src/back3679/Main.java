package back3679;

import java.io.*;
import java.util.*;

public class Main {
	static long inf = -400001;
	static node max = new node(-1,inf,inf);
	static ArrayList<node> list;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while (T > 0 ) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			long n = Long.parseLong(st.nextToken());
			//System.out.println(n);
			list = new ArrayList<>();
			
			for ( int i = 0 ; i < n ; i++) {
				
				long x = Long.parseLong(st.nextToken());
				long y = Long.parseLong(st.nextToken());
				list.add(new node(i,x,y));
				
			}
			
			Collections.sort(list);
			
			int cnt = 1;
			for ( int i = (int)n-2 ; i >= 1 ; i--) {
				if ( CCW(list.get(0),list.get(list.size()-1),list.get(i)) == 0) {
					cnt++;
				}else {
					break;
				}
			}
			
			ArrayList<node> tmplist = new ArrayList<>();
			if ( cnt >= 2) {
				
				for ( int i = list.size() - cnt ; i < list.size()-1 ; i++) {
					tmplist.add(new node(list.get(i).idx,list.get(i).x,list.get(i).y));
				}
			}
			
			Collections.reverse(tmplist);
			//System.out.println(cnt);
			
			for ( int i = 0 ; i < list.size() -cnt+1 ; i++) {
				System.out.print(list.get(i).idx+" ");
			}
			for ( int i = 0 ; i < tmplist.size() ; i++) {
				System.out.print(tmplist.get(i).idx+" ");
			}
			
			System.out.println();
			
			T--;
		}
		
	}
	
	public static long CCW(node p1,node p2,node p3) {
		return p1.x*p2.y + p2.x*p3.y + p3.x*p1.y - p1.y*p2.x- p2.y*p3.x - p3.y*p1.x;
	}
	
	public static long dist(node p1,node p2) {
		long X = p1.x - p2.x;
		long Y = p1.y - p2.y;
		
		return X*X + Y*Y;
	}
	
	public static class node implements Comparable<node>{

		long idx;
		long x,y;
		
		node (long idx,long x,long y){
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(node o) {
			
			long ccw = CCW(max,this,o);
			
			if ( ccw > 0) {
				return -1;
			}else if (ccw < 0) {
				return 1;
			}else if ( ccw == 0) {
				long d1 = dist(max,this);
				long d2 = dist(max,o);
				
				if ( d2 > d1) {
					return -1;
				}else {
					return -1;
				}
				
			}
			
			return 0;
		}
		
	}
}
