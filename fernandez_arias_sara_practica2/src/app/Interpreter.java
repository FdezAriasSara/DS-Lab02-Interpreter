package app;
import java.io.*;
import java.util.*;

public class Interpreter 
{
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
	private static List<String[]> instructions = new ArrayList<>();
	private static int ip = 0;

	private static int[] memory = new int[1024];
	// Debería ser el interprete el que las conozca..
	private static int[] stack = new int[32];
	private static int sp = 0;
   static void generateInstructions() {
	   for (String[] sentence : instructions) {
		   String type=sentence[0];
		   switch (type) {
		   case PUSH:
			
			break;
		   case POP:
				
				break;
		   default:
			break;
		}
		
	} 
		   
   }
	

	
	
	static void executeProgram() 
	{
		while (ip < instructions.size()) {//mientras queden instrucciones por leer
			//POR CADA INSTRUCCION DEL CÓDIGO MÁQUINA  
			String[] sentence = instructions.get(ip);

			if (sentence[0].equals(PUSH)) {//mete valores a la pila 
				int value=Integer.parseInt(sentence[1]);
				
				push(value);
				ip++;
			} else if (sentence[0].equals(ADD)) {
				//primer pop: saca el valor de la cima de la pila
				//El segundo: saca el valor que queda en la cima
				//los suma, y mete el resultado en la cima.
				push(pop() + pop());
				ip++;
			} else if (sentence[0].equals(SUB)) {
				int b = pop();
				int a = pop();
				push(a - b);
				ip++;
			} else {
				
				if (sentence[0].equals(MUL)) {
					push(pop() * pop());
					ip++;
				} else if (sentence[0].equals(JMP)) {//modifica el puntero ip <<a mano>>
					ip = Integer.parseInt(sentence[1]);
				} else if (sentence[0].equals(JMPG)) {
					int b = pop();
					int a = pop();
					if (a > b)
						ip = Integer.parseInt(sentence[1]);
					else
						ip++;
				} else if (sentence[0].equals(LOAD)) {
					//asumimos que la direccion esta en la pila ya
					int address = pop();
					push(memory[address]);
					ip++;
				} else if (sentence[0].equals(STORE)) {
					int value = pop();
					int address = pop();
					memory[address] = value;
					ip++;
					//entrada y salida ( solo con enteros
				} else if (sentence[0].equals(INPUT)) {
					System.out.println("Escriba un entero:");
					push(readValue());
					ip++;
				} else if (sentence[0].equals(OUTPUT)) {
					System.out.println(pop());
					ip++;
				}
			}
		}
	}

	private static final boolean TRACE = false;

	static void loadSentence(String line) 
	{
		if (line.trim().length() == 0)
			return;

		String[] tokens = line.split(" ");
		if (TRACE) {
			for (String token : tokens)
				System.out.println("*" + token + "*");
		}
		instructions.add(tokens);
	}

	private static void push(int value) 
	{
		stack[sp] = value;
		sp++;
	}

	private static int pop() 
	{
		sp--;
		return stack[sp];
	}

	private static int readValue() 
	{
		return new Scanner(System.in).nextInt();
	}
}
