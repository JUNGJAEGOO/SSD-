package back2858;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int R = in.nextInt();
		int B = in.nextInt();
	
		lop:
		for (int i = 3 ; i <= 2000 ; i++) {
			for ( int j  = 3 ; j<= 2000 ; j++) {
				
				int red = R;
				int black = B;
				boolean pass = false;
			
				for (int k = 0 ; k < i ; k++) {
					if ( k == 0) {
						red -= j; 
						if ( red < 0 ) {
							break;
						}
					}
					else if ( k == i-1) {
						red -= j;
						if ( red < 0 ) {
							break;
						}
					}else {
						red -= 2;
						black -= (j-2);
						if ( red < 0 || black < 0) {
							break;	
						}
					}
				}
				
				//System.out.println(red+" "+black+" , "+i+" "+j+" "+pass);
				if ( red == 0 && black == 0 ) {
					pass = true;
				}
				
				if ( pass ) {
					if ( i >= j) {
						System.out.println(i+" "+j);
					}else {
						System.out.println(j+" "+i);
					}
					
					return;
				}
			}
		}
	}
}
