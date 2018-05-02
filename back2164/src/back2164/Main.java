package back2164;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Deque<Integer> st = new LinkedList<>();
		
		for ( int i = 1 ; i<= N ; i++) {
			st.addFirst(i);
		}
		
		if ( st.size() == 1) {
			System.out.print(st.peek());
			return;
		}
		
		while ( true ) {
			
			st.removeLast();
			//System.out.println(st);
			if ( st.size() == 1) {
				break;
			}
			
			int tmp = st.removeLast();
			st.addFirst(tmp);
			//System.out.println(st);
			if ( st.size() ==1 ) {
				break;
			}
			
		}
		
		System.out.print(st.peek());
	}
}
