package back2960;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		
		boolean isPrime[] = new boolean[N+1];
		
		int cnt = 1;
		ArrayList<Integer> res = new ArrayList<>();
		
		for ( int i = 2 ; i <= N ; i++) {
			
			
			if ( isPrime[i] == false) {
				
				res.add(i);

				for ( int j = i+i ; j <= N ; j = j + i) {
					if ( j > N) {
						break;
					}

					if ( isPrime[j] == false) {
						res.add(j);
					}
					isPrime[j] = true;
					
				}
			}
		}
		
		System.out.print(res.get(K-1));
	}
}
