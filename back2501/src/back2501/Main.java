package back2501;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		int cnt = 1;
		while ( true ) {
			
			//System.out.println(cnt);
			if ( N % cnt == 0) {
				if ( !list.contains(cnt)) {
					list.add(cnt);
				}
			}
			cnt++;
			if ( cnt > N) {
				break;
			}
			
		}
		
		if ( K > list.size() ) {
			System.out.println(0);
			return;
		}
		System.out.print(list.get(K-1));
	}
}
