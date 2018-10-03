package fingerDBMS.fingerRest;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fingerDBMS.fingerRest.helpers.DropOption;
import fingerDBMS.fingerRest.manager.QueryManager;

@RestController
@RequestMapping("/fingerdb")
public class FingerController 
{
	@Autowired
	private QueryManager query;
	
	private static final Logger log = LoggerFactory.getLogger(FingerController.class);
	
	@RequestMapping(value = "/fingerprintlist", method = RequestMethod.GET)
	public List<DropOption> fingerprintList()
	{
		List<DropOption> result = query.getAllFingerprints();
		return result;
	}
	
	@RequestMapping(value = "/scannerlist", method = RequestMethod.GET)
	public List<DropOption> scannerList()
	{
		List<DropOption> result = query.getAllScanners();
		return result;
	}
	
	@RequestMapping(value = "/attackerlist", method = RequestMethod.GET)
	public List<DropOption> attackerList()
	{
		List<DropOption> result = query.getAllAttackers();
		return result;
	}
}
