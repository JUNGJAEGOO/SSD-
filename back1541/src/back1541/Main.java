package back1541;

import java.util.*;

public class Main {
	static int len;
	static int ans = Integer.MAX_VALUE;
	static String str[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		str = in.nextLine().split("-");
		int opr = str.length-1;
		
		for ( int i = 0 ; i < str.length ; i++) {
			
			//System.out.println(str[i]);
			String NEW[] = str[i].split("\\+");
			int N = 0;
			for ( int j = 0 ; j < NEW.length ; j++) {
				N += Integer.parseInt(NEW[j]);
			}
			str[i] = String.valueOf(N);
		}
		
		int sum = Integer.parseInt(str[0]);
		for ( int i = 1 ; i < str.length ; i++) {
			//System.out.print(str[i]+" ");
			sum -= Integer.parseInt(str[i]);
			
		}
		
		len = str.length;
		
		System.out.print(sum);
	}
	
	public static void func(int length,int sum) {
		if ( length+1 == len ) {
			ans = Math.min(ans, sum);
			return;
		}else {
			
			func(length+1,sum+Integer.parseInt(str[length+1]));
			func(length+1,sum-Integer.parseInt(str[length+1]));
		}
	}
}
