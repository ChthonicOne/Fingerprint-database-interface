package fingerDB.results;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultsRepository extends JpaRepository<Results, Long>
{
	public List<Results> findAll();
	public Optional<Results> findById(Long id);
}
