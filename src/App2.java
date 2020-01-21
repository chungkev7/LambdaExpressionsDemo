import java.util.function.Function;

public class App2 {

	public static void main(String[] args) {

		HelloInterface helloInterface1 = () -> System.out.println("Hello\n");
		helloInterface1.displayHello();
		
		DebugLambdaInterface debugLambda = (a,b) -> {
			System.out.println("Inside Lambda Expression");
			int sum = a + b;
			return sum;
		};
		
		System.out.println("Before calling the addTwoNumbers method");
		addTwoNumbers(debugLambda);
		System.out.println("After calling the addTwoNumbers method");
		System.out.println("End main\n");
		
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
		
		convertUsdToCad(); // 10 USD = 13.10 CAD
		calculateSquareOfNumber(); // 5 squared is: 25
		
		// Using andThen and compose from functional interface
		// Function<T,R>
		// @param <T> the type of the input of the function
		// @param <R> the type of the result of the function
		Function<String, String> function1 = s -> s.toUpperCase();
		Function<String, String> function2 = s -> s + " World";
		System.out.println("Output of function1: " + function1.apply("Hello")); // Output of function1: HELLO
		System.out.println("andThen Output: " + function1.andThen(function2).apply("Hello")); // andThen Output: HELLO World
		System.out.println("Output - Compose: " + function1.compose(function2).apply("Hello") + "\n"); // Output - Compose: HELLO WORLD
		
		Function<Integer, Integer> function3 = n1 -> n1 + n1;
		Function<Integer, Integer> function4 = n1 -> n1 * n1;
		System.out.println("Function 3 andThen Function 4: " + function3.andThen(function4).apply(10)); // Function 3 andThen Function 4: 400
		System.out.println("Function 3 compose Function 4: " + function3.compose(function4).apply(10)); // Function 3 compose Function 4: 200
	}

	static void helloMethodReference() {
		System.out.println("From helloMethodReference!\n");
	}
	
	private static void addTwoNumbers(DebugLambdaInterface debugLambda) {
		System.out.println("Start addTwoNumbers method");
		// sysout ("Inside Lambda Expression") displays first
		System.out.println("Sum of two numbers: " + debugLambda.sumOfTwoNumbers(100, 200));
		System.out.println("End of addTwoNumbers method");
	}
	
	// Predefined functional interface
	private static void convertUsdToCad() {
		Double intRate = 1.31;
		// Function<T,R>
		// @param <T> the type of the input of the function
		// @param <R> the type of the result of the function
		Function<Integer, Double> function = usd -> usd * intRate;
		System.out.println(10 + " USD = " + String.format("%.2f", function.apply(10)) + " CAD");
	}
	
	private static void calculateSquareOfNumber() {
		Function<Integer, Integer> function = n1 -> n1 * n1;
		System.out.println(5 + " squared is: " + function.apply(5) + "\n");
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