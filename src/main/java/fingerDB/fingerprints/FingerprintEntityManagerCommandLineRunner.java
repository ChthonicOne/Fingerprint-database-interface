package fingerDB.fingerprints;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FingerprintEntityManagerCommandLineRunner implements CommandLineRunner 
{
	private static final Logger log = LoggerFactory.getLogger(FingerprintEntityManagerCommandLineRunner.class);
	
	@Autowired
	private FingerprintService fingerprintService;
	
	public void run(String... args) throws Exception 
	{
		log.info("-------------------------------");
		log.info("Adding Tom's fingerprint at /data/Tom/");
		log.info("-------------------------------");
		Fingerprint tom = new Fingerprint("Tom", "/data/Tom/", 10, 5);
		fingerprintService.insert(tom);
		log.info("Inserted Tom" + tom);
		
		log.info("-------------------------------");
		log.info("Finding fingerprint with id 1");
		log.info("-------------------------------");
		Optional<Fingerprint> fingerprint = fingerprintService.find(1L);
		log.info(fingerprint.get().toString());
		
		log.info("-------------------------------");
		log.info("Finding all fingerprints");
		log.info("-------------------------------");
		log.info(fingerprintService.findAll().toString());
		
		log.info("-------------------------------");
		log.info("Changing Tom's fingerprint to /data/Tom/ /data/fingerprints/Tom/");
		log.info("-------------------------------");
		tom = new Fingerprint("Tom", "/data/fingerprints/Tom/", 10, 5);
		fingerprintService.replace(fingerprint.get().getId(), tom);
		log.info("Replaced " + fingerprint + " with " + tom);
		
		log.info("-------------------------------");
		log.info("Finding all fingerprints");
		log.info("-------------------------------");
		log.info(fingerprintService.findAll().toString());
		
		log.info("-------------------------------");
		log.info("Removing Tom from database");
		log.info("-------------------------------");
		fingerprintService.delete(tom.getId());
		
		log.info("-------------------------------");
		log.info("Finding all fingerprints");
		log.info("-------------------------------");
		log.info(fingerprintService.findAll().toString());
	}

}
