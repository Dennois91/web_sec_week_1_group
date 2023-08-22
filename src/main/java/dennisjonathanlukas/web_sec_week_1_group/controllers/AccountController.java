package dennisjonathanlukas.web_sec_week_1_group.controllers;

import dennisjonathanlukas.web_sec_week_1_group.model.Account;
import dennisjonathanlukas.web_sec_week_1_group.repositories.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
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
}
