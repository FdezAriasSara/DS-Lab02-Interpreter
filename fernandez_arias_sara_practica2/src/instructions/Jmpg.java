package instructions;

public class Jmpg implements Instruction {
	private int jumpSize;
	public Jmpg(int jumpSize) {
		this.jumpSize=jumpSize;
	}
	@Override
	public void execute(Interpreter interpreter) {
		int b = interpreter.pop();
		int a = interpreter.pop();
		if (a > b)
			interpreter.setIp(jumpSize);
		else
			interpreter.incrementIp();
	

	}

}
