package dennisjonathanlukas.web_sec_week_1_group.controllers;

import dennisjonathanlukas.web_sec_week_1_group.model.Account;
import dennisjonathanlukas.web_sec_week_1_group.repositories.AccountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping("/{username}")
    public List<Account> getPurchaseByIdInsecure(@PathVariable String username) {
        String query = "SELECT * FROM account WHERE user_name = '" + username + "'";
        List<Account> users = entityManager.createNativeQuery(query, Account.class).getResultList();

        return users;
    }

    @RequestMapping("/secure/{id}")
    public Account getPurchaseById(@PathVariable Long id) {
        System.out.println("Fetching id: id");
        return accountRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Purchase id: " + id + " not valid"));
    }
}
// http://localhost:9050/account/pelle
// http://localhost:9050/account/' OR '1'='1