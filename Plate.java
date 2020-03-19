import java.util.HashSet;

public class Plate {
	private String ID;
	private HashSet<Well> wellSet;
	
	public Plate(String plateID) {
		this.ID=plateID;
		this.wellSet=new HashSet<Well>();
	}
	public String getID() {
		return ID;
	}
	public void addCompoundToAWell(Well well) {
		wellSet.add(well);
	}
}
