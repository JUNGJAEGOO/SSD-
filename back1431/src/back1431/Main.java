package back1431;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		ArrayList<node> list = new ArrayList<>();
		for (int i = 0 ; i < N ; i++) {
			list.add(new node(in.nextLine()));
		}
		
		Collections.sort(list);
		for (int i = 0; i <list.size() ; i++) {
			System.out.println(list.get(i).origin);
		}
	}
	
	public static class node implements Comparable<node>{
		String origin;
		char[] two;
		int sum = 0;
		node (String origin){
			this.origin = origin;
			this.two = origin.toCharArray();
			for (int i = 0 ; i < two.length ; i++) {
				if ( two[i] == '1' || two[i] == '2'|| two[i] == '3'|| two[i] == '4'|| two[i] == '5'|| two[i] == '6'
						|| two[i] == '7'|| two[i] == '8'|| two[i] == '9') {
					this.sum += Integer.parseInt(String.valueOf(two[i])); 
				}
			}
			
		}
		@Override
		public int compareTo(node o) {
			if ( this.origin.length() > o.origin.length()) {
				return 1;
			}else if( this.origin.length() == o.origin.length()) {
				if ( this.sum > o.sum ) {
					return 1;
				}else if ( this.sum == o.sum) {
					if ( this.origin.compareTo(o.origin) > 0) {
						return 1;
					}else {
						return -1;
					}
				}
				else {
					return -1;
				}
				
			}else {
				return -1;
			}
		}
	}
}
