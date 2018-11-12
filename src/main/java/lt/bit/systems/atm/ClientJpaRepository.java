package lt.bit.systems.atm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ClientJpaRepository extends JpaRepository<Client, Integer> {
	@Transactional	
	@Modifying
	@Query("UPDATE Client c SET c.balance = c.balance + :amount WHERE c.id = :id")
	void updateBalance(@Param("id") String id, @Param("amount") int amount);
	
	@Query("SELECT c FROM Client c WHERE c.id = :id")
	List<Client> getClient(@Param("id") String id);
}
