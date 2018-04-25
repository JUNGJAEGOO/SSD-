package back4999;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		char[] jae = in.nextLine().toCharArray();
		char[] doctor = in.nextLine().toCharArray();
		
		int a = 0;
		int b = 0;
		
		for ( int i = 0 ; i < jae.length ; i++) {
			if (jae[i] == 'h') {
				break;
			}else {
				a++;
			}
		}
		
		for ( int i = 0 ; i < doctor.length ; i++) {
			if (doctor[i] == 'h') {
				break;
			}else {
				b++;
			}
		}
		
		if ( a >= b) {
			System.out.print("go");
		}else {
			System.out.print("no");
		}
	}
}
