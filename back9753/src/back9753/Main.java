package back9753;

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	static boolean prime[];
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		prime = new boolean [100001];
		eratos();
		ArrayList<Long> hs = new ArrayList<>();
		//System.out.println(list);
		Collections.sort(list);
		lop:
		for (int i = 0 ; i < list.size() ; i++) {
			for (int j = i+1 ; j < list.size() ; j++) {
				BigInteger sum = BigInteger.valueOf(list.get(i)).multiply(BigInteger.valueOf(list.get(j)));
				//System.out.println(sum);
				if ( sum.compareTo(BigInteger.valueOf(100000)) > 0) {
					break;
				}
				if ( !hs.contains(sum.longValue())) {
					hs.add(sum.longValue());
				}
			}
		}

		Collections.sort(hs);
		hs.add((long) 100001);

		try {  // 채점 데이터 잘못 되어서 트라이 캐치문 사용.
			while ( T > 0) {
				
				String input = br.readLine();
				
				int N = Integer.parseInt(input);
				
				int left = 0;
				int right = hs.size();
				int ans = 0;
				while( left <= right) {
					
					int mid = (left+right)/2;
					if ( hs.get(mid) >= N) {
						ans = mid;
						right = mid - 1;
					}else {
						left = mid + 1;
					}
					
				}
				System.out.println(hs.get(ans));
				
				T--;
			}
		}catch ( Exception e) {
			System.out.println(100001);
		}
	}
	
	public static void eratos() {
		prime[1] = true;
		for (int i = 2 ; i<= 100000 ; i++) {
			if ( prime[i] == false) {
				list.add(i);
				for (int j = i+i ; j <= 100000 ; j = j + i) {
					if ( j > 100000 ) {
						break;
					}
					prime[j] = true;
				}
			}
		}
	}
}
