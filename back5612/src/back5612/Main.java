package back5612;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int first = in.nextInt();
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0 ; i < first ; i++) {
			dq.addFirst(1);
		}
		int max = dq.size();
		lop:
		for (int i = 0 ; i < N ; i++) {
			
			int enter = in.nextInt();
			int out = in.nextInt();
			for (int j= 0 ; j <  enter ; j++) {
				dq.addFirst(1);
			}
			for (int j = 0 ; j < out ; j++) {
				if ( dq.size() == 0) {
					max = 0;
					break lop;
				}
				dq.removeLast();
			}
			max = Math.max(max, dq.size());
		}
		System.out.print(max);
	}
}
