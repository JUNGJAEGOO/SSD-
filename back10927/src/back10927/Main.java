package back10927;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NoSuchAlgorithmException {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		byte data[] = md.digest();
		StringBuffer sb = new StringBuffer();
		for ( int i = 0 ; i < data.length ; i++) {
			sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
		}
		System.out.print(sb.toString());
	}
}
