package back2941;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] input = in.nextLine().toCharArray();
		char[][] bigyo = new char[8][3];
		bigyo[0][0] = 'c';
		bigyo[0][1] = '=';
		bigyo[1][0] = 'c';
		bigyo[1][1] = '-';
		bigyo[2][0] = 'd';
		bigyo[2][1] = 'z';
		bigyo[2][2] = '=';
		bigyo[3][0] = 'd';
		bigyo[3][1] = '-';
		bigyo[4][0] = 'l';
		bigyo[4][1] = 'j';
		bigyo[5][0] = 'n';
		bigyo[5][1] = 'j';
		bigyo[6][0] = 's';
		bigyo[6][1] = '=';
		bigyo[7][0] = 'z';
		bigyo[7][1] = '=';
	
		int ans = 0;
		int k  = 0;
		for ( int i = 0 ; i < input.length ; i++ ) {
			boolean p = false;
			for ( int j  = 0 ; j < 8 ; j++) {
				if ( input[i] == bigyo[j][0] ) {
					if ( i+1 < input.length && input[i+1] == bigyo[j][1]) {
						if ( j == 2) {
							if ( i+2 < input.length && input[i+2] == bigyo[j][2]) {
								ans++;
								i+=2;
								p = true;
							}
						}else {
							ans++;
							i++;
							p = true;
						}
					}
				}
			}
			if ( !p ) {
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}
}
