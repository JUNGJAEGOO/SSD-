package back5355;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		
		for ( int i = 0 ; i < N ; i++) {
			String info[] = in.nextLine().split(" ");
			
			double A = Double.parseDouble(info[0]);
			ArrayList<String> st = new ArrayList<>();
			st.add(info[0]);
			for ( int j = 1 ; j < info.length ; j++) {
				
				if ( info[j].equals("@") ) {
					st.add("*");
					st.add("3");
				}else if ( info[j].equals("#") ) {
					st.add("-");
					st.add("7");
				}else if ( info[j].equals("%") ) {
					st.add("+");
					st.add("5");
				}
			}
			
			System.out.println(st);
			double sum = 0;
			while ( true) {
				
				String a = st.get(0);
				String com = st.get(1);
				String b  = st.get(2);
				if ( com.equals("+")) {
					sum = ( Double.parseDouble(a)+Double.parseDouble(b) );
					st.remove(0);
					st.remove(0);
					st.remove(0);
					st.add(0,String.valueOf(sum));
				}else if ( com.equals("*") ){
					sum = ( Double.parseDouble(a)*Double.parseDouble(b) );
					st.remove(0);
					st.remove(0);
					st.remove(0);
					st.add(0,String.valueOf(sum));
				}
				else {
					sum = ( Double.parseDouble(a)-Double.parseDouble(b) );
					st.remove(0);
					st.remove(0);
					st.remove(0);
					st.add(0,String.valueOf(sum));
				}
				
				if ( st.size() == 1) {
					break;
				}
				
			}
			
			double res = Double.parseDouble(st.get(0));
			System.out.format("%.2f\n",res);
		}
	}
}
