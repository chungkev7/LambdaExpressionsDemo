// Lambda expressions are associated with interfaces that have a single abstract method
// functional interface
interface Executable {
	int execute(int a, int b);
}

interface StringExecutable {
	int execute(String a);
}

class Runner {
	public void run(Executable e) {
		System.out.println("Executing code block...");
		int value = e.execute(12, 13);
		System.out.println("Return value is: " + value);
	}
	
	public void run(StringExecutable e) {
		System.out.println("Executing code block...");
		int value = e.execute("Hello");
		System.out.println("Return value is: " + value);
	}
	
}
//
//class Runner implements Executable{
//	public void run(Executable e) {
//		System.out.println("Executing code block...");
//		int value = e.execute(12, 13);
//		System.out.println("Return value is: " + value);
//	}
//
//	public int execute(int a, int b) {
//		return 0;
//	}
//}

// Lambda expression examples

// () -> System.out.println("Hello there.")

/*
 * () -> {
			System.out.println("This is code passed in a lambda expression.");
			System.out.println("Hello there.");
		}
 */

/*
 * () -> {
			System.out.println("This is code passed in a lambda expression.");
			System.out.println("Hello there.");
			return 8;
		}
 */

/*
 * () -> {
			return 8;
		}
 */

// () -> 8

// (int a) -> 8)

/*
 * (int a) -> { 
			System.out.println("Hello there.");
			return 7 + a;
		}
 */

/*
 * (a) -> { 
			System.out.println("Hello there.");
			return 7 + a;
		}
 */

/*
 * a -> { 
			System.out.println("Hello there.");
			return 7 + a;
		}
 */

/*
 * (a,b) -> { 
			System.out.println("Hello there.");
			return 7 + a;
		}
 */

public class App {

	public static void main(String[] args) {

		int c = 100;
		// Unable to change the variable, must effectively be declared final to use
		// c = 8;
		
		int d = 77;
		
		// Anonymous class
		Runner runner = new Runner();
		runner.run(new Executable() {
			public int execute(int a, int b) {	
				System.out.println("Hello there.");
				// Can declare int d as a different number
				// Different scope, a local variable
				// int d = 8;
				return a + b + c + d;
			}
		});
		
		// Separates the outputs
		System.out.println("==============================");
		
		// Lambda expression
		runner.run( (a,b) -> { 
			System.out.println("Hello there.");
			// Unable to reassign values for instance variables (variables bounded to the object)
			// int d = 99;
			return a + b + c;
		});
		
		// Separates the outputs
		System.out.println("==============================");
		
		Executable ex = (a,b) -> { 
			System.out.println("Hello there.");
			return a + b + c;
		};
		
		runner.run(ex);
	}

}

