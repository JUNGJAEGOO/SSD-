package back8892;

import java.util.Scanner;

public class Main {
	static String arr[];
	static char[] target;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while ( T > 0) {
			
			int N = Integer.parseInt(in.nextLine());
			arr = new String[N];
			for (int i = 0 ; i < N ; i++) {
				arr[i] = in.nextLine();
			}
			
			String ans ="";
			boolean pass = false;
			lop:
			for (int i = 0 ; i < N ; i++) {
				for (int j = i+1 ; j < N ; j++) {
					String tmp = arr[i] + arr[j];
					target = tmp.toCharArray();
					if ( func() ) {
						ans = tmp;
						pass = true;
						break lop;
					}
					tmp = arr[j]+arr[i];
					target = tmp.toCharArray();
					if ( func() ) {
						ans = tmp;
						pass = true;
						break lop;
					}
					
				}
			}
			
			if ( pass) {
				System.out.println(ans);
			}else {
				System.out.println(0);
			}
			
			
			
			T--;
		}
	}
	
	public static boolean func() {
		
		int i = 0;
		int j = target.length-1;
		while ( true) {
			if (target[i] == target[j]) {
				i++;
				j--;
			}else {
				return false;
			}
			
			if ( i >= j) {
				break;
			}
		}
		
		
		return true;
	}
}
