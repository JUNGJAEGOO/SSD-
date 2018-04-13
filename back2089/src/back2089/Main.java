package back2089;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String str = "";
		if ( N == 0) {
			System.out.println(0);
			return;
		}
		
		while ( N != 1) {
			
			str += Math.abs((N%(-2)));
			N = (int) Math.ceil( (double)N / (-2));
		}
		str += N;
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		sb = sb.reverse();
		
		System.out.println(sb);
	}
}
