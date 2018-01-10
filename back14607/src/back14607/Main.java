package back14607;

import java.util.Scanner;

public class Main {
	public static void main(String arg[]) {
		Scanner in = new Scanner( System.in);
		long N = in.nextLong();
		long sum = (N * ( N - 1 )) / 2;
		System.out.println(sum);
	}
}
