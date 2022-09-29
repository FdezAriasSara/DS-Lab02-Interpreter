package instructions;

public class Mult extends AbstractInstruction {

	@Override
	public void run(Interpreter interpreter) {
		int b = interpreter.pop();
		int a = interpreter.pop();
		interpreter.push(a * b);
	
	}

}
