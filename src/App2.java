
public class App2 {

	public static void main(String[] args) {

		HelloInterface helloInterface1 = () -> System.out.println("Hello");
		helloInterface1.displayHello();
		System.out.println();
		
		DebugLambdaInterface debugLambda = (a,b) -> {
			System.out.println("Inside Lambda Expression");
			int sum = a + b;
			return sum;
		};
		
		System.out.println("Before calling the addTwoNumbers method");
		addTwoNumbers(debugLambda);
		System.out.println("After calling the addTwoNumbers method");
		System.out.println("End main");
		System.out.println();
		
		// Method references: allows one method to refer to another method
		// Can be used to refer a static and non-static (instance method) methods
		// 1. both method names can be different
		// 2. Parameter should be the same in both methods
		// 3. Method reference can only be used with functional interfaces (interfaces with only 1 single abstract method)
		// 4. The return type of both of the methods can be different
		MethodReference methodReference = App2 :: helloMethodReference;
		methodReference.helloMethodReference();
		MethodReference methodReference2 = () -> App2.helloMethodReference();
		methodReference2.helloMethodReference();
	}

	private static void addTwoNumbers(DebugLambdaInterface debugLambda) {
		System.out.println("Start addTwoNumbers method");
		// sysout ("Inside Lambda Expression") displays first
		System.out.println("Sum of two numbers: " + debugLambda.sumOfTwoNumbers(100, 200));
		System.out.println("End of addTwoNumbers method");
	}
	
	static void helloMethodReference() {
		System.out.println("From helloMethodReference!");
	}
}

interface HelloInterface {
	public void displayHello();
}

interface DebugLambdaInterface {
	public int sumOfTwoNumbers(int a, int b);
}

interface MethodReference {
	public void helloMethodReference();
}