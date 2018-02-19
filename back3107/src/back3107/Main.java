package back3107;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		String input = in.nextLine();
		if ( input.split(":").length == 7) {
			input = input.replace("::", ":0000:0000:");
		}else if ( input.split(":").length == 6) {
			input = input.replace("::", ":0000:0000:0000:");
		}else if ( input.split(":").length == 5) {
			input = input.replace("::", ":0000:0000:0000:0000:");
		}else if ( input.split(":").length == 4) {
			input = input.replace("::", ":0000:0000:0000:0000:0000:");
		}else if ( input.split(":").length == 3) {
			input = input.replace("::", ":0000:0000:0000:0000:0000:0000:");
		}else if ( input.split(":").length == 2) {
			input = input.replace("::", ":0000:0000:0000:0000:0000:0000:0000:");
		}
		
		String ip[] = input.split(":");
		
		for (int i = 0 ; i < ip.length ; i++) {
			if ( ip[i].length() != 4) {
				if ( ip[i].length() == 3) {
					ip[i] = "0" + ip[i];
				}else if ( ip[i].length() == 2) {
					ip[i] = "00" + ip[i];
				}else if ( ip[i].length() == 1) {
					ip[i] = "000" + ip[i];
				}
			}
		}
		
		for (int i = 0 ; i < 8 ; i++) {
			if ( i == 0) {
				System.out.print(ip[i]);
			}else {
				System.out.print(":"+ip[i]);
			}
		}
	}
}
