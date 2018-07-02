package fingerDB.fingerprints;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class FingerprintService 
{
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(FingerprintService.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(Fingerprint fingerprint)
	{
		entityManager.persist(fingerprint);
		return fingerprint.getId();
	}
	
	public Fingerprint find(long id)
	{
		return entityManager.find(Fingerprint.class, id);
	}
	
	public List<Fingerprint> findAll()
	{
		TypedQuery<Fingerprint> query = entityManager.createNamedQuery("Query_select_all_Fingerprint", Fingerprint.class);
		return query.getResultList();
	}
	
	public void delete(long id)
	{
		//log.info("Deleting " + id);
		entityManager.remove(find(id));
	}
	
	public long replace(long id, Fingerprint fingerprint)
	{
		//log.info("Starting delete of " + id);
		delete(id);
		//log.info("Inserting " + fingerprint);
		return insert(fingerprint);
	}
}
