package fingerDBMS.database.scanner;

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
public class ScannerService 
{
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ScannerService.class);
	
	@Autowired
	private ScannerRepository repository;
	
	public long insert(Scanner scanner)
	{
		repository.save(scanner);
		return scanner.getId();
	}
	
	public Optional<Scanner> find(long id)
	{
		return repository.findById(id);
	}
	
	public List<Scanner> findAll()
	{
		return repository.findAll();
	}
	
	public void delete(long id)
	{
		//log.info("Deleting " + id);
		repository.deleteById(id);
	}
	
	public long replace(long id, Scanner scanner)
	{
		//log.info("Starting delete of " + id);
		delete(id);
		//log.info("Inserting " + fingerprint);
		return insert(scanner);
	}
}
