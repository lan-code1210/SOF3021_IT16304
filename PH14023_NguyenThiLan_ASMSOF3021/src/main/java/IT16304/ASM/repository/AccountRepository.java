package IT16304.ASM.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import IT16304.ASM.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
//	@Query(name="Account.findByEmail")
//	public Account timTheoEmail(@Param("email") String email);
	
	public Account findByEmailLike(String email);

}
