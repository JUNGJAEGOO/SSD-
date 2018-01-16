package back9996;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		//char pattern[] = in.nextLine().toCharArray();
		String pattern[] = in.nextLine().split("\\*");
		int T = N;

		lop:
		while ( T > 0 ) {
			
			String now = in.nextLine();
			if ( now.length() < pattern[0].length()+pattern[1].length()) {
				System.out.println("NE");
				T--;
				continue;
			}
			String left= now.substring(0,pattern[0].length());
			String right = now.substring(now.length()-pattern[1].length(),now.length());
			//System.out.println(left+" "+right);
			
			if ( left.equals(pattern[0]) && right.equals(pattern[1])) {
				System.out.println("DA");
			}else {
				System.out.println("NE");
			}

			T--;
		}
		
	}
}
