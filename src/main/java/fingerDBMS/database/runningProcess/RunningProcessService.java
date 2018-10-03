package fingerDBMS.database.runningProcess;

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
public class RunningProcessService 
{
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(RunningProcessService.class);
	
	@Autowired
	private RunningProcessRepository repository;
	
	public long insert(RunningProcess RunningProcess)
	{
		repository.save(RunningProcess);
		return RunningProcess.getId();
	}
	
	public Optional<RunningProcess> find(long id)
	{
		return repository.findById(id);
	}
	
	public List<RunningProcess> findAll()
	{
		return repository.findAll();
	}
	
	public void delete(long id)
	{
		//log.info("Deleting " + id);
		repository.deleteById(id);
	}
	
	public long replace(long id, RunningProcess RunningProcess)
	{
		//log.info("Starting delete of " + id);
		delete(id);
		//log.info("Inserting " + fingerprint);
		return insert(RunningProcess);
	}
}
