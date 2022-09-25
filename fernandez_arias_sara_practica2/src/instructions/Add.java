package instructions;

public class Add implements Instruction {

	@Override
	public void execute(Interpreter interpreter) {
		//primer pop: saca el valor de la cima de la pila
		//El segundo: saca el valor que queda en la cima
		//los suma, y mete el resultado en la cima.
		interpreter.push(interpreter.pop() + interpreter.pop());
		interpreter.incrementIp();
	}

}
