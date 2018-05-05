package back1527;

import java.util.*;

public class Main {
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		
		make(0,"");
		
		Collections.sort(list);
		
		int sum = 0;
		for ( int i = 0 ; i < list.size() ; i++) {
			if ( list.get(i) >= A && list.get(i) <= B) {
				sum++;
			}
		}
		
		System.out.print(sum);
	}
	
	public static void make(int len,String now) {
		
		if ( !now.equals("")) {
			if ( Long.parseLong(now) <= 1000000000 ) {
				list.add(Integer.parseInt(now));
			}
		}
		
		if( len == 10) {
			return;
		}
		
		make(len+1,now+"4");
		make(len+1,now+"7");
		
		
	}
}
