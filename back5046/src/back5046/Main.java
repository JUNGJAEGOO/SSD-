package back5046;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int B = in.nextInt();
		int H = in.nextInt();
		int W = in.nextInt();
		
		int h[] = new int[H];
		ArrayList<Integer> capa[];
		capa = new ArrayList[H];
		for(int i = 0 ; i < H ; i++) {
			capa[i] = new ArrayList<>();
		}
		for (int i = 0 ; i < H ; i++) {
			h[i] = in.nextInt();
			for (int j = 0 ; j < W ; j++) {
				capa[i].add(in.nextInt());
			}
		}
		
		int ans = 1000000000;
		
		for (int i = 0 ; i < H ; i++) {
			for (int j = 0 ; j < W; j++) {
				if ( capa[i].get(j) < N) {
					continue;
				}
				ans = Math.min(ans, N*h[i]);
			}
		}
		
		if ( ans == 1000000000 || ans > B) {
			System.out.println("stay home");
		}else {
			System.out.println(ans);
		}
	}
}
