package back11365;
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while ( true ) {
			
			String X = in.nextLine();
			if ( X.equals("END")) {
				break;
			}
			
			char[] origin = X.toCharArray();
			char[] NEW = new char[origin.length];
			for ( int i = 0 ; i < origin.length ; i++) {
				NEW[i] = origin[origin.length-1-i];
			}
			
			sb.append(String.valueOf(NEW)+"\n");
		}
		
		
		System.out.print(sb);
		
	}
}