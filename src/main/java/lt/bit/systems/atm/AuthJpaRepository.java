package lt.bit.systems.atm;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface AuthJpaRepository extends JpaRepository<Client, Integer> {
	
	@Query("SELECT p FROM Client p WHERE p.id = :id")
	List<Client> findByID(@Param("id") String id);
	
}
