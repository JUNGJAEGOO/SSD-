package back10546;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		
		HashMap<String,Integer> hm = new HashMap<>();
		
		for ( int i = 0 ; i < N ; i++) {
			String str = in.nextLine();
			if ( hm.get(str) == null) {
				hm.put(str,1);
			}else {
				hm.put(str, hm.get(str)+1);
			}
		}
		
		for ( int i = 0 ; i < N - 1; i++) {
			String str = in.nextLine();
			hm.replace(str,hm.get(str)-1);
		}
		
		Iterator itr = hm.keySet().iterator();
		while ( itr.hasNext() ) {
			String key = (String)itr.next();
			if ( hm.get(key) > 0) {
				System.out.print(key);
			}
		}
				
		
	}
}
