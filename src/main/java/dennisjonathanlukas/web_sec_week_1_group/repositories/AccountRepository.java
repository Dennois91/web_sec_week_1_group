package dennisjonathanlukas.web_sec_week_1_group.repositories;

import dennisjonathanlukas.web_sec_week_1_group.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
List<Account> findByUserName(String user_name);
}
