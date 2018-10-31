package back10840;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char one[] = br.readLine().toCharArray();
		char two[] = br.readLine().toCharArray();
		
		HashMap<Long,Integer> dp1 = new HashMap<>();
		ArrayList<Long> dp2 = new ArrayList<>();
		
		long t[] = new long[26];
		t[0] = 1;
		for ( int i = 1 ; i < 26 ; i++) {
			t[i] = t[i-1] * 1501;
		}
		
		for ( int start = 0 ; start < one.length ; start++) {
			for ( int end = start+1 ; end < one.length ; end++) {
				long sum = 0;
				for ( int k = start ; k <= end ; k++) {
					sum += t[(int)(one[k]-'a')];
				}
				//System.out.println(sum+" "+(end-start+1));
				dp1.put(sum,end-start+1);
			}
		}
		
		for ( int start = 0 ; start < two.length ; start++) {
			for ( int end = start+1 ; end < two.length ; end++) {
				long sum = 0;
				for ( int k = start ; k <= end ; k++) {
					sum += t[(int)(two[k]-'a')];
				}
				dp2.add(sum);
			}
		}
		
		int max = 0;
		
		for ( int i = dp2.size()-1 ; i >= 0 ; i-- ) {
			
			//System.out.println(dp1.get(dp2.get(i)));
			if ( dp1.get(dp2.get(i)) != null ) {
				max = Math.max(max, dp1.get(dp2.get(i)));
			}
			
		}
		
		System.out.print(max);
	}
}
