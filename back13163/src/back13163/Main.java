package back13163;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		
		
		StringBuilder sb = new StringBuilder();
		while ( T > 0) {
			
			String str[] = in.nextLine().split(" ");
			
			str[0] = "god";
			
			String tmp = "";
			for ( int i = 0 ; i < str.length ; i++) {
				tmp += str[i];
			}
			
			sb.append(tmp+"\n");
			
			T--;
		}
		
		System.out.print(sb);
	}
}
