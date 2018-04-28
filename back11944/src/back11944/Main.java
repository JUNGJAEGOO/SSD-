package back11944;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		String sb = new String();
		
		//System.out.println(String.valueOf(N).length()*N);
		for ( int i = 0 ; i < N ; i++) {
			sb += String.valueOf(N);
		}
		
		if ( M <= sb.length() ) {
			System.out.println(sb.substring(0,M));
		}else {
			System.out.println(sb);
		}
		
		
	}
}
