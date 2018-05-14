package back15711;

import java.util.*;

public class Main {
	
	static ArrayList<Long> v = new ArrayList<>();
	
	public static boolean prime(long x) {
		
		for ( int i = 0 ; i < v.size() && v.get(i)*v.get(i) <= x ; i++) {
			if ( x % v.get(i) == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		boolean isPrime[] = new boolean[2000001];
		
		isPrime[0] = true;
		isPrime[1] = true;
		
		for (int i = 2 ; i < 2000001 ; i++) {
			if ( isPrime[i] == false) {
				v.add((long)i);
				for ( int j = i + i ; j < 2000001 ; j = j + i) {
					if ( j > 2000001) {
						break;
					}
					isPrime[j] = true;
				}
			}
		}
		
		for ( int test = 0 ; test < T ; test++) {
			
			long a = in.nextLong();
			long b = in.nextLong();
			
			if ( a+b < 4 ) {
				System.out.println("NO");
				continue;
			}
			if ( (a+b)% 2 == 0) {
				System.out.println("YES");
				continue;
			}
			
			long sum = a+b-2;
			
			if ( prime(sum) == true ) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
	}
}
