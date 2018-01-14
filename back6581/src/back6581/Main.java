package back6581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	static int cnt;
    static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException {
		//Scanner in = new Scanner(System.in);
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String res = "";
		cnt = 0;
		
		String input;
		while  ( (input=br.readLine()) != null ) {
		filtering(input);
		}
	
		System.out.print(sb);
	}
	public static void filtering(String res) {
	String arr[] = res.split(" |	");  // ≈« ¡÷¿« !
									
	for ( int i = 0 ; i < arr.length ; i++) {
		
		String word = arr[i];
		int wordlength = word.length();
		if ( word.equals("<hr>")) {
			if ( cnt != 0) {
				cnt = 0;
				sb.append("\n");
			}
			sb.append("--------------------------------------------------------------------------------\n");
			
		}
		else if ( word.equals("<br>")) {
			sb.append("\n");
			cnt = 0;
		}else if ( word.equals(""));
		else {
			if ( cnt + wordlength <= 80) {
				cnt += wordlength;
			}else {
				cnt = wordlength;
				sb.append("\n");
			}
			sb.append(word);
			Space();
		}
	}
	}
	public static void Space() {
		if ( cnt < 80) {
			sb.append(" ");
			cnt++;
		}
	}
}
