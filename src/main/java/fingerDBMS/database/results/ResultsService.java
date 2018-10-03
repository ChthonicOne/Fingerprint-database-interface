package fingerDBMS.database.results;

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
public class ResultsService
{
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ResultsService.class);
	
	@Autowired
	private ResultsRepository repository;
	
	public long insert(Results Results)
	{
		repository.save(Results);
		return Results.getId();
	}
	
	public Optional<Results> find(long id)
	{
		return repository.findById(id);
	}
	
	public List<Results> findAll()
	{
		return repository.findAll();
	}
	
	public void delete(long id)
	{
		//log.info("Deleting " + id);
		repository.deleteById(id);
	}
	
	public long replace(long id, Results Results)
	{
		//log.info("Starting delete of " + id);
		delete(id);
		//log.info("Inserting " + fingerprint);
		return insert(Results);
	}
}
