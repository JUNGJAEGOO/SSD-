package back2712;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testcase = Integer.parseInt(in.nextLine().trim());
		for ( int i = 0 ; i < testcase ; i++) {
			
			String str[] = in.nextLine().split(" ");
			
			
			double origin = Double.parseDouble(str[0]);
			
			if ( str[1].equals("kg")) {
				System.out.format("%.4f lb\n", (double)origin * 2.2046 );
			}else if ( str[1].equals("l")) {
				System.out.format("%.4f g\n", (double)origin * 0.2642 );
			}else if ( str[1].equals("lb")) {
				System.out.format("%.4f kg\n", (double)origin * 0.4536 );
			}else if ( str[1].equals("g")) {
				System.out.format("%.4f l\n", (double)origin * 3.7854 );
			}
			
			
		}
	}
}
