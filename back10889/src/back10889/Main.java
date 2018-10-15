package back10889;
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		while ( true ) {
			
			String str = in.nextLine();
			
			char[] c = str.toCharArray();
			char[] ans = new char[c.length];
			
			for ( int i = 0 ; i < c.length ; i++) {
				if ( (c[i] >= 'a' && c[i] <= 'z') || c[i] == '*' || c[i] == '{' || c[i] == '}') {
					ans[i] = c[i];
				}
				else {
					ans[i] = ' ';
				}
			}
			
			
			System.out.println(ans);
		}
		
	}
}
