package back4836;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static boolean isDip;
	
	public static void main(String[] args) throws Exception {
		//FileReader fr = new FileReader("C:\\Users\\worn1\\Downloads\\problems\\dance\\cases\\test2\\dance.in");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println(fr);
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		String str = "";
		
		while ( (str = br.readLine()) != null ) {
			
			//String str = sc.nextLine();
			isDip = false;
			boolean logic[] = new boolean[5];
			String[] c = str.split(" ");
			logic[0] = true;
			
			ArrayList<Integer> WrongDipIdx = one(c);
			if ( WrongDipIdx.size() > 0 ) {
				logic[0] = false;
			}
			
			logic[1] = two(c);
			logic[2] = three(c);
			logic[3] = four(c);
			logic[4] = five(c);
			
			for ( int i = 0 ; i < WrongDipIdx.size() ; i++) {
				c[WrongDipIdx.get(i)] = c[WrongDipIdx.get(i)].toUpperCase();
			}
			
			str = "";
			for ( int i = 0 ; i < c.length ; i++) {
				str += c[i]+" ";
			}
			
			int wrongCnt = 0;
			ArrayList<Integer> wrongs = new ArrayList();
			
			for ( int i = 0 ; i < 5 ; i++) {
				if ( logic[i] == false ) {
					wrongs.add(i+1);
					wrongCnt++;
				}
			}
			
			
			if ( wrongCnt == 0 ) {
				sb.append("form ok: ");
				sb.append(str+"\n");
			}else if ( wrongCnt == 1) {
				sb.append("form error "+wrongs.get(0)+": ");
				sb.append(str+"\n");
			}else {
				sb.append("from errors ");
				for ( int i = 0 ; i < wrongs.size()-2 ; i++) {
					sb.append(wrongs.get(i)+", ");
				}
				sb.append(wrongs.get(wrongs.size()-2)+" and ");
				sb.append(wrongs.get(wrongs.size()-1)+": ");
				sb.append(str+"\n");
			}
			
			str = "";
		}
		
		System.out.print(sb);
		
	}
	
	public static ArrayList<Integer> one(String[] c) {
		
		ArrayList<Integer> idx = new ArrayList<>();
		for ( int i = 0 ;  i < c.length ; i++) {
			if ( c[i].equals("dip") ) {
				idx.add(i);
			}
		}
		
		ArrayList<Integer> wrongDipIdx = new ArrayList<Integer>();
		
		for ( int i = 0 ; i < idx.size() ; i++) {
			
			int now = idx.get(i);
			
			boolean one = false ,two = false ,three = false;
			if ( now-1 >= 0 && c[now-1].equals("jiggle")) {
				one = true;
			}
			if ( now-2 >= 0 && c[now-2].equals("jiggle")) {
				two = true;
			}
			if ( now+1 < c.length  && c[now+1].equals("twirl")) {
				three = true;
			}
			
			if ( one == false && two == false && three == false) {
				wrongDipIdx.add(now);
			}
		}
		
		return wrongDipIdx;
	}
	
	public static boolean two(String[] str) {
		
		if ( str.length < 3) {
			return false;
		}
		
		if ( str[str.length-3].equals("clap") && str[str.length-2].equals("stomp") && str[str.length-1].equals("clap") ) {
			return true;
		}
		
		return false;
	}
	public static boolean three(String[] str) {
		
		boolean isTwirl = false;
		boolean isHop = false;
		for ( int i = 0 ; i < str.length ; i++) {
			
			if ( str[i].equals("twirl") ) {
				isTwirl = true;
			}
			if ( str[i].equals("dip")) {
				isDip = true;
			}
		}
		
		if ( !isTwirl) {
			return true;
		}
		else {
			for ( int i = 0 ; i < str.length ; i++) {
				if ( str[i].equals("hop") ) {
					return true;
				}
			}
		}
		
		return false;
	}
	public static boolean four(String[] str) {
		
		if ( str[0].equals("jiggle") ) {
			return false;
		}
		return true;
	}
	public static boolean five(String[] str) {
		
		if ( isDip) {
			return true;
		}
		return false;
	}
}
