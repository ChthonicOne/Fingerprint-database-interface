package fingerDBMS.database.runningProcess;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import fingerDBMS.database.attacker.Attacker;
import fingerDBMS.database.fingerprints.Fingerprint;
import fingerDBMS.database.results.Results;
import fingerDBMS.database.scanner.Scanner;

@Entity(name = "process")
@Table(name = "process")
public class RunningProcess 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "process_id", nullable = false)
	private long id;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "process")
	//@JoinColumn(name="fingerprint_id")
	/*@JoinTable(name = "fingerprint_process",
			joinColumns = { @JoinColumn(name = "process_id")},
			inverseJoinColumns = { @JoinColumn(name = "fingerprint_id")})*/
	@Transient
	private Set<Fingerprint> fingerprints = new HashSet<>();
	
	@ManyToOne
    @JoinColumn(name = "scanner_id", nullable = false)
    private Scanner scanner;
	
	@ManyToOne
	@JoinColumn(name = "attacker_id", nullable = false)
	private Attacker attacker;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "results_id", nullable = true)
	private Results results;
	
	public RunningProcess() {}
	
	public RunningProcess(Set<Fingerprint> fingerprints, Scanner scanner, Attacker attacker)
	{
		super();
		this.fingerprints.addAll(fingerprints);
		this.scanner = scanner;
		this.attacker = attacker;
		this.scanner.addProcess(this);
		this.attacker.addProcess(this);
	}
	
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public Set<Fingerprint> getFingerprints()
	{
		return fingerprints;
	}

	public void setFingerprints(Set<Fingerprint> fingerprints)
	{
		this.fingerprints = fingerprints;
	}
	
	public void addFingerprints(Fingerprint fingerprints)
	{
		this.fingerprints.add(fingerprints);
	}

	public Scanner getScanner()
	{
		return scanner;
	}

	public void setScanner(Scanner scanner)
	{
		this.scanner = scanner;
	}

	public Attacker getAttacker()
	{
		return attacker;
	}

	public void setAttacker(Attacker attacker)
	{
		this.attacker = attacker;
	}

	public Results getResults()
	{
		return results;
	}

	public void setResults(Results results) 
	{
		this.results = results;
	}

	@Override
	public String toString()
	{
		return String.format("[%d] Process using %s to attack %s",
				id, attacker.getName(), scanner.getName());
	}
}
