package back5724;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		while ( true ) {
			
			int x = in.nextInt();
			if ( x == 0) {
				break;
			}
			
			System.out.println( (int)( ( Math.pow(x, 3)*2 + Math.pow(x, 2)*3 + x ) / 6 ));
			
		}
	}
}
