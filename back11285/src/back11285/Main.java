package back11285;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char start = in.nextLine().charAt(0);
		char middle = in.nextLine().charAt(0);
		String endend = in.nextLine();
		char end = ' ';
		try {
			end = endend.charAt(0);
		}
		catch ( Exception e) {
			
		}
		
		char chos[] = {'��', '��', '��', '��', '��', '��', '��','��','��', '��', '��', '��', 
				'��', '��', '��', '��', '��', '��', '��'};
		char joongs[] = {'��', '��', '��', '��', '��', '��', '��','��', 
				'��', '��', '��', '��', '��', '��', '��', '��', '��', '��','��', '��', '��'};
		char jongs[] = {' ','��', '��', '��', '��', '��', '��', '��', '��', '��',
				'��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��', '��',
				'��', '��', '��', '��'};
		
		int cho=0,joong=0,jong=0;
		for (int i = 0 ; i < chos.length ; i++) {
			if ( start == chos[i]) {
				cho = i;
				break;
			}
		}
		for (int i = 0 ; i < joongs.length ; i++) {
			if ( middle == joongs[i]) {
				joong = i;
				break;
			}
		}for (int i = 0 ; i < jongs.length ; i++) {
			if ( end == jongs[i]) {
				jong = i;
				break;
			}
		}
		
		int x = (cho*21*28 + joong*28 + jong) + 0xAC00;
		System.out.println((char)x);
	}
}
