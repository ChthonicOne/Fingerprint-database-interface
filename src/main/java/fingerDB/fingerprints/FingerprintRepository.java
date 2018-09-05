package fingerDB.fingerprints;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FingerprintRepository extends JpaRepository<Fingerprint, Long> 
{
	public List<Fingerprint> findAll();
	public Optional<Fingerprint> findById(long id);
}
