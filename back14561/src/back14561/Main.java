package back14561;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while ( T > 0 ) {
			
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			long a = Long.parseLong(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			ArrayList<Long> res = new ArrayList<>();
			while ( a >= b) {
				res.add(a%b);
				a /= b;
			}
			res.add(a);
			Collections.reverse(res);
			//System.out.println(res);
			
			String str = "";
			for (int i = 0 ; i < res.size() ; i++) {
				str += res.get(i);
			}
			System.out.println(str);
			
			boolean pass = isPalindrome(str.toCharArray());
			if ( pass) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			
			T--;
		}
	}
	
	public static boolean isPalindrome(char[] input) {
		
		int left = 0;
		int right = input.length-1;
		while ( true ) {
			
			if ( left == right) {
				break;
			}
			
			if ( left > right) {
				break;
			}
			
			if ( input[left] == input[right]) {
				left++;
				right--;
			}else {
				return false;
			}
			
		}
		return true;
	}
	
	

}
