package dennisjonathanlukas.web_sec_week_1_group.controllers;

import dennisjonathanlukas.web_sec_week_1_group.model.Account;
import dennisjonathanlukas.web_sec_week_1_group.repositories.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/{id}")
    public Account getPurchaseById(@PathVariable Long id) {
        System.out.println("Fetching id: id");
        return accountRepository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Purchase id: " + id + " not valid"));
    }
}
