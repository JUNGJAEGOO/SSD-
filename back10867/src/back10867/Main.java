package back10867;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0 ; i < N ; i++) {
			hs.add(in.nextInt());
		}
		Object[] res = hs.toArray();
		Arrays.sort(res);
		for (int i = 0 ; i < res.length ; i++) {
			System.out.print(res[i]+" ");
		}
	}
}
