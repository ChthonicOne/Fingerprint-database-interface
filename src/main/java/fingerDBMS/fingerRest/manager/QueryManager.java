package fingerDBMS.fingerRest.manager;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fingerDBMS.database.attacker.Attacker;
import fingerDBMS.database.attacker.AttackerService;
import fingerDBMS.database.fingerprints.Fingerprint;
import fingerDBMS.database.fingerprints.FingerprintService;
import fingerDBMS.database.results.ResultsService;
import fingerDBMS.database.runningProcess.RunningProcessService;
import fingerDBMS.database.scanner.Scanner;
import fingerDBMS.database.scanner.ScannerService;
import fingerDBMS.fingerRest.helpers.DropOption;

@Service
public class QueryManager 
{
	@Autowired
	private AttackerService attacker;
	@Autowired
	private FingerprintService fp;
	@SuppressWarnings("unused")
	@Autowired
	private ResultsService results;
	@SuppressWarnings("unused")
	@Autowired
	private RunningProcessService process;
	@Autowired
	private ScannerService scanner;
	
	public QueryManager() {}
	
	public List<DropOption> getAllFingerprints() 
	{
		List<Fingerprint> prints = fp.findAll();
		List<DropOption> options = new LinkedList<>();
		for (Fingerprint print : prints)
		{
			options.add(new DropOption(print));
		}
		if (options.isEmpty())
		{
			options.add(new DropOption());
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
		if (options.isEmpty())
		{
			options.add(new DropOption());
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
		if (options.isEmpty())
		{
			options.add(new DropOption());
		}
		return options;
	}
}
