package back15501;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Deque<Integer> real = new LinkedList<>();
		Deque<Integer> rev = new LinkedList<>();
		ArrayList<Integer> bigyo = new ArrayList<>();
		
		for (int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			real.addLast(x);
			rev.addFirst(x);
		}

		
		for (int i = 0 ; i < N ; i++) {
			bigyo.add(in.nextInt());
		}
		
		int stan = bigyo.get(0);
		Queue<Integer> tmp1 = new LinkedList<>();
		Queue<Integer> tmp2 = new LinkedList<>();
		
		while ( true ) {
				int tmp = real.removeFirst();
				if ( tmp == stan) {
					real.addFirst(tmp);
					break;
				}else {
					tmp1.add(tmp);
				}
		}
		int len = tmp1.size();
		for (int i = 0 ; i < len ; i++) {
			real.addLast(tmp1.poll());
		}
		
		
		boolean pass = true;
		for (int i = 0 ; i < N ; i++) {
			int x = real.removeFirst();
			if ( x != bigyo.get(i) ) {
				pass = false;
				break;
			}
		}
		
		if ( pass) {
			System.out.println("good puzzle");
			return;
		}
		
		
		while ( true ) {
			int tmp = rev.removeFirst();
			if ( tmp == stan) {
				rev.addFirst(tmp);
				break;
			}else {
				tmp2.add(tmp);
			}
		}
		len = tmp2.size();
		for (int i = 0 ; i < len ; i++) {
			rev.addLast(tmp2.poll());
		}
		
		pass = true;
		for (int i = 0 ; i < N ; i++) {
			int x = rev.removeFirst();
			if ( x != bigyo.get(i) ) {
				pass = false;
				break;
			}
		}
		
		if ( pass) {
			System.out.println("good puzzle");
		}else {
			System.out.println("bad puzzle");
		}
		
	}
}
