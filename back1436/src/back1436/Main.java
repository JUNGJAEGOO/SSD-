package back1436;

import java.util.*;

public class Main {
	static ArrayList<Long> dp = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		int cnt = 0;
		for ( int i = 666 ; ; i++) {
			
			if ( String.valueOf(i).contains("666") ) {
				cnt++;
				if ( cnt == N ) {
					System.out.print(i);
					break;
				}
			}
			
		}
	}
	
	

}
