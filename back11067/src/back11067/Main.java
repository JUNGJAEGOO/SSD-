package back11067;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> list[];
	static ArrayList<node> ans;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb =new StringBuilder();
		
		while ( T > 0) {
			
			int N = Integer.parseInt(br.readLine());
			
			ans  =new ArrayList<>();
			list = new ArrayList[100001];
			for ( int i = 0 ; i < 100001 ; i++) {
				list[i] = new ArrayList<>();
			}
			
			for ( int i = 0 ; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list[x].add(y);
			}
			
			for ( int i = 0 ; i < 100001 ; i++) {
				if ( list[i].size() > 1) {
					Collections.sort(list[i]);
				}
			}
			
			int nowX = 0;
			int nowY = 0;
			ans.add(new node(0,0));
			for  (int i = 0 ; i < 100001 ; i++) {
				if ( list[i].size() > 0) {
					
					if ( list[i].get(list[i].size()-1) <= nowY ) {
						for ( int j = list[i].size()-1 ; j >=0  ; j--) {
							ans.add(new node(i,list[i].get(j)));
						}
						nowX = i;
						nowY = list[i].get(0);
					}else if ( list[i].get(0) >= nowY){
						for ( int j = 0 ; j < list[i].size() ; j++) {
							ans.add(new node(i,list[i].get(j)));
							
						}
						nowX = i;
						nowY = list[i].get(list[i].size()-1);
					}
					
				}else {
					continue;
				}
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			
			for ( int i = 0 ; i < M ; i++) {
				
				int question = Integer.parseInt(st.nextToken());
				sb.append(ans.get(question).x+" "+ans.get(question).y+"\n");
				
			}
			
			
			T--;
		}
		
		System.out.print(sb);
	}
	
	public static class node implements Comparable<node>{
		int x,y;
		node (int x,int y){
			this.x =x ;
			this.y =y ;
		}
		@Override
		public int compareTo(node o) {
			if ( this.x > o.x) {
				return 1;
			}else if (this.x == o.x){
				if ( this.y > o.y) {
					return 1;
				}else {
					return -1;
				}
			}
			return -1;
		}
		
	}
}
