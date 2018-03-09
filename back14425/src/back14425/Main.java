package back14425;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		HashMap<String,Integer> hm = new HashMap<>();
		
		for (int i = 0 ; i < N ; i++) {
			hm.put(in.nextLine(), 1);
		}
		
		int ans = 0;
		for (int i = 0 ; i < M ; i++) {
			String inner = in.nextLine();
			if ( hm.get(inner) != null) {
				ans++;
			}
		}
		System.out.print(ans);
		
	}
}
