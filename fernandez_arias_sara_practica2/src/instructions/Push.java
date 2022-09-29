package instructions;

public class Push extends AbstractInstruction {
	private int value;
	public Push(int value) {
		this.value=value;
	}

	@Override
	public void run(Interpreter interpreter) {
		 interpreter.push(value);
		
	}

}