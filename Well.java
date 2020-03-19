public class Well {
	private String ID;
	private String compound;
	public Well(String wellID, String compoundString) {
		this.ID=wellID;
		this.compound=compoundString;
	}
	public String getID() {
		return ID;
	}
	public String getCompound() {
		return compound;
	}
}
