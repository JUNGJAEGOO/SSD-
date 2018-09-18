package back2162;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N,p[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ArrayList<SET> list = new ArrayList<>();
		
		for ( int i = 0 ; i < N ; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			list.add(new SET(x1,y1,x2,y2));
			
		}
		
		p = new int[N+1];
		for ( int i = 0 ; i <= N ; i++) {
			p[i] = i;
		}
		
		
		for ( int i = 0 ; i < N ; i++) {
			
			for ( int j = 0 ; j < N ; j++) {
				
				if ( find(i) == find(j) ) {
					continue;
				}
				
				if ( pandan(list.get(i),list.get(j)) ) {
					merge(i,j);
				}
				
			}
			
		}
		
		int max = 0;
		HashMap<Integer,Integer> hm = new HashMap<>();
		for ( int i = 0 ; i < N ; i++) {
			if ( hm.get(p[i]) == null ) {
				hm.put(p[i],1);
				max = Math.max(max, 1);
			}else {
				hm.replace(p[i],hm.get(p[i])+1);
				max = Math.max(max, hm.get(p[i]));
			}
			//System.out.print(p[i]+" ");
		}//System.out.println();
		
		System.out.println(hm.size()+"\n"+max);
	}
	
	public static int find(int a) {
		if ( p[a] == a) {
			return a;
		}else {
			return p[a] = find(p[a]);
		}
	}
	
	public static void merge(int a,int b) {
		int A = find(a);
		int B = find(b);
		if ( A!=B) {
			p[A] = B;
		}
	}
	
	public static boolean pandan(SET set1,SET set2) {
		
		long x1 = set1.x1;
		long y1 = set1.y1;
		long x2 = set1.x2;
		long y2 = set1.y2;
		
		long x3 = set2.x1;
		long y3 = set2.y1;
		long x4 = set2.x2;
		long y4 = set2.y2;
		
		point tmp1 = new point(x1,y1);
		point tmp2 = new point(x2,y2);
		point tmp3 = new point(x3,y3);
		point tmp4 = new point(x4,y4);
		
		long ans1 = CCW(tmp1,tmp2,tmp3) * CCW(tmp1,tmp2,tmp4);
		long ans2 = CCW(tmp3,tmp4,tmp1) * CCW(tmp3,tmp4,tmp2);
		
		if ( ans1 > 0 || ans2 > 0) {
			return false;
		}
		
		SET l1 = new SET(Math.min(x1, x2),Math.min(y1, y2),Math.max(x1, x2),Math.max(y1, y2));
		SET l2 = new SET(Math.min(x3, x4),Math.min(y3, y4),Math.max(x3, x4),Math.max(y3, y4));
		
		if ( l1.x2 < l2.x1 || l2.x2 <  l1.x1 ) {
			return false;
		}
		
		if ( l1.y2 < l2.y1 || l2.y2 < l1.y1 ) {
			return false;
		}
		
		return true;
	}
	
	public static long CCW(point p1,point p2,point p3) {
		
		long ans = p1.x*p2.y + p2.x*p3.y + p3.x*p1.y;
		ans = ans - p1.y*p2.x - p2.y*p3.x - p3.y*p1.x;
		return ans;
	}
	
	public static class SET{
		long x1,y1,x2,y2;
		SET(long x1,long y1,long x2,long y2){
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	
	public static class point{
		long x,y;
		point (long x,long y){
			this.x = x;
			this.y = y;
		}
	}
}
