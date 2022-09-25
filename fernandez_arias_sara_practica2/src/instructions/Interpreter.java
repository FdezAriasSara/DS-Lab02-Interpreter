package instructions;


import java.util.*;

public class Interpreter {
	private static final String OUTPUT = "output";
	private static final String INPUT = "input";
	private static final String STORE = "store";
	private static final String LOAD = "load";
	private static final String JMPG = "jmpg";
	private static final String JMP = "jmp";
	private static final String SUB = "sub";
	private static final String ADD = "add";
	private static final String PUSH = "push";
	private static final String MUL = "mul";
	private static final String POP = "pop";
	private static List<Instruction> instructions = new ArrayList<>();
	private static int ip = 0;

	private static int[] memory = new int[1024];
	// Debería ser el interprete el que las conozca..
	private static int[] stack = new int[32];
	private static int sp = 0;

	  int getMemoryAddress(int address) {
		return memory[address];
	}

	  void storeInMemory(int address, int content) {
		memory[address] = content;
	}

	public void executeProgram() {
		while (ip < instructions.size()) {// mientras queden instrucciones por leer

			instructions.get(ip).execute(this);

		}
	}

	private static final boolean TRACE = false;
	/**
	 * Method that parses an input line into machine code.
	 */
	public void loadSentence(String line) {
		if (line.trim().length() == 0)
			return;

		String[] tokens = line.split(" ");
		if (TRACE) {
			for (String token : tokens)
				System.out.println("*" + token + "*");
		}
		generateInstruction(tokens);
	}
	/**
	 * Method that generates an Instruction-type object equivalent to the set of tokens passed as parameters
	 * @param tokens, array of strings taken from an input file.
	 */
	static void generateInstruction(String[] tokens) {

		String type = tokens[0];

		switch (type) {
		case PUSH:
			instructions.add(new Push(Integer.parseInt(tokens[1])));
			break;
		case POP:
			instructions.add(new Pop());
			break;
		case INPUT:
			instructions.add(new Input());
			break;
		case OUTPUT:
			instructions.add(new Output());

			break;
		case MUL:
			instructions.add(new Mult());
			break;
		case JMP:
			instructions.add(new Jmp(Integer.parseInt(tokens[1])));

			break;
		case JMPG:
			instructions.add(new Jmpg(Integer.parseInt(tokens[1])));
			break;
		case ADD:
			instructions.add(new Add());

			break;
		case SUB:
			instructions.add(new Sub());
			break;
		case LOAD:
			instructions.add(new Load());
			break;
		case STORE:
			instructions.add(new Store());
			break;
		default:
			break;
		}

	}

	void push(int value) {
		stack[sp] = value;
		sp++;
	}

	int pop() {
		sp--;
		return stack[sp];
	}

	void incrementIp() {
		++ip;
	}

	void setIp(int ip) {
		this.ip = ip;

	}
}
