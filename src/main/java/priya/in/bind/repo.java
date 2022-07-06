package priya.in.bind;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface repo extends JpaRepository<contactDtls,Integer> {
	
	@Query(value="select * from contact_dtls where contact_id=:id", nativeQuery=true)
	contactDtls find(int id);

	 
	
	
}
