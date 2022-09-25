package instructions;

public class Store implements Instruction {

	@Override
	public void execute(Interpreter interpreter) {
		int value = interpreter.pop();
		int address = interpreter.pop();
		interpreter.storeInMemory(address,value);
		interpreter.incrementIp();

	}

}
