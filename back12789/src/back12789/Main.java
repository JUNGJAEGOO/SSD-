package back12789;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Deque<Integer> dq = new LinkedList<>();
		for ( int i = 0 ; i < N ; i++) {
			dq.addLast(in.nextInt());
		}
		
		Stack<Integer> st = new Stack<>();
		
		int want = 1;
		
		while ( true ) {
			
			if ( want == N+1) {
				break;
			}
			
			if ( dq.size() > 0 && dq.getFirst() == want) {
				dq.removeFirst();
				want++;
			}else if ( st.size() > 0 && st.peek() == want){
				
				st.pop();
				want++;
				
			}else {
				if ( dq.size() == 0) {
					break;
				}
				int x = dq.removeFirst();
				st.add(x);
			}

		}
		
		if ( want == N+1) {
			System.out.println("Nice");
		}else {
			System.out.println("Sad");
		}
		
	}
}
