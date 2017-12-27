package back4354;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while ( true) {
		String pattern = br.readLine();
		if ( pattern.equals(".") ) {
			return;
		}
		int fail[] = make(pattern);

		int q = fail[fail.length-1];
		int r = fail.length - q;
		if ( q == 0 || q%r != 0) {
			System.out.println(1);
		}else {
			System.out.println(q/r+1);
		}
		}
	}

	
	public static int[] make(String pattern) {
		char p[] = pattern.toCharArray();
		int fail[] = new int[p.length];
		int j = 0;
		for( int i = 1 ; i < p.length ; i++) {
			while ( j > 0 && p[i] != p[j]) {
				j = fail[j-1];
			}
			if ( p[i] == p[j]) {
				fail[i] = ++j;
			}
		}
		
		
		return fail;
	}
}
