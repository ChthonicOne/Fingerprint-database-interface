package fingerDBMS.database.fingerprints;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Repository
public class FingerprintService 
{
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(FingerprintService.class);
	
	@Autowired
	private FingerprintRepository repository;
	
	public long insert(Fingerprint fingerprint)
	{
		repository.save(fingerprint);
		return fingerprint.getId();
	}
	
	public Optional<Fingerprint> find(long id)
	{
		return repository.findById(id);
	}
	
	public List<Fingerprint> findAll()
	{
		return repository.findAll();
	}
	
	public void delete(long id)
	{
		//log.info("Deleting " + id);
		repository.deleteById(id);
	}
	
	public long replace(long id, Fingerprint fingerprint)
	{
		//log.info("Starting delete of " + id);
		delete(id);
		//log.info("Inserting " + fingerprint);
		return insert(fingerprint);
	}
}
