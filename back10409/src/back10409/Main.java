package back10409;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int T = in.nextInt();
		int sum = 0 ;
		int cnt = 0;
		for (int i = 0 ; i < n ; i++) {
			int x = in.nextInt();
			if ( sum + x <= T) {
				sum += x;
				cnt++;
			}else {
				break;
			}
		}
		System.out.print(cnt);
	}
}
