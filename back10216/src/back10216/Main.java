package back10216;

import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<node> list;
	static int p[];
	static int ans;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =Integer.parseInt(br.readLine());
		
		for ( int testcase = 0 ; testcase < T ; testcase++ ) {
			
			int N = Integer.parseInt(br.readLine());
			
			list = new ArrayList<>();
			p = new int[N];
			for ( int i = 0 ; i < N ; i++) {
				p[i] = i;
			}
			
			for ( int i = 0 ; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				list.add(new node((double)x,(double)y,(double)r));
			}
			
			ans = N;
			
			for ( int i = 0 ; i < N ; i++) {
				
				double nowX = list.get(i).x;
				double nowY = list.get(i).y;
				double nowR = list.get(i).r;
				
				for ( int j = i+1 ; j < N ; j++) {

					double nxX = list.get(j).x;
					double nxY = list.get(j).y;
					double nxR = list.get(j).r;
					double distance = (nowX-nxX)*(nowX-nxX) + (nowY-nxY) * (nowY-nxY);
					
					if ( (nxR + nowR) * (nxR+nowR) >= distance ) {
					
						merge(i,j);
					
					}
					
					
				}
				
			}
			
			
			
			System.out.println(ans);
		}
		
		
		
	}
	
	public static void merge(int a,int b) {
		int A = find(a);
		int B = find(b);
		
		if( A != B ) {
			ans--;
			p[A] = B;
		}
	}
	
	public static int find(int x) {
		if ( p[x] == x) {
			return x;
		}else {
			return p[x] = find(p[x]);
		}
	}
	
	public static class node{
		double x,y,r;
		node ( double x, double y , double r){
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
}
