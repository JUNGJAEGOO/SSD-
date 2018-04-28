package lambdaPrac;

public class Main {
	public static void main(String args[]) {
		
		Main now = new Main();
		int x = 2;
		int y = 3;
		now.calcutateLambda(x,y);
		now.calcutateClassic(x, y);
	}
	
	private void calcutateLambda(int x,int y) {
		Calculate calculateAdd = (a,b) -> a+b;
		int sum = calculateAdd.operation(x,y);
		System.out.println("Lambda's Result : "+sum);
	}
	
	private void calcutateClassic(int x,int y) {
		Calculate calculateAdd = new Calculate() {

			@Override
			public int operation(int a, int b) {
				
				return a+b;
			}
			
		};
		int sum = calculateAdd.operation(x,y);
		System.out.println("Classic's Result : "+sum);
	}
}
