package back13410;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N =	in.nextInt();
		int K = in.nextInt();
		int res[] = new int[K];
		for (int i = 1 ; i <= K ; i++) {
			int tmp = N*i;
			char[] tmpchar = String.valueOf(tmp).toCharArray();
			char[] ans = new char[tmpchar.length];
			for (int j = 0 ; j < tmpchar.length ; j++) {
				ans[j] = tmpchar[tmpchar.length-j-1];
			}
			res[i-1] = Integer.parseInt(String.valueOf(ans));
		}
		Arrays.sort(res);
		System.out.println(res[res.length-1]);
	}
}
