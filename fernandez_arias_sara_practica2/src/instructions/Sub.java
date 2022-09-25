package instructions;

public class Sub implements Instruction {

	@Override
	public void execute(Interpreter interpreter) {
		int b = interpreter.pop();
		int a = interpreter.pop();
		interpreter.push(a - b);
		interpreter.incrementIp();
	}

}
