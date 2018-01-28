package back2920;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int asc = 0;
		int desc = 0;
		int before = -1;
		for (int i = 0 ; i < 8 ; i++) {
			int x = in.nextInt();
			if ( i == 0 ) {
				before = x;
				continue;
			}
			if ( x < before ) {
				desc = 1;
			}else if ( x > before) {
				asc = 1;
			}
			before = x;
		}
		
		if ( asc == 1 && desc == 1) {
			System.out.println("mixed");
		}else if ( asc == 1 && desc == 0) {
			System.out.println("ascending");
		}else if ( desc == 1 && asc == 0) {
			System.out.println("descending");
		}
	}
}
