package back2870;

import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		ArrayList<BigInteger> list = new ArrayList<>();
		for ( int i = 0 ; i < N ; i++) {
			char[] input = in.nextLine().toCharArray();
			for ( int j = 0 ; j < input.length ; j++) {
				if ( input[j] >= 'a' && input[j] <= 'z') {
					input[j] = '.';
				}
			}
			String tmp = "";
			for ( int j = 0 ; j < input.length ; j++) {
				tmp += input[j];
			}
			String arr[] = tmp.split("\\.");
			for ( int j = 0 ; j < arr.length ; j++) {
				//System.out.print(arr[j]+" ");
				if ( !arr[j].equals("") ) {
					list.add(new BigInteger(arr[j]));
				}
			}
			//System.out.println();
		}
		Collections.sort(list);
		for ( int i = 0 ; i <list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
	}
}
