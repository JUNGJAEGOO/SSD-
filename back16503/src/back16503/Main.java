package back16503;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int a = Integer.parseInt(st.nextToken());
		char op1 =  st.nextToken().charAt(0);
		int b = Integer.parseInt(st.nextToken());
		char op2 = st.nextToken().charAt(0);
		int c = Integer.parseInt(st.nextToken());
		
		int one = 0;
		int two = 0;
		
		if ( op1 == '+') {
			
			if ( op2 == '+') {
				
				one = a + b + c;
				two = a + b + c;
				
			}else if ( op2 == '-') {
				
				one = ( a + b ) - c;
				two = a + ( b - c );
				
			}else if ( op2 == '/') {
				
				one = (a+b) / c;
				two = a + ( b / c );
				
			}else if ( op2 == '*') {
				
				one = (a+b) * c ;
				two = a + (b*c);
			}
			
		}else if ( op1 == '-') {
			
			if ( op2 == '+') {
				
				one = ( a - b ) + c;
				two = a - ( b + c );
				
			}else if ( op2 == '-') {
				
				one = ( a - b ) - c;
				two = a - ( b - c );
				
			}else if ( op2 == '/') {
				if ( a - b > 0) {
					one = ( a - b ) / c;
				}else {
					one = -(-(a-b) / c);
				}
				
				two = a - ( b / c );
				
			}else if ( op2 == '*') {
				one = ( a - b ) * c;
				two = a - ( b * c );
				
			}
			
		}else if ( op1 == '/') {
			
			if ( op2 == '+') {
				one = ( a / b ) + c;
				two = a / ( b + c );
				
			}else if ( op2 == '-') {
				one = ( a / b ) - c;
				
				if ( b - c > 0) {
					two = a / ( b - c );
				}else {
					two = - (a / -(b-c) );
				}
			}else if ( op2 == '/') {
				one = ( a / b ) / c;
				two = a / ( b / c );
			}else if ( op2 == '*') {
				one = ( a / b ) * c;
				two = a / ( b * c );
			}
			
		}else if ( op1 == '*') {
			
			if ( op2 == '+') {
				one = ( a * b ) + c;
				two = a * ( b + c );
			}else if ( op2 == '-') {
				one = ( a * b ) - c;
				two = a * ( b - c );
			}else if ( op2 == '/') {
				one = ( a * b ) / c;
				two = a * ( b / c );
			}else if ( op2 == '*') {
				one = ( a * b ) * c;
				two = a * ( b * c );
			}
			
		}
		
		if ( one > two ) {
			int tmp = two;
			two = one;
			one = tmp;
		}
		
		System.out.print(one+"\n"+two);
	}
}
