package back8949;

import java.util.*;

public class Main {
	public static void main( String args[] ){
		Scanner in = new Scanner(System.in);
		
		String input[] = in.nextLine().split(" ");
		int len = Math.max(input[0].length(), input[1].length() );
		
		char a[] = new char[len];
		char b[] = new char[len];
		int s = input[0].length()-1;
		int t = input[1].length()-1;
		
		for (int i = len-1 ; i >= 0 ; i--) {
			a[i] = input[0].charAt(s);
			s--;
			if ( s < 0) {
				break;
			}
		}
		for (int i = len-1 ; i >= 0 ; i--) {
			b[i] = input[1].charAt(t);
			t--;
			if ( t < 0) {
				break;
			}
		}
		
		
		
		ArrayList<Integer> res = new ArrayList<>();
		
		for ( int i = 0 ; i < len ; i++) {
			int aa = 0;
			int bb = 0;
			
			try {
				aa = Integer.parseInt(String.valueOf(a[i]));
				
			}catch ( Exception e) {
				
			}
			try {
				bb = Integer.parseInt(String.valueOf(b[i]));
				
			}catch ( Exception e) {
				
			}
			res.add(( aa + bb ));
		}
				
		for ( int i = 0 ; i < len ; i++) {
			System.out.print(res.get(i));
		}
	}
}
