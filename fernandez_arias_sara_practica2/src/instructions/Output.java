package instructions;

public class Output implements Instruction {

	@Override
	public void execute(Interpreter interpreter) {
		System.out.println(	interpreter.pop());
		interpreter.incrementIp();

	}

}
