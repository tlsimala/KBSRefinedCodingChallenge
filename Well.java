
public class Well {
	
	private String ID;
	private String compound;
	/**
	 * Constructor
	 * @param wellID
	 * @param compoundString
	 */
	public Well(String wellID, String compoundString) {
		this.ID=wellID;
		this.compound=compoundString;
	}
	
	/**
	 * Gets Well ID
	 * @return String ID
	 */
	public String getID() {
		return ID;
	}
	
	/**
	 * Gets Compound
	 * @return String compound
	 */
	public String getCompound() {
		return compound;
	}
}
