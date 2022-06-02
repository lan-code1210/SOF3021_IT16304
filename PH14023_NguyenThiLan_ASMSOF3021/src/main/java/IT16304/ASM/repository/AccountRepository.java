package IT16304.ASM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import IT16304.ASM.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
