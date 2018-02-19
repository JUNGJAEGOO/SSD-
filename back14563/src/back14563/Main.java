package back14563;

import java.util.*;

public class Main {
	static ArrayList<Integer> list;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0) {
			
			int x = in.nextInt();
			list = new ArrayList<>();
			
			nanoogi(x);
			int sum = 0;
			for (int i = 0 ; i < list.size() ; i++) {
				sum += list.get(i);
			}
			
			if ( sum == x) {
				System.out.println("Perfect");
			}else if ( sum > x) {
				System.out.println("Abundant");
			}else if ( sum < x) {
				System.out.println("Deficient");
			}
			
			T--;
		}
	}
	
	
	public static void nanoogi(int x) {
		
		
		for ( int i = 1 ; i <= x/2 ; i++) {
			if ( x%i == 0) {
				list.add(i);
			}
		}

	}
}
