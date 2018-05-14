package back11609;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		ArrayList<node> name = new ArrayList<>();
		for ( int i = 0 ; i < N ; i++) {
			String info[] = in.nextLine().split(" ");
			name.add(new node(info[0],info[1]));
		}
		
		Collections.sort(name);
		
		for ( int i = 0 ; i < N ; i++) {
			System.out.println(name.get(i).First+" "+name.get(i).Last);
		}
				
	}
	
	public static class node implements Comparable<node>{
		String First;
		String Last;
		node ( String First,String Last){
			this.First = First;
			this.Last = Last;
		}
		@Override
		public int compareTo(node o) {
			if ( this.Last.compareTo(o.Last) > 0) {
				return 1;
			}
			else if ( this.Last.compareTo(o.Last) == 0) {
				if ( this.First.compareTo(o.First) > 0) {
					return 1;
				}else {
					return -1;
				}
			}
			return -1;
		}
	}
}
