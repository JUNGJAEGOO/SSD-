package back12787;

import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		for ( int test = 0 ; test < T ; test++) {
			
			String info[] = in.nextLine().split(" ");
			int M = Integer.parseInt(info[0]);
			
			if ( M == 1) {
				String N[] = info[1].split("\\.");
				//System.out.println(N[0]);
				String now = "";
				for( int i = 0 ; i < N.length ; i++) {
					String tmp = Long.toBinaryString(Long.parseLong(N[i]));
					while ( tmp.length() < 8 ) {
						tmp = "0"+ tmp;
					}
					//System.out.println(tmp);
					
					now += tmp;
				}
				
				//System.out.println(now);
				BigInteger NOW = BigInteger.ZERO;
				char[] go = now.toCharArray();
				int cnt = go.length-1;
				BigInteger gogo = BigInteger.ONE;
				while ( true ) {
					NOW = NOW.add(gogo.multiply(new BigInteger(String.valueOf(go[cnt])) ) );
					//NOW = NOW.add( BigInteger.valueOf(gogo.multiply(Integer.parseInt(String.valueOf(go[cnt]))) ) );
					//System.out.println(gogo*Integer.parseInt(String.valueOf(go[cnt])));
					gogo = gogo.multiply(BigInteger.valueOf( 2));
					cnt--;
					if ( cnt < 0 ) {
						break;
					}
				}
				
				System.out.println(NOW);
				
			}else {
				BigInteger N = new BigInteger(info[1]);
				
				String tmp = "";
				BigInteger nanoom = BigInteger.valueOf(2);
				
				int cnt = 1;
				while(  cnt < 64 ) {
					//System.out.println(N);
					if ( N.compareTo(BigInteger.ZERO) == 0) {
						tmp += "0";
					}
					else if ( N.mod(nanoom).compareTo(BigInteger.ZERO)== 0) {
						tmp += "0";
					}else {
						tmp += "1";
					}
					
					cnt++;
					N = N.divide(nanoom);
				}
				
				tmp += N;
				ArrayList<Character> tmplist = new ArrayList<>();
				for ( int i = 0 ; i < tmp.length() ; i++) {
					tmplist.add(tmp.charAt(i));
				}
				
				Collections.reverse(tmplist);
				
				tmp = "";
				for ( int i = 0 ; i < tmplist.size() ; i++) {
					tmp+=tmplist.get(i);
				}
				
				ArrayList<String> list = new ArrayList<>();
				for ( int i = 0 ; i < 8 ; i++) {
					list.add(tmp.substring(i*8,(i+1)*8));
				}
				
				//System.out.println(list);
				
				ArrayList<Integer> res = new ArrayList<>();
				
				for (int i = 0 ; i < 8 ; i++) {
					
					char gogogo[] = list.get(i).toCharArray();
					int sum = 0;
					int count = gogogo.length-1;
					int nowgo = 1;
					while ( true ) {
						if ( gogogo[count] == '1' ) {
							sum += nowgo;
						}
						nowgo *= 2;
						count--;
						if ( count < 0 ){
							break;
						}
					}
					
					res.add(sum);
					
				}
				
				//System.out.println(res);
				for ( int i = 0 ; i < res.size() ; i++) {
					if ( i != res.size()-1) {
						System.out.print(res.get(i)+".");
					}else {
						System.out.print(res.get(i));
					}
				}System.out.println();
			}
			
			
		}
	}
}
