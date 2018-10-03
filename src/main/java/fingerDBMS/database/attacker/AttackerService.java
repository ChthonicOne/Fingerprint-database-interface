package fingerDBMS.database.attacker;

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
public class AttackerService 
{
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(AttackerService.class);
	
	@Autowired
	private AttackerRepository repository;
	
	public long insert(Attacker attacker)
	{
		repository.save(attacker);
		return attacker.getId();
	}
	
	public Optional<Attacker> find(long id)
	{
		return repository.findById(id);
	}
	
	public List<Attacker> findAll()
	{
		return repository.findAll();
	}
	
	public void delete(long id)
	{
		//log.info("Deleting " + id);
		repository.deleteById(id);
	}
	
	public long replace(long id, Attacker attacker)
	{
		//log.info("Starting delete of " + id);
		delete(id);
		//log.info("Inserting " + fingerprint);
		return insert(attacker);
	}
}
