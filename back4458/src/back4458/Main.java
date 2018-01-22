package back4458;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < N ; i++) {
			String str = in.nextLine();
			String first = String.valueOf(str.charAt(0));
			first = first.toUpperCase();
			first += str.substring(1,str.length());
			sb.append(first+"\n");
		}
		System.out.print(sb);
	}
}
