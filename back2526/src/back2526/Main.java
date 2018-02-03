package back2526;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int P = in.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		int start = N;
		int cnt = 0;
		ArrayList<Integer> cycle = new ArrayList<>();
		while ( true) {
			start = (start*N)%P; 
			//System.out.println(start);
			
			if ( list.contains(start) ) {
				if ( cycle.contains(start) ) {
					break;
				}
				cycle.add(start);
			}
			list.add(start);
		}
		System.out.println(cycle.size());
	}
}
