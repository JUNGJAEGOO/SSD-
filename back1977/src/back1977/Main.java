package back1977;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();
		
		ArrayList<Integer> power = new ArrayList<>();
		int x = 1;
		while ( true ) {
			
			power.add(x*x);
			x++;
			if ( x * x > 10000 ) {
				break;
			}
		}
		
		int min = Integer.MAX_VALUE;
		long sum = 0;
		for (int i = 0 ; i < power.size() ; i++) {
			if ( power.get(i) >= M && power.get(i) <= N) {
				sum += power.get(i);
				min = Math.min(min, power.get(i));
			}
		}
		
		if ( sum == 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(sum+"\n"+min);
		
	}
}
