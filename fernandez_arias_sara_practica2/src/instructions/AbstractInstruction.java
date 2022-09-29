package instructions;

public abstract class AbstractInstruction implements Instruction {

	@Override
	public void execute(Interpreter interpreter) {
		
		run(interpreter);
		interpreter.incrementIp(); //Aunque sea una única linea, es código común
	}
	protected abstract void run(Interpreter interpreter);
}
