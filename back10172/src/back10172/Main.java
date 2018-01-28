	package back10172;
	
	import java.util.*;
	
	public class Main {
	public static void main(String args[]) {
		ArrayList<Character> list = new ArrayList<>();
		list.add('|');
		list.add('\\');
		list.add('_');
		list.add('/');
		list.add('|');
		for (int i = 0 ; i < list.size() ; i++) {
			System.out.print(list.get(i));
		}
		System.out.println("\n|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
	}
	}
