package back2841;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int P = in.nextInt();
		
		Stack<Integer> st[] = new Stack[6];
		for ( int i = 0 ; i < 6 ; i++) {
			st[i] = new Stack<>();
		}
		
		int sum = 0;
		for ( int i = 0 ; i < N ; i++) {
			int string = in.nextInt();
			int pret = in.nextInt();
			
			while ( !st[string-1].empty() && st[string-1].peek() > pret ) {
				st[string-1].pop();
				sum++;
			}
			
			if (st[string-1].size() == 0 || st[string-1].peek() != pret ) {
				st[string-1].add(pret);
				sum++;
			}
			
		}
		System.out.print(sum);
	}
}
