package back2817;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int N = Integer.parseInt(in.nextLine());
		
		int M = Integer.parseInt(in.nextLine());
		if ( M == 0) {
			return;
		}

		
		HashMap<Double,Character> hm = new HashMap<>();
		int names[] = new int[26];
		ArrayList<Double> points = new ArrayList<>();
		for ( int i = 0 ; i < M ; i++) {
			String info[] = in.nextLine().split(" ");
			char name = info[0].charAt(0);
			int pyo = Integer.parseInt(info[1]);
			if ( (double)pyo  < (double)N * 0.05) {
				continue;
			}
			for ( int j = 1 ; j <= 14 ; j++) {
				points.add((double)pyo/(double)j);
				hm.put((double)pyo/(double)j,name);
			}
			
		}
		
		Collections.sort(points);
		if ( points.size() == 0) {
			return;
		}
		//System.out.println(points);
		for ( int i = points.size()-1 ; i >= points.size()-14 ; i--) {
			char name = hm.get(points.get(i));
			names[name-'A']++;
		}
		
		for ( int i = 0 ; i < names.length ; i++) {
			if ( names[i] > 0) {
				System.out.println((char)(i+'A')+" "+names[i]);
			}
		}
		
	}
	

}
