package back5218;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while ( T > 0 ) {
			
			String input[] = in.nextLine().split(" ");
			char origin[] = input[0].toCharArray();
			char other[] = input[1].toCharArray();
			
			int res[] = new int[origin.length];
			for (int i = 0 ; i < origin.length ; i++) {
				
				int tmp = (other[i]-'A') - (origin[i]-'A');
				if ( tmp < 0) {
					tmp += 26;
				}
				res[i] = tmp;
				
				
			}
			
			System.out.print("Distances: ");
			for (int i = 0 ; i < res.length ; i++) {
				System.out.print(res[i]+" ");
			}
			System.out.println();
			
			
			
			T--;
		}
	}
}
