package instructions;

import java.util.Scanner;

public class Input extends AbstractInstruction {

	
	public void run(Interpreter interpreter) {
		System.out.println("Escriba un entero:");
		interpreter.push(readValue());
		interpreter.incrementIp();

	}

	private static int readValue() 
	{
		return new Scanner(System.in).nextInt();
	}
}
