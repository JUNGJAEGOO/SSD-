package back15721;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int T = in.nextInt();
		int bbun = in.nextInt();
		int cnt = 2;
		int now = 0;
		
		int B = 0;
		int D = 0;
		
		lop:
		while ( true ) {
			
			B++;
			if ( bbun == 0) {
				if ( T == B) {
					break;
				}
			}else {
				if ( T == D) {
					break;
				}
			}
			now = (now + 1) % A;
			
			D++;
			if ( bbun == 0) {
				if ( T == B) {
					break;
				}
			}else {
				if ( T == D) {
					break;
				}
			}
			now = (now + 1) % A;
			
			B++;
			if ( bbun == 0) {
				if ( T == B) {
					break;
				}
			}else {
				if ( T == D) {
					break;
				}
			}
			now = (now + 1) % A;
			
			D++;
			if ( bbun == 0) {
				if ( T == B) {
					break;
				}
			}else {
				if ( T == D) {
					break;
				}
			}
			now = (now + 1) % A;
			
			for ( int i = 0 ; i < cnt ; i++) {
				B++;
				
				if ( bbun == 0) {
					if ( T == B) {
						break lop;
					}
				}else {
					if ( T == D) {
						break lop;
					}
				}
				now = (now+1)%A;
			}
			
			for ( int i = 0 ; i < cnt ; i++) {
				D++;
				
				if ( bbun == 0) {
					if ( T == B) {
						break lop;
					}
				}else {
					if ( T == D) {
						break lop;
					}
				}
				now = (now+1)%A;
			}
			
			//System.out.println(B+" "+D);
			cnt++;
		}
		
		System.out.print(now);
	}
}
