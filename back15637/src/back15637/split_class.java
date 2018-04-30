package back15637;

import java.util.Scanner;

public class split_class {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while ( true ) {
			
			String x = in.nextLine();
			if( x.equals("-1")) {
				break;
			}
		
			sb.append(""+x+",");
		}
		
		System.out.print(sb);
		
	}
}
