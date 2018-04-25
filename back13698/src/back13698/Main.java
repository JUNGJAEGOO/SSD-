package back13698;

import java.util.*;

public class Main {
	static int arr[] = new int[4];
	
	public static void main(String args[]) {
		Scanner in = new Scanner ( System.in);
		char order[] = in.nextLine().toCharArray();
		
		arr[0] = 1;
		arr[3] = 2;
		
		for ( int i = 0 ; i < order.length ; i++) {
			
			
			if ( order[i] == 'A') {
				swap(0,1);
			}else if ( order[i] == 'B') {
				swap(0,2);
			}else if ( order[i] == 'C') {
				swap(0,3);
			}else if ( order[i] == 'D') {
				swap(1,2);
			}else if ( order[i] == 'E') {
				swap(1,3);
			}else if ( order[i] == 'F') {
				swap(2,3);
			}
			
			
		}
		
		int oneidx = 0;
		int twoidx = 0;
		for ( int i = 0 ; i < 4 ; i++) {
			if ( arr[i] == 1) {
				oneidx = i;
			}
			if ( arr[i] == 2) {
				twoidx = i;
			}
		}
		oneidx++;
		twoidx++;
		System.out.print(oneidx+"\n"+twoidx);
	}
	
	public static void swap(int fromidx,int toidx) {
		
		int tmp = arr[fromidx];
		arr[fromidx] = arr[toidx];
		arr[toidx] = tmp;
	}
}
