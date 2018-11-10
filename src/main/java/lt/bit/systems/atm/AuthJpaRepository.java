package lt.bit.systems.atm;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface AuthJpaRepository extends JpaRepository<Client, Integer> {
//	@Query("select p from Auth p where p.imei = :imei")
//	List<Auth> findByImei(@Param("imei") String imei);
	
	@Query("select p from Client p where p.id = :id")
	List<Client> findByID(@Param("id") String id);
	
}
