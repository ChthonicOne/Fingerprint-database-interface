package fingerDB.attacker;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttackerRepository extends JpaRepository<Attacker, Long> 
{
	List<Attacker> findAll();
	Optional<Attacker> findById(long id);
}
