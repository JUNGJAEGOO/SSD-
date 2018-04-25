package back11650;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		ArrayList<node> List = new ArrayList<>();
		for ( int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			List.add(new node(x,y));
		}
		Collections.sort(List);
		
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < List.size() ; i++) {
			sb.append(List.get(i).x+" "+List.get(i).y+"\n");
		}
		System.out.print(sb);
	}
	
	public static class node implements Comparable<node>{
		int x,y;
		node (int x,int y){
			this.x = x;
			this.y = y;
			
		}
		@Override
		public int compareTo(node o) {
			if (this.x > o.x ) {
				return 1;
			}else if ( this.x == o.x) {
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
