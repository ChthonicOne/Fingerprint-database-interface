package fingerDB.runningProcess;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RunningProcessRepository extends JpaRepository<RunningProcess, Long> 
{
	public List<RunningProcess> findAll();
	public Optional<RunningProcess> findById(Long id);
}
