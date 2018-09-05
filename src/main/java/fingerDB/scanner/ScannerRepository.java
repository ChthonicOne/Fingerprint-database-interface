package fingerDB.scanner;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScannerRepository extends JpaRepository<Scanner, Long> 
{
	public List<Scanner> findAll();
	public Optional<Scanner> findById();
}
