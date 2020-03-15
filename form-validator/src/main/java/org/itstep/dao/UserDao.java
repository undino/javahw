package org.itstep.dao;

import org.itstep.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Objects;

@Repository
public class UserDao implements Dao<User> {
    public static final Logger logger = LoggerFactory.getLogger(UserDao.class);
    private JdbcTemplate jdbcTemplate;
    private final String SAVE = "insert into users (login, password, email, phone_number, gender) values (?, ?, ?, ?, ?)";

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(User user) {
        logger.info("Into user dao {}", user);
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getPhone());
            ps.setString(5, user.getGender());
            return ps;
        }, holder);
        return Objects.requireNonNull(holder.getKey()).intValue();
    }
}
