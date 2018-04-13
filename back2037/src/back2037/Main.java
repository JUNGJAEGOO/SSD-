package back2037;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		HashMap<Character,Integer> hm = new HashMap<>();
		HashMap<Character,Integer> hm2 = new HashMap<>();
		
		hm.put(' ', 1);
		hm2.put(' ', 1);
		
		hm.put('A', 2);
		hm.put('B', 2);
		hm.put('C', 2);
		hm2.put('A', 1);
		hm2.put('B', 2);
		hm2.put('C', 3);
		
		hm.put('D', 3);
		hm.put('E', 3);
		hm.put('F', 3);
		hm2.put('D', 1);
		hm2.put('E', 2);
		hm2.put('F', 3);

		hm.put('G', 4);
		hm.put('H', 4);
		hm.put('I', 4);
		hm2.put('G', 1);
		hm2.put('H', 2);
		hm2.put('I', 3);
		
		hm.put('J', 5);
		hm.put('K', 5);
		hm.put('L', 5);
		hm2.put('J', 1);
		hm2.put('K', 2);
		hm2.put('L', 3);
		
		hm.put('M', 6);
		hm.put('N', 6);
		hm.put('O', 6);
		hm2.put('M', 1);
		hm2.put('N', 2);
		hm2.put('O', 3);
		
		hm.put('P', 7);
		hm.put('Q', 7);
		hm.put('R', 7);
		hm.put('S', 7);
		hm2.put('P', 1);
		hm2.put('Q', 2);
		hm2.put('R', 3);
		hm2.put('S', 4);
		
		hm.put('T', 8);
		hm.put('U', 8);
		hm.put('V', 8);
		hm2.put('T', 1);
		hm2.put('U', 2);
		hm2.put('V', 3);
		
		hm.put('W', 9);
		hm.put('X', 9);
		hm.put('Y', 9);
		hm.put('Z', 9);
		hm2.put('W', 1);
		hm2.put('X', 2);
		hm2.put('Y', 3);
		hm2.put('Z', 4);
		
		String info[] = in.nextLine().split(" ");
		int p = Integer.parseInt(info[0]);
		int w = Integer.parseInt(info[1]);
		
		char input[] = in.nextLine().toCharArray();
		int sum = 0;
		char before = ' ';
		for ( int i = 0 ; i < input.length; i++) {
			
			char now = input[i];
			//System.out.print(before+" "+now+" "+hm.get(before)+" "+hm.get(now));
			
			if ( before != ' ' &&  hm.get(before) == hm.get(now) ) {
				sum += w + p*(hm2.get(now));
				//System.out.println(" hi"+w+" "+(p*hm2.get(now)));
			}else {
				sum += p*(hm2.get(now));
				//System.out.println(" hi"+p*(hm2.get(now)));
			}
			before = now;
			
		}
		
		System.out.print(sum);
	}
}
