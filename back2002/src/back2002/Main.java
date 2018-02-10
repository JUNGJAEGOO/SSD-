package back2002;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		Queue<String> inner = new LinkedList<>();
		for (int i = 0 ; i < N ; i++) {
			inner.add(in.nextLine());
		}
		Queue<String> outer = new LinkedList<String>();
		for (int i = 0 ; i < N ; i++) {
			outer.add( in.nextLine() );
		}
		
		int cnt = 0;
		ArrayList<String> end = new ArrayList<>();
		while ( true) {
			
			String tmpin = inner.peek();
			String tmpout = outer.peek();
			if ( tmpin.equals(tmpout) ) {
				inner.poll();
				outer.poll();
			}else if ( !tmpin.equals(tmpout) && end.contains(tmpin) ) {
				inner.poll();
			}
			else {
				end.add(outer.poll());
				cnt++;
			}
			
			if ( outer.isEmpty() ) {
				break;
			}
		}
		
		System.out.println(cnt);
	}
}
