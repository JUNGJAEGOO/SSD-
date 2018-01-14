package back1339;

import java.util.*;

public class Main {
	
	static int realmax = 0;
	public static char hi[][];
	public static int alpha[];
	static ArrayList<Character> words = new ArrayList<>();
	static ArrayList<Character> tmp = new ArrayList<>();
	static int N;
	static int size;
	
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		N = Integer.parseInt(in.nextLine());
		hi = new char[N][];
		for ( int i = 0 ; i < N ; i++) {
			hi[i] = in.nextLine().toCharArray();
			for ( int j = 0 ; j < hi[i].length ; j++) {
				if ( !words.contains(hi[i][j]) ) {
					words.add(hi[i][j]);
				}
			}
		}
		
		size = words.size();
		double a = System.currentTimeMillis();
		
		alpha = new int[27];
		for ( int i = 0 ; i < N ; i++) {
			
			for (int j = 0 ; j < hi[i].length ; j++) {
				//System.out.println(hi[i][j]+" "+Math.pow(10, hi[i].length-j-1));
				alpha[hi[i][j]-'A'] += Math.pow(10, hi[i].length-j-1);
			}
			
		}
		
		Arrays.sort(alpha);
		
		int max = 9;
		int ans = 0;
		for ( int i = 26 ; i >= 0; i--) {
			ans += max * alpha[i];
			max--;
		}
		
		
		double b = System.currentTimeMillis();
		
		System.out.println(ans);
		System.out.println(b-a);
		
	}
	

}
