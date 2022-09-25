package instructions;

import java.util.Scanner;

public class Input implements Instruction {

	@Override
	public void execute(Interpreter interpreter) {
		System.out.println("Escriba un entero:");
		interpreter.push(readValue());
		interpreter.incrementIp();

	}
	@SuppressWarnings("resource")
	private static int readValue() 
	{
		return new Scanner(System.in).nextInt();
	}
}
