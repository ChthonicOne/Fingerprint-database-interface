package fingerRest.helpers;

import fingerDB.attacker.Attacker;
import fingerDB.fingerprints.Fingerprint;
import fingerDB.scanner.Scanner;

public class DropOption 
{
	private Long id;
	private String name;
	
	public DropOption(Fingerprint print)
	{
		this.id = print.getId();
		this.name = print.getSetName();
	}
	
	public DropOption(Scanner scan)
	{
		this.id = scan.getId();
		this.name = scan.getName();
	}
	
	public DropOption(Attacker attack)
	{
		this.id = attack.getId();
		this.name = attack.getName();
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
