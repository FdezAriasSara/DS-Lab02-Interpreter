package instructions;

public class Load implements Instruction {

	@Override
	public void execute(Interpreter interpreter) {
		
		int address = interpreter.pop();
		int content=interpreter.getMemoryAddress(address);
		interpreter.push(content);
		interpreter.incrementIp();

	}

}
