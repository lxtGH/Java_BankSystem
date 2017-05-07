package classes;

public class record {
	private String name;
	private boolean status;
	/**
	 * record constructor, a record represents a key pair (name,status)
	 * @param name
	 * @param status
	 */
	public record(String name, boolean status) {
		super();
		this.name = name;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
