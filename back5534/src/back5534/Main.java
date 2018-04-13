package back5534;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		//System.out.print(N);
		String NEW = in.nextLine();
		
		int sum = 0;
		for ( int i = 0 ; i < N ; i++) {
			// 0 ~ 25;
			
			String now = in.nextLine();
			//System.out.println(now);
			
			
			lop:
			for (int start = 0 ; start < now.length() ; start++ ) {
					
				for ( int gab = 1 ;  gab < now.length() ; gab++) {
					
					String str = "";
					int cnt = start;
					//System.out.println("cnt is "+cnt);
					while ( true ) {
						
						str += now.charAt(cnt);
						//System.out.println(str);
						if ( str.equals(NEW) ) {
							sum++;
							break lop;
						}
						
						cnt += gab;
						if ( cnt >= now.length() ) {
							break;
						}
						
					}
				}
				
				
			}
			
			
		}
		
		System.out.print(sum);
		
	}
}
