package dennisjonathanlukas.web_sec_week_1_group.controllers;

import dennisjonathanlukas.web_sec_week_1_group.model.Account;
import dennisjonathanlukas.web_sec_week_1_group.repositories.AccountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

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
    public List<Account> InsecureGetPurchaseByUsername(@PathVariable String username) {
        String query = "SELECT * FROM account WHERE user_name = '" + username + "'";
        List<Account> users = entityManager.createNativeQuery(query, Account.class).getResultList();
        return users;
    }

    @RequestMapping("/username/{username}")
    public List<Account> secureGetPurchaseByUsername(@PathVariable String username) {
        return accountRepository.findByUserName(username);
    }

    @PutMapping("/update")
    public Account updateUsernameAndPassword(@RequestBody Account account) {
        return accountRepository.save(account);
    }




}
// http://localhost:9050/account/pelle
// http://localhost:9050/account/' OR '1'='1