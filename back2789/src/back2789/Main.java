package back2789;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char input[] = in.nextLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < input.length ; i++) {
			// CAMBRIDGE
			if ( input[i] == 'C' || input[i] == 'A' || input[i] == 'M' || input[i] == 'B' || input[i] == 'R' ||
					input[i] == 'I' || input[i] == 'D' || input[i] == 'G' || input[i] == 'E' ) {
				continue;
			}
			sb.append(input[i]);
		}
		System.out.print(sb);
	}
}
