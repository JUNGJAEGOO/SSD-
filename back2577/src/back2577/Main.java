package back2577;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();	
		String res = String.valueOf(A*B*C);
		String output[] = res.split("");
		int num[] = new int[10];
		for (int i = 0 ; i < output.length ; i++) {
			num[Integer.parseInt(output[i])]++;
		}
		for (int i = 0 ; i < 10 ; i++) {
			System.out.println(num[i]);
		}
	}
}
