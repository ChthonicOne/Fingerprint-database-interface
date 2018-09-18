package fingerDB.attacker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "attacker")
@Table(name = "attacker")
public class Attacker 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attacker_id", nullable = false)
	private long id;
	private String name,
				   desc,
				   path;
	private boolean directed;
	private char bwBox;
	
	public Attacker(String name, String desc, String path, boolean directed, char bwBox)
	{
		super();
		this.name = name;
		this.desc = desc;
		this.path = path;
		this.directed = directed;
		this.bwBox = bwBox;
	}
	
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc) 
	{
		this.desc = desc;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path) 
	{
		this.path = path;
	}

	public boolean isDirected()
	{
		return directed;
	}

	public void setDirected(boolean directed) 
	{
		this.directed = directed;
	}

	public char getBwBox() 
	{
		return bwBox;
	}

	public void setBwBox(char bwBox)
	{
		this.bwBox = bwBox;
	}

	@Override
	public String toString()
	{
		return String.format("[%d] Attacker %s: %s: %s Directed: %b Direction level: %c",
				id, name, desc, path, directed, bwBox);
	}
}
