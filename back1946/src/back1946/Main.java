package back1946;

import java.util.*;

public class Main {
	static ArrayList<node> list;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			
			int N = in.nextInt();
			list = new ArrayList<>();
			
			for ( int i = 0 ; i < N ; i++) {
				int paper = in.nextInt();
				int inter = in.nextInt();
				list.add(new node(inter,paper));
			}
			
			Collections.sort(list);
			
			int sum = 1;
			int maxpaper = list.get(0).paper;
			for ( int i = 1 ; i < N ; i++) {
				
				if ( list.get(i).paper > maxpaper) {
					
				}else {
				maxpaper = list.get(i).paper;
				sum++;
				}
				
			}
			
			System.out.println(sum);
			
			T--;
		}
	}
	
	public static class node implements Comparable<node> {
		int inter;
		int paper;
		node (int inter,int paper){
			this.inter = inter;
			this.paper = paper;
		}
		@Override
		public int compareTo(node o) {
			if ( this.inter > o.inter ) {
				return 1;
			}
			return -1;
		}
	}
}
