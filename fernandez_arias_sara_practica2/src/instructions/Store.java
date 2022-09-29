package instructions;

public class Store extends AbstractInstruction{

	@Override
	public void run(Interpreter interpreter) {
		int value = interpreter.pop();
		int address = interpreter.pop();
		interpreter.storeInMemory(address,value);
		

	}

}
