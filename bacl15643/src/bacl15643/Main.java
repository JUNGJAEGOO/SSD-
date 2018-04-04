package bacl15643;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(System.in);
		char[] str = in.nextLine().toCharArray();
		
		//System.out.println((char)85630);
		//System.out.println((char)20094);
		//System.out.println((char)31958);
	
		for ( int i = 0 ; i < str.length ; i++) {
			
			System.out.println((int)str[i]);
			
			for ( int j = 0 ; j < 80000 ; j++) {
				
				if ( j == 31958) {
					System.out.println((char)31958);
				}
				if ( (int)str[i] == j) {
					//System.out.println(j);
					continue;
				}
				
				if ( str[i] == ((char)j) ) {
					System.out.println(j);
					System.out.print("Yes");
					return;
				}
			}
			
		}
		
		System.out.println("No");
		
	}
}
