package back3181;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().toUpperCase().split(" ");
		String no[] = {"i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili"};
		for ( int i = 0 ; i < no.length ; i++) {
			no[i] = no[i].toUpperCase();
		}
		ArrayList<Character> ans = new ArrayList<>();
		
		ans.add(input[0].charAt(0));
		for ( int i = 1 ; i < input.length ; i++) {
			boolean pass = true;
			for ( int j = 0 ;  j < no.length; j++) {
				if ( input[i].equals(no[j]) ) {
					pass = false;
					break;
				}
			}
			
			if ( pass) {
				ans.add(input[i].charAt(0));
			}
		}
		
		for ( int i = 0 ; i < ans.size() ; i++) {
			System.out.print(ans.get(i));
		}
	}
}
