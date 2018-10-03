package fingerDBMS.database.results;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fingerDBMS.database.runningProcess.RunningProcess;

@Entity(name = "results")
@Table(name = "results")
public class Results 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "results_id", nullable = false)
	private long id;
	
	private String path;
	private double accuracy;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "running_process_id", nullable = false)
    private RunningProcess process;
	
	public Results(String path, double accuracy, RunningProcess process)
	{
		super();
		this.path = path;
		this.accuracy = accuracy;
		this.process = process;
	}
	
	public long getId()
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public double getAccuracy()
	{
		return accuracy;
	}

	public void setAccuracy(double accuracy) 
	{
		this.accuracy = accuracy;
	}

	public RunningProcess getProcess()
	{
		return process;
	}

	public void setProcess(RunningProcess process)
	{
		this.process = process;
	}

	@Override
	public String toString()
	{
		return String.format("[%d] Result for [%d] Process: Accuracy %f: Path = %s",
				id, process.getId(), accuracy, path);
	}
}
