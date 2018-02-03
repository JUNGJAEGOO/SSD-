package back1708;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<node> arr = new ArrayList<>();
		for (int i = 0 ; i < N ; i++) {
			arr.add(new node(in.nextInt(),in.nextInt()));
		}

		Collections.sort(arr);
		/*for (int i = 0 ; i < N ; i++) {
			System.out.println(arr.get(i).x+","+arr.get(i).y);
		}*/
		Stack<node> st = new Stack<>();
		st.add(arr.get(0));
		st.add(arr.get(1));
		for (int i = 2 ; i < N ; i++) {
			while ( st.size() >= 2) {
				if ( CCW(st.get(st.size()-2).x,st.get(st.size()-2).y,st.peek().x,st.peek().y,arr.get(i).x,arr.get(i).y) > 0) {
					
					break;
				}else {
					st.pop();
				}
			}
			st.add(arr.get(i));
		}
		
		/*for (int i = 0 ; i < st.size() ; i++) {
			System.out.println(st.get(i).x+","+st.get(i).y);
		}*/
		System.out.println(st.size());
		
	}
	
	public static int CCW(int x1,int y1,int x2,int y2,int x3,int y3) {
		int tmp  = x1*y2 + x2*y3 + x3+y1;
		tmp = tmp - y1*x2 - y2*x3 - y3*x1;
		if ( tmp > 0) {
			return 1;
		}else if (tmp < 0) {
			return -1;
		}else  {
			return 0;
		}
	}
	
	public static class node implements Comparable<node>{
		int x,y;

		node(int x,int y){
			this.x =x;
			this.y =y;
		}
		@Override
		public int compareTo(node o) {
			if ( this.y > o.y) {
				return 1;
			}else if (this.y == o.y){
				if ( this.x > o.x) {
					return 1;
				}else {
					return -1;
				}
			}else {
				return -1;
				
			}
		}
		
	}
}
