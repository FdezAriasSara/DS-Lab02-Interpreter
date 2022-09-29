package instructions;

public class Add extends AbstractInstruction {

	@Override
	public void run(Interpreter interpreter) {
		//primer pop: saca el valor de la cima de la pila
		//El segundo: saca el valor que queda en la cima
		//los suma, y mete el resultado en la cima.
		interpreter.push(interpreter.pop() + interpreter.pop());

	}

}
