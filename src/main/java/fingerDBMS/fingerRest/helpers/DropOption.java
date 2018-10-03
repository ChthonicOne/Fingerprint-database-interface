package fingerDBMS.fingerRest.helpers;

import fingerDBMS.database.attacker.Attacker;
import fingerDBMS.database.fingerprints.Fingerprint;
import fingerDBMS.database.scanner.Scanner;

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
	
	public DropOption()
	{
		this.id = -1L;
		this.name = "<Database is empty>";
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
