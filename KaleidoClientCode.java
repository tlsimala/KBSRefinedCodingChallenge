
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
		System.out.println("\nType 1 to Register a New Plate.\n"
				+ "Type 2 to Register a Compound to a Well.\n"
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
			wellTransfer(scanner);
			break;
		case 4:
			compoundRequest(scanner);
			break;
		case 0:
			scanner.close();
			break;
		}
	}
	
	/**
	 * This method registers a new plate 
	 * ASSUMPTION: The plate entered will not have a well ID attached to it 
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
		System.out.println("Compound "+ID+" has been assigned to Well "+wellID+".\n");
		prompt();
	}
	/**
	 * This method helps the compoundRegistration method
	 * @param compound
	 * @param wellID
	 */
	public static void compoundRegistrationHelper(String compound, String wellID) {
		String[] separator=separateIDs(wellID); //splits the plate and well ID
		Plate plate=getPlate(separator[0]); //gets the plate
		Well newWell=new Well(separator[1], compound); //creates well object
		plate.addCompoundToAWell(newWell); //adds it to the plate
	}

	/**
	 * This method transfers compounds to wells
	 * @param scanner
	 */
	public static void wellTransfer(Scanner scanner) {
		System.out.print("\nPlease Enter the Well you want to Transfer contents from: ");
		String wellID=scanner.next();
		System.out.print("Please Enter the Well/Wells you want to Transfer contents to: ");
		scanner.nextLine();
		String wellsID=scanner.nextLine();
		wellTransferHelper(wellID, wellsID); //calls a helper method
		System.out.println("Well "+wellID+" contents has been Transferred to "+wellsID+".\n");
		prompt();
	}

	/**
	 * This method helps the wellTransfer method
	 * @param wellID
	 * @param wellsID
	 */
	public static void wellTransferHelper(String wellID, String wellsID) {
		String[] seperator=separateIDs(wellID); //separates the plate and well ID
		Plate plate=getPlate(seperator[0]); //gets plate
		String compound=plate.returnCompound(seperator[1]); //gets compound
		
		String[] wellsArray=wellsID.split(","); //splits the wells string to break down the number of wells
		for(int i=0; i<wellsArray.length; i++) {
			String newWellString=wellsArray[i]; 
			newWellString=newWellString.trim();
			String[] extraSeparator=separateIDs(newWellString); //separates the plate and well ID
			Plate newPlate=new Plate(extraSeparator[0]);  //create a new plate
			Well newWell=new Well(extraSeparator[1], compound); //creates a new well
			newPlate.addCompoundToAWell(newWell); //adds it to the plate
			plateSet.add(newPlate);
		}
	}
	
	/**
	 * This method gets the type of compound that is in a particular well
	 * @param scanner
	 */
	public static void compoundRequest(Scanner scanner) {
		System.out.print("\nPlease Enter the Well you want to Request a Compound type from: ");
		String ID=scanner.next();
		String compound=compoundRequestHelper(ID); //calls a helper method
		if(!compound.equals("")) {
			System.out.println("Well "+ ID+" has Compound "+compound.toString()+".");
		}
		else {
			System.out.println("That Well does not have a Compound.");
		}
		prompt();
	}
	
	/**
	 * This method helps to return the type of compound
	 * @param wellID
	 * @return String compound
	 */
	public static String compoundRequestHelper(String wellID) {
		String[] seperator=separateIDs(wellID);
		Plate plate=getPlate(seperator[0]);
		String compound=plate.returnCompound(seperator[1]);
		return compound;
	}
	
	/**
	 * This method separates the plate and well ID
	 * @param ID
	 * @return String[]
	 */
	public static String[] separateIDs(String ID) {
		int periodPoint=0;
		String[] separator=new String[2];
		for(int i=0; i<ID.length(); i++) {
			if(ID.charAt(i)=='.') {
				periodPoint=i;
			}
		}
		separator[0]=ID.substring(0, periodPoint);
		separator[1]=ID.substring(periodPoint+1, ID.length());
		return separator;
	}
	
	/**
	 * This method gets the plate
	 * @param ID
	 * @return plate
	 */
	public static Plate getPlate(String ID) {
		for(Plate plate: plateSet) {
			if(plate.getID().equals(ID)) {
				return plate;
			}
		}
		return null;
	}
}
