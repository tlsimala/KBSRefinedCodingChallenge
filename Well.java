public class Well {
	private String ID;
	private String compound;
	/**
	 * The constructor
	 * @param wellId
	 * @param compound String
	 */
	public Well(String wellID, String compoundString) {
		this.ID=wellID;
		this.compound=compoundString;
	}
	/**
	 * This method returns the ID
	 * @param args
	 */
	public String getID() {
		return ID;
	}
	/**
	 * This method gets the type of compound associated with the well
	 * @param args
	 */
	public String getCompound() {
		return compound;
	}
}
