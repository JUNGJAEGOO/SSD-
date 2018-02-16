package back13411;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		ArrayList<node> list = new ArrayList<>();
		for (int i = 0 ; i < N ; i++) {
			
			double x = in.nextDouble();
			double y = in.nextDouble();
			double v = in.nextDouble();
			
			list.add(new node(i,x,y,v));
			
		}
		Collections.sort(list);
		for (int i = 0 ; i < N ; i++) {
			System.out.println(list.get(i).idx+1);
		}
	}
	
	public static class node implements Comparable<node>{
		int idx;
		double x;
		double y;
		double v;
		double stan;
		
		@Override
		public int compareTo(node o) {
			if ( this.stan > o.stan) {
				return 1;
			}else if ( this.stan == o.stan) {
				if ( this.idx > o.idx) {
					return 1;
				}else {
					return -1;
				}
			}
			return -1;
		}
		
		node (int idx,double x,double y,double v){
			this.idx = idx;
			this.x = x;
			this.y =y;
			this.v = v;
			stan = Math.sqrt(( x*x + y*y ))/ v;
		}
		
	}
}
