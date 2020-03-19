import java.util.HashSet;
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
	public static HashSet<Plate> plateSet=new HashSet<Plate>();
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
	
	/**
	 * This method registers a new plate 
	 */
	public static void plateRegistration(Scanner scanner) {
		System.out.print("\nPlease Enter the Plate ID you want to Register: ");
		String ID=scanner.next();
		Plate plate=new Plate(ID);
		plateSet.add(plate);
		System.out.println("Plate "+ID+" has been registered."+"\n");
		prompt(); 
	}
	
	/**
	 * This method registers a compound to a well
	 * ASSUMPTION: I am assuming the scientist will type the plate number with the well ID 
	 * for instance, p-12345.A1
	 */
	public static void compoundRegistration(Scanner scanner) {
		System.out.print("\nPlease Enter the Compound you want to Register: ");
		String ID=scanner.next();
		System.out.print("Please Enter the Well you want to Assign "+ID+" to: ");
		String wellID=scanner.next();
		compoundRegistrationHelper(ID, wellID);
		System.out.println("Compound "+ID+" has been assigned to Well "+ID+".\n");
		prompt();
	}

	public static void compoundRegistrationHelper(String compound, String wellID) {
		String[] seperator=seperateIDs(wellID);
		Plate plate=getPlate(seperator[0]);
		Well newWell=new Well(seperator[1], compound);
		plate.addCompoundToAWell(newWell);
	}

	public static void wellTrasnfer(Scanner scanner) {
		
		
	}

	public static void compoundRequest(Scanner scanner) {
		
		
	}
	public static String[] seperateIDs(String ID) {
		int periodPoint=0;
		String[] seperator=new String[2];
		for(int i=0; i<ID.length(); i++) {
			if(ID.charAt(i)=='.') {
				periodPoint=i;
			}
		}
		seperator[0]=ID.substring(0, periodPoint-1);
		seperator[1]=ID.substring(periodPoint+1, ID.length());
		return seperator;
	}
	
	public static Plate getPlate(String ID) {
		for(Plate plate: plateSet) {
			if(plate.getID().equals(ID)) {
				return plate;
			}
		}
		return null;
	}

	public static void finish() {
		
		
	}

}
