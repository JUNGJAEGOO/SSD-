package back12170;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int cnt = 1;
		
		while ( T > 0 ) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			M = M % 4 ;
			M += 4;
			
			
			
			char[] str = br.readLine().toCharArray();
			char[] copy = new char[M*N];
			
			int x = 0;
			int y = 0;
			while ( true) {
				
				copy[x] = str[y];
				x++;
				if ( x == copy.length) {
					break;
				}
				y = ( y+1) % str.length;
				
			}
			
			
			/*for ( int i = 0 ; i < copy.length ; i++) {
				System.out.print(copy[i]);
			}System.out.println();
			*/
			Stack<String> s = new Stack<>();
			for  (int i = copy.length-1 ; i >= 0 ; i--) {
				s.push(String.valueOf(copy[i]));
			}
			
			boolean oki = false;
			boolean okj = false;
			boolean okk = false;
			
			while ( s.size() > 1 ) {
				
				String now = s.pop();
				if ( now.equals("i") ) {
					oki = true;
					break;
				}else {
					String tmp = s.pop();
					String gogo = pandan(now+tmp);
					s.add(gogo);
				}
				
			}
			
			while ( oki == true && s.size() > 1 ) {
				
				String now = s.pop();
				if ( now.equals("j") ) {
					okj = true;
					break;
				}else {
					String tmp = s.pop();
					String gogo = pandan(now+tmp);
					s.add(gogo);
				}
				
			}
			
			while ( okj == true && s.size() > 1 ) {
				
				String now = s.pop();
				String tmp = s.pop();
				String gogo = pandan(now+tmp);
				s.add(gogo);

			}
			
			if ( s.pop().equals("k") ) {
				okk = true;
			}
			
			String ans = "NO";
			
			if ( okk == true ) {
				ans = "YES";
			}
			
			System.out.println("Case #"+cnt+": "+ans);
			T--;
			cnt++;
		}
	}
	
	public static String pandan(String str) {
		
		String ret = "";
		
		switch ( str ){
		
			case "11": ret = "1"; break;
			case "1i": ret = "i"; break;
			case "1j": ret = "j"; break;
			case "1k": ret = "k"; break;
			
			case "i1": ret = "i"; break;
			case "ii": ret = "-1"; break;
			case "ij": ret ="k"; break;
			case "ik": ret ="-j"; break;
			
			case "j1": ret ="j"; break;
			case "ji": ret ="-k"; break;
			case "jj": ret ="-1"; break;
			case "jk": ret ="i"; break;
			
			case "k1": ret = "k"; break;
			case "ki": ret = "j"; break;
			case "kj": ret = "-i"; break;
			case "kk": ret = "-1"; break;
			
			case "-11": ret = "-1"; break;
			case "-1i": ret = "-i"; break;
			case "-1j": ret = "-j"; break;
			case "-1k": ret = "-k"; break;
			
			case "-i1": ret = "-i"; break;
			case "-ii": ret = "1"; break;
			case "-ij": ret = "-k"; break;
			case "-ik": ret = "j"; break;
			
			case "-j1": ret ="-j"; break;
			case "-ji": ret ="k"; break;
			case "-jj": ret ="1"; break;
			case "-jk": ret ="-i"; break;
			
			case "-k1": ret = "-k"; break;
			case "-ki": ret = "-j"; break;
			case "-kj": ret = "i"; break;
			case "-kk": ret = "1"; break;
			//
			case "1-1": ret = "-1"; break;
			case "1-i": ret = "-i"; break;
			case "1-j": ret = "-j"; break;
			case "1-k": ret = "-k"; break;
			
			case "i-1": ret = "-i"; break;
			case "i-i": ret = "1"; break;
			case "i-j": ret ="-k"; break;
			case "i-k": ret ="j"; break;
			
			case "j-1": ret ="-j"; break;
			case "j-i": ret ="k"; break;
			case "j-j": ret ="1"; break;
			case "j-k": ret ="-i"; break;
			
			case "k-1": ret = "-k"; break;
			case "k-i": ret = "-j"; break;
			case "k-j": ret = "i"; break;
			case "k-k": ret = "1"; break;
			//
			
			case "-1-1": ret = "1"; break;
			case "-1-i": ret = "i"; break;
			case "-1-j": ret = "j"; break;
			case "-1-k": ret = "k"; break;
			
			case "-i-1": ret = "i"; break;
			case "-i-i": ret = "-1"; break;
			case "-i-j": ret = "k"; break;
			case "-i-k": ret = "-j"; break;
			
			case "-j-1": ret ="j"; break;
			case "-j-i": ret ="-k"; break;
			case "-j-j": ret ="-1"; break;
			case "-j-k": ret ="i"; break;
			
			case "-k-1": ret = "k"; break;
			case "-k-i": ret = "j"; break;
			case "-k-j": ret = "-i"; break;
			case "-k-k": ret = "-1"; break;
				
		}
		
		return ret;
	}
}
