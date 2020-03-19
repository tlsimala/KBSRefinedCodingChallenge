import java.util.Scanner;

/**
 * @author tlsimala
 * 
 * This is the KaleidoClientCode class which allows the user to 
 * register a compound, assign a compound to a plate, transfer content from plates and wells, 
 * and request compounds.
 *
 */
public class KaleidoClientCode {
	/**
	 * The main method which calls the prompt method
	 * @param args
	 */
	public static void main(String[] args) {
		prompt();
	}
	
	/**
	 * A method which continues the prompt from the main method and prompts the user for information.
	 */
	public static void prompt() {
		System.out.println("\nType 1 to Register a New Plate.”+”\n”"
				+ "+”Type 2 to Register a Compound to a Well."+"\n"
				+"Type 3 to Transfer Contents from a Well to other Wells."
				+"\n"+ "Type 4 to Request type of Compound from a Well"
				+"\n"+"Type 0 to Finish the session.\n");
		collectInput();
	}
		/**
	 * This method collects the users choices and calls the appropriate methods.
	 */
	public static void collectInput() {
		Scanner scanner=new Scanner(System.in);
		int command=scanner.nextInt();

		switch(command) {
		case 1:
			plateRegistration(scanner);
			break;
		case 2:
			compoundRegistration(scanner);
			break;
		case 3:
			wellTrasnfer(scanner);
			break;
		case 4:
			compoundRequest(scanner);
			break;
		case 0:
			finish();
			scanner.close();
			break;
		}
	}

	private static void plateRegistration(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

	private static void compoundRegistration(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

	private static void wellTrasnfer(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

	private static void compoundRequest(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}

	private static void finish() {
		// TODO Auto-generated method stub
		
	}

}
