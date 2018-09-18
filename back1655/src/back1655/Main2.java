package back1655;

import java.util.*;

public class Main2 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for ( int i = 0 ; i < N ; i++) {
			
			int x = in.nextInt();
			
			if ( i == 0 ) {
				list.add(x);
				System.out.println(x);
				continue;
			}
			else if ( i == 1) {
				if ( x >= list.get(0) ) {
					System.out.println(list.get(0));
					list.add(x);
				}else {
					list.add(0,x);
					System.out.println(list.get(0));
				}
				continue;
			}
			
			if ( x >= list.get(list.size()-1)) {
				list.add(x);
				System.out.println(list.get((list.size()-1)/2));
				continue;
			}
			
			int l = 0;
			int r = list.size()-1;
			int ans = 0;
			
			while ( l <= r ) {
				
				int mid = (l+r)/2;
				
				if ( x <= list.get(mid)) {
					
					r = mid-1;
					ans = mid;
				}else {
					l = mid+1;
				}
				
			}
			
			//System.out.println(ans+" ¿¡ »ðÀÔ");
			list.add(ans, x);
			
			//System.out.println(list);
			
			System.out.println(list.get((list.size()-1)/2));
			
		}
		
	}
}
