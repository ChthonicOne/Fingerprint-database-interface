package fingerRest.helpers;

import fingerDB.fingerprints.Fingerprint;

public class DropOption 
{
	private Long id;
	private String name;
	
	public DropOption(Fingerprint print)
	{
		this.id = print.getId();
		this.name = print.getSetName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
