package back1972;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		while ( true ) {
			String input = in.nextLine();
			if ( input.equals("*")) {
				break;
			}
			if ( check(input)) {
				System.out.println(input+" is surprising.");
			}else {
				System.out.println(input+" is NOT surprising.");
			}
			
		}
	}
	
	public static boolean check(String input) {
		char[] tmp = input.toCharArray();
		
		int dist = 1;
		ArrayList<String> list;
		
		while ( true ) {
			list = new ArrayList<>();
			
			for ( int i = 0 ; i < tmp.length ; i++) {
				if ( i + dist >= tmp.length ) {
					break;
				}
				String str = String.valueOf(tmp[i]) + String.valueOf(tmp[i+dist]);
				if ( !list.contains(str)) {
					list.add(str);
				}
			}
			//System.out.println(list.size());
			
			if ( tmp.length - dist != list.size()) {
				return false;
			}
			
			dist++;
			if ( dist >= tmp.length ) {
				break;
			}
			
		}
		
		return true;
	}
}	
