package fingerRest.manager;

import java.util.LinkedList;
import java.util.List;

import fingerDB.attacker.AttackerService;
import fingerDB.fingerprints.Fingerprint;
import fingerDB.fingerprints.FingerprintService;
import fingerDB.results.ResultsService;
import fingerDB.runningProcess.RunningProcessService;
import fingerDB.scanner.ScannerService;
import fingerRest.helpers.DropOption;

public class QueryManager 
{
	private AttackerService attacker;
	private FingerprintService fp;
	private ResultsService results;
	private RunningProcessService process;
	private ScannerService scanner;
	
	
	public List<DropOption> getAllFingerprints() 
	{
		List<Fingerprint> prints = fp.findAll();
		List<DropOption> options = new LinkedList<>();
		for (Fingerprint print : prints)
		{
			options.add(new DropOption(print));
		}
		return options;
	}

}
