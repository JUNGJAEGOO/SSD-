package back6378;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		while ( true ) {
			
			String n = in.nextLine();
			if ( n.equals("0")) {
				break;
			}
			
			
			while ( true ) {
				
				String tmp[] = String.valueOf(n).split("");
				if ( tmp.length == 1) {
					System.out.println(tmp[0]);
					break;
				}else {
					
					int x = 0;
					for ( int i = 0 ; i < tmp.length ; i++) {
						x += Integer.parseInt(tmp[i]);
					}
					//System.out.println(x);
					n = String.valueOf(x);
				}
				
			}
			
		}
	}
}
