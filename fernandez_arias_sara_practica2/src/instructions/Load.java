package instructions;

public class Load extends AbstractInstruction {

	

	@Override
	protected void run(Interpreter interpreter) {
		int address = interpreter.pop();
		int content=interpreter.getMemoryAddress(address);
		interpreter.push(content);
		
	}

}
