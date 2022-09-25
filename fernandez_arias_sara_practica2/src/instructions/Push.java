package instructions;

public class Push implements Instruction {
	private int value;
	public Push(int value) {
		this.value=value;
	}

	@Override
	public void execute(Interpreter interpreter) {
		 interpreter.push(value);
		 interpreter.incrementIp();
	}

}