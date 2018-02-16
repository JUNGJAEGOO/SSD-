package back11285;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char start = in.nextLine().charAt(0);
		char middle = in.nextLine().charAt(0);
		String endend = in.nextLine();
		char end = ' ';
		try {
			end = endend.charAt(0);
		}
		catch ( Exception e) {
			
		}
		
		char chos[] = {'ぁ', 'あ', 'い', 'ぇ', 'え', 'ぉ', 'け','げ','こ', 'さ', 'ざ', 'し', 
				'じ', 'す', 'ず', 'せ', 'ぜ', 'そ', 'ぞ'};
		char joongs[] = {'た', 'だ', 'ち', 'ぢ', 'っ', 'つ', 'づ','て', 
				'で', 'と', 'ど', 'な', 'に', 'ぬ', 'ね', 'の', 'は', 'ば','ぱ', 'ひ', 'び'};
		char jongs[] = {' ','ぁ', 'あ', 'ぃ', 'い', 'ぅ', 'う', 'ぇ', 'ぉ', 'お',
				'か', 'が', 'き', 'ぎ', 'く', 'ぐ', 'け', 'げ', 'ご', 'さ', 'ざ', 'し', 'じ', 'ず',
				'せ', 'ぜ', 'そ', 'ぞ'};
		
		int cho=0,joong=0,jong=0;
		for (int i = 0 ; i < chos.length ; i++) {
			if ( start == chos[i]) {
				cho = i;
				break;
			}
		}
		for (int i = 0 ; i < joongs.length ; i++) {
			if ( middle == joongs[i]) {
				joong = i;
				break;
			}
		}for (int i = 0 ; i < jongs.length ; i++) {
			if ( end == jongs[i]) {
				jong = i;
				break;
			}
		}
		
		int x = (cho*21*28 + joong*28 + jong) + 0xAC00;
		System.out.println((char)x);
	}
}
