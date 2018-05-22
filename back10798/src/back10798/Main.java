package back10798;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		ArrayList<Character> list[] = new ArrayList[20];
		for ( int i = 0 ; i < 20 ; i++) {
			list[i] = new ArrayList<>();
		}
		
		int cnt = 0;
		int max = 0;
		while ( in.hasNext()) {
			
			String x = in.nextLine();
			if ( x.equals("break")) {
				break;
			}
			
			char[] go = x.toCharArray();
			
			for ( int i = 0 ; i < go.length ; i++) {
				list[cnt].add(go[i]);
			}
			//System.out.println(list[cnt]);
			max = Math.max(list[cnt].size(), max);
			cnt++;
			
		}
		
		int gogo = 0;
		
		//System.out.println(max);
		cnt = 0 ;
		while ( true ) {
			
			if ( gogo < list[cnt].size() ) {
				System.out.print(list[cnt].get(gogo));
			}
			
			//System.out.println(cnt+" "+gogo);
			cnt++;
			
			if ( cnt >= 20) {
				cnt = 0;
				gogo++;
				if ( gogo > max) {
					break;
				}
			}
		}
		
		
	}
}
