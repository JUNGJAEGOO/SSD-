package back2028;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for ( int i = 0 ; i < T ; i++) {
			int X = Integer.parseInt(br.readLine());
			String str = String.valueOf(X);
			X *= X;
			int len = String.valueOf(X).length();
			if ( String.valueOf(X).subSequence(len-str.length(), len).equals(str) ) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
