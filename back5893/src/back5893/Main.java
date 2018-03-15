package back5893;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] N = in.nextLine().toCharArray();
		char a[] = new char[2001];
		
		int start = 2000;
		for ( int i = N.length-1 ; i >= 0 ; i--) {
			a[start] = N[i];
			start--;
		}
		
		char[] plus = {1,0,0,0,1};
		
		for (int i = a.length-1 ; i >= 0 ; i--) {
			
			if ( a[i] == '0') {
				continue;
			}
			
			int nam = 0;
			for ( int j = i ; j < 5 ; j++) {
				if ( a[j] == '1' && nam == 0) {
					
				}else if ( a[j] == '1' && nam == 1) {
					
				}else if ( a[j] == '0' && nam == 0) {
					
				}else if ( a[j] == '0' && nam == 1) {
					
				}
			}
		}
		
	}
}
