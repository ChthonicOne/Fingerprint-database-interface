package fingerRest.manager;

import java.util.LinkedList;
import java.util.List;

import fingerDB.attacker.Attacker;
import fingerDB.attacker.AttackerService;
import fingerDB.fingerprints.Fingerprint;
import fingerDB.fingerprints.FingerprintService;
import fingerDB.results.ResultsService;
import fingerDB.runningProcess.RunningProcessService;
import fingerDB.scanner.Scanner;
import fingerDB.scanner.ScannerService;
import fingerRest.helpers.DropOption;

public class QueryManager 
{
	private AttackerService attacker;
	private FingerprintService fp;
	@SuppressWarnings("unused")
	private ResultsService results;
	@SuppressWarnings("unused")
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
	
	public List<DropOption> getAllScanners()
	{
		List<Scanner> scans = scanner.findAll();
		List<DropOption> options = new LinkedList<>();
		for (Scanner scan : scans)
		{
			options.add(new DropOption(scan));
		}
		return options;
	}

	public List<DropOption> getAllAttackers()
	{
		List<Attacker> attacks = attacker.findAll();
		List<DropOption> options = new LinkedList<>();
		for (Attacker attack : attacks)
		{
			options.add(new DropOption(attack));
		}
		return options;
	}
}
