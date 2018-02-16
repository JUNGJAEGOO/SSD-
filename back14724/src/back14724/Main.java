package back14724;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String list[] = new String[9];
		list[0] = "PROBRAIN"; list[1] = "GROW"; list[2] = "ARGOS";
		list[3] = "ADMIN"; list[4] = "ANT"; list[5] = "MOTION";
		list[6] = "SPG"; list[7] ="COMON"; list[8] = "ALMIGHTY";
		HashMap<String,Integer> hm = new HashMap<>();
		for (int i = 0 ; i <  9 ; i++) {
			int max = 0;
			for (int j = 0 ; j < N ; j++) {
				max = Math.max(max, in.nextInt());
			}
			hm.put(list[i],max);
		}
		
		Iterator itr = hm.keySet().iterator();
		int max = hm.get(list[0]);
		String maxer = list[0];
		while ( itr.hasNext()) {
			String key = (String)itr.next();
			if ( hm.get(key) > max) {
				max = hm.get(key);
				maxer = key;
			}
		}
		System.out.println(maxer);
		
	}
}
