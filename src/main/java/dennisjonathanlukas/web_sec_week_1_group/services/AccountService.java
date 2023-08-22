package dennisjonathanlukas.web_sec_week_1_group.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> getAccountByName(String name) {
        // Use JdbcTemplate to execute the query
        // THIS APPROACH IS VULNERABLE TO SQL INJECTION!
        String sql = "SELECT * FROM account WHERE user_name = '" + name + "'";
        return jdbcTemplate.queryForList(sql);
    }
}