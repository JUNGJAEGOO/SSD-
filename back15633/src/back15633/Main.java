package back15633;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		int sum = 0;
		for (int i = 1 ; i <= N ; i++) {
			if ( N % i == 0) {
				list.add(i);
				sum += i;
			}
		}
		
		System.out.println(sum);
		
	}
}
