package fingerDBMS.database.scanner;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fingerDBMS.database.runningProcess.RunningProcess;

@Entity(name = "scanner")
@Table(name = "scanner")
public class Scanner
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "scanner_id", nullable = false)
	private Long id;
	private String name,
				   path,
				   desc,
				   CLOptions;
	@OneToMany(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            orphanRemoval = true)
	@JoinColumn(name = "process_id")
    private Set<RunningProcess> process = new HashSet<>();
	
	public Scanner() {}
	
	public Scanner(String name, String path, String desc, String CLOptions)
	{
		super();
		this.name = name;
		this.path = path;
		this.desc = desc;
		this.CLOptions = CLOptions;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
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

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc) 
	{
		this.desc = desc;
	}
	
	public String getCLOptions()
	{
		return CLOptions;
	}

	public void setCLOptions(String cLOptions)
	{
		CLOptions = cLOptions;
	}

	public Set<RunningProcess> getProcess() 
	{
		return process;
	}

	public void setProcess(Set<RunningProcess> process) 
	{
		this.process = process;
	}

	public void addProcess(RunningProcess process)
	{
		this.process.add(process);
	}

	@Override
	public String toString()
	{
		return String.format("[%d] Scanner %s: %s: %s", id, name, desc, path);
	}
}
