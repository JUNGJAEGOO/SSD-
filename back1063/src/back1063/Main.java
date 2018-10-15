package back1063;

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		char[] king = st.nextToken().toCharArray();
		char[] stone = st.nextToken().toCharArray();
		int N = Integer.parseInt(st.nextToken());
		
		int kingX = 8 - (int)(king[1]-'0');
		int kingY = (int)(king[0] - 'A');

		int stoneX = 8 - (int)(stone[1]-'0');
		int stoneY = (int)(stone[0] - 'A');
		
		//System.out.println(kingX+","+kingY+" "+stoneX+","+stoneY);
		
		for ( int i = 0 ; i < N ; i++) {
			
			String com = br.readLine();
			//System.out.println(kingX+","+kingY+" "+stoneX+","+stoneY);
			if ( com.equals("R") ) {
				
				if ( kingY + 1 >= 8) {
					continue;
				}
				if ( kingY + 1 == stoneY ) {
					if ( kingX == stoneX) {
						if ( stoneY + 1 >= 8) {
							continue;
						}
						
						stoneY++;
						kingY++;
						
					}else {
						kingY++;
					}
				}else {
					kingY++;
				}
				
			}else if ( com.equals("L") ) {
				
				if ( kingY - 1 < 0) {
					continue;
				}
				
				if ( kingY - 1 == stoneY ) {
					if ( kingX == stoneX) {
						if ( stoneY - 1 < 0) {
							continue;
						}
						
						stoneY--;
						kingY--;
						
					}else {
						kingY--;
					}
				}else {
					kingY--;
				}
				
			}else if ( com.equals("B") ) {

				if ( kingX + 1 > 8) {
					continue;
				}
				
				if ( kingX + 1 == stoneX ) {
					if ( kingY == stoneY) {
						if ( stoneX + 1 >= 8) {
							continue;
						}
						
						stoneX++;
						kingX++;
						
					}else {
						kingX++;
					}
				}else {
					kingX++;
				}
				
			}else if ( com.equals("T") ) {
				
				if ( kingX - 1 < 0) {
					continue;
				}
				
				if ( kingX - 1 == stoneX ) {
					if ( kingY == stoneY) {
						if ( stoneX - 1 < 0) {
							continue;
						}
						
						stoneX--;
						kingX--;
						
					}else {
						kingX--;
					}
				}else {
					kingX--;
				}
				
			}else if ( com.equals("RT") ) {
				
				if ( kingX - 1 == stoneX && kingY + 1 == stoneY) {
					
					if ( stoneX - 1 >= 0 && stoneY + 1 <= 7) {
						stoneX--;
						stoneY++;
						kingX--;
						kingY++;
					}
					
				}else {
					if ( kingX - 1 >= 0 && kingY + 1 <= 7) {
						kingX--;
						kingY++;
					}
				}
				
			}else if ( com.equals("LT") ) {
				
				if ( kingX - 1 == stoneX && kingY - 1 == stoneY) {
					
					if ( stoneX - 1 >= 0 && stoneY - 1 >= 0) {
						stoneX--;
						stoneY--;
						kingX--;
						kingY--;
					}
					
				}else {
					if ( kingX - 1 >= 0 && kingY - 1 >= 0) {
						kingX--;
						kingY--;
					}
				}
				
			}else if ( com.equals("RB") ) {
				
				if ( kingX + 1 == stoneX && kingY + 1 == stoneY) {
					
					if ( stoneX + 1 <= 7 && stoneY + 1 <= 7) {
						stoneX++;
						stoneY++;
						kingX++;
						kingY++;
					}
					
				}else {
					if ( kingX + 1 <= 7 && kingY + 1 <= 7) {
						kingX++;
						kingY++;
					}
				}
				
			}else if ( com.equals("LB") ) {
				
				if ( kingX + 1 == stoneX && kingY - 1 == stoneY) {
					
					if ( stoneX + 1 <= 7 && stoneY - 1 >= 0) {
						stoneX++;
						stoneY--;
						kingX++;
						kingY--;
					}
					
				}else {
					if ( kingX + 1 <= 7 && kingY - 1 >= 0) {
						kingX++;
						kingY--;
					}
				}
				
			}
			
			
		}
		
		//System.out.print(kingX+","+kingY+" "+stoneX+","+stoneY);
		System.out.print((char)((char)(kingY)+'A'));
		System.out.println(8-kingX);
		System.out.print((char)((char)(stoneY)+'A'));
		System.out.print(8-stoneX);
	}
}
