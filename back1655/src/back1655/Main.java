package back1655;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		for ( int i = 0 ; i < N ; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if ( i == 0 ) {
				list.add(x);
				System.out.println(list.get(0));
				continue;
			}
			if ( i == 1) {
				if ( x > list.get(0) ) {
					list.add(x);
					
				}else {
					list.add(0,x);
				}
				System.out.println(list.get(0));
				continue;
			}
			if ( x > list.get(list.size()-1)) {
				list.add(x);
				System.out.println(list.get((list.size()-1)/2));
				continue;
			}
			
			int left = 0;
			int right = list.size()-1;
			//System.out.println(left+" "+right);
			int ans = 0;
			while ( left <= right ) {
				int mid = (left+right)/2;
				
				if ( list.get(mid) >= x) {
					right = mid - 1;
					ans = mid;
				}else {
					left = mid  + 1;
				}
			}
			//System.out.println(ans);
			list.add(ans, x);
			System.out.println(list);
			System.out.println(list.get((list.size()-1)/2));
		}
	}
}
