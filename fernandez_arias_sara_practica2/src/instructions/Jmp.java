package instructions;

public class Jmp implements Instruction {
	private int jumpSize;
	public Jmp(int jumpSize) {
		this.jumpSize=jumpSize;
	}

	@Override
	public void execute(Interpreter interpreter) {
		interpreter.setIp(jumpSize);

	}

}
