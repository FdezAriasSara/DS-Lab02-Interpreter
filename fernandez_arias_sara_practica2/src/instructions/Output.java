package instructions;

public class Output extends AbstractInstruction {

	@Override
	public void run(Interpreter interpreter) {
		System.out.println(	interpreter.pop());


	}

}
