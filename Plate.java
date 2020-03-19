import java.util.HashSet;

public class Plate {
	private String ID;
	private HashSet<Well> wellSet;
	/**
	 * Constructor
	 * @param plateID
	 */
	public Plate(String plateID) {
		this.ID=plateID;
		this.wellSet=new HashSet<Well>();
	}
	
	/**
	 * Gets the plate ID
	 * @return
	 */
	public String getID() {
		return ID;
	}
	
	/**
	 * Adds well to the plate
	 * @param well
	 */
	public void addCompoundToAWell(Well well) {
		wellSet.add(well);
	}
	
	/**
	 * Returns the well compound
	 * @param wellID
	 * @return
	 */
	public String returnCompound(String wellID) {
		for(Well well: wellSet) {
			if(well.getID().equals(wellID)) {
				return well.getCompound();
			}
		}
		return "";
	}
}
