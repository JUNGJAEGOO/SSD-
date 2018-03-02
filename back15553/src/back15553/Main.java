package back15553;

import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		M--;
		if ( N == 1) {
			System.out.println(1);
			return;
		}
		ArrayList<Integer> term = new ArrayList<>();
		int beforeE = 0;
		long total = 0;
		int start = 0;
		int end = 0;
		for (int i = 0 ; i < N ; i++) {
			int s = in.nextInt();
			int e = s+1;
			if ( i == 0) {
				start = s;
				beforeE = e;
				continue;
			}
			term.add(s - beforeE);
			beforeE = e;
			if ( i == N-1) {
				end = e;
			}
		}
		total = end - start;
		Collections.sort(term);
		System.out.println(term);
		for ( int i = term.size()-1 ; i >= term.size()-M ; i--) {
			total -= term.get(i);
		}
		System.out.print(total);
		
	}
}
