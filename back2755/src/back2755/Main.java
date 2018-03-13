package back2755;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		
		double sum = 0;
		double boonmo = 0;
		
		for ( int i = 0 ; i < T; i++) {
			
			String input[] = in.nextLine().split(" ");
			double hakjum = Integer.parseInt(input[1]);
			boonmo += hakjum;
			String grade = input[2];
			
			if ( grade.equals("A+") ) {
				hakjum *= 4.3;
			}else if ( grade.equals("A0")) {
				hakjum *= 4.0;
			}else if ( grade.equals("A-")) {
				hakjum *= 3.7;
			}else if ( grade.equals("B+")) {
				hakjum *= 3.3;
			}else if ( grade.equals("B0")) {
				hakjum *= 3.0;
			}else if ( grade.equals("B-")) {
				hakjum *= 2.7;
			}else if ( grade.equals("C+")) {
				hakjum *= 2.3;
			}else if ( grade.equals("C0")) {
				hakjum *= 2.0;
			}else if ( grade.equals("C-")) {
				hakjum *= 1.7;
			}else if ( grade.equals("D+")) {
				hakjum *= 1.3;
			}else if ( grade.equals("D0")) {
				hakjum *= 1.0;
			}else if ( grade.equals("D-")) {
				hakjum *= 0.7;
			}else if ( grade.equals("F")) {
				hakjum *= 0;
			}
			
			//System.out.println(hakjum);
			sum += hakjum;
			
			
		}
		
		System.out.format("%.2f",sum/boonmo);
	}
}
