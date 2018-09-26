package fingerRest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fingerRest.helpers.DropOption;
import fingerRest.manager.QueryManager;

@RestController
@RequestMapping("/fingerdb")
public class FingerController 
{
	private QueryManager query;
	
	@RequestMapping(value = "/fingerprintlist", method = RequestMethod.GET)
	public List<DropOption> fingerprintList()
	{
		return query.getAllFingerprints();
	}
}
