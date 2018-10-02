package fingerDB.fingerprints;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import fingerDB.runningProcess.RunningProcess;

import javax.persistence.JoinColumn;

@Entity(name = "fingerprint")
@Table(name = "fingerprint")
public class Fingerprint 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "fingerprint_id", nullable = false)
	private Long id;
	private String setName,
				   path;
	private int printPerPerson,
				numPeople;
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	@JoinTable(name = "fingerprint_process", 
	           joinColumns = @JoinColumn(name = "fingerprint_id", 
	                                     referencedColumnName = "fingerprint_id"), 
	           inverseJoinColumns = @JoinColumn(name = "process_id", 
	                                            referencedColumnName = "process_id"))
	private Set<RunningProcess> processes = new HashSet<>();
	
	protected Fingerprint() {}
	
	public Fingerprint(String setName, String path, int printPerPerson, int numPeople)
	{
		super();
		this.setName = setName;
		this.path = path;
		this.printPerPerson = printPerPerson;
		this.numPeople = numPeople;
	}
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getSetName()
	{
		return setName;
	}

	public void setSetName(String setName) 
	{
		this.setName = setName;
	}

	public String getPath() 
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public int getPrintPerPerson() 
	{
		return printPerPerson;
	}

	public void setPrintPerPerson(int printPerPerson) 
	{
		this.printPerPerson = printPerPerson;
	}

	public int getNumPeople()
	{
		return numPeople;
	}

	public void setNumPeople(int numPeople)
	{
		this.numPeople = numPeople;
	}

	public Set<RunningProcess> getProcesses() 
	{
		return processes;
	}

	public void setProcesses(Set<RunningProcess> processes) 
	{
		this.processes = processes;
	}
	
	public void addProcesses(RunningProcess process)
	{
		this.processes.add(process);
	}

	@Override
	public String toString()
	{
		return String.format("[%d] Set %s(%d prints for %d people): %s", id, setName, 
							  this.printPerPerson, this.numPeople, path);
	}
}
