package back11098;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while ( T > 0) {
			
			int p = Integer.parseInt(in.nextLine());
			long maxcost = 0;
			String maxname = "";
			for ( int i = 0 ; i < p  ; i++) {
				String info[] = in.nextLine().split(" ");
				long cost = Long.parseLong(info[0]);
				String name = info[1];
				if ( cost > maxcost) {
					maxcost = cost;
					maxname = name;
				}
			}
			
			System.out.println(maxname);

			T--;
		}
	}
}
