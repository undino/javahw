package org.itstep.data;

import org.itstep.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.transaction.annotation.Transactional;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Repository
@Transactional
public class GroupRepository implements Repository<Group, Integer> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GroupRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Integer save(Group data) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        int i = jdbcTemplate.queryForObject("select  count(*) from `groups` where name = ?", new Object[]{data.getName()}, Integer.class);

        if (i == 0) {
            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement("INSERT INTO groups (name) values (?)", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, data.getName());
                return ps;
            }, holder);
            return Objects.requireNonNull(holder.getKey()).intValue();
        } else {
            return 0;
        }
    }


    @Override
    @Transactional
    public void update(Group data) {
        jdbcTemplate.update("UPDATE `groups` SET name = ? WHERE id = ?", preparedStatement -> {
            preparedStatement.setString(1, data.getName());
            preparedStatement.setInt(2, data.getId());
        });
    }

    @Override
    @Transactional
    public boolean delete(Group data) {
        boolean result = false;
        try {
            result = jdbcTemplate.update("DELETE FROM `groups` where id = ?", data.getId()) > 0;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public List<Group> findAll() {
        return jdbcTemplate.query("SELECT * FROM groups",
                (rs, rowNum) -> new Group(rs.getInt(1), rs.getString(2)));
    }

    @Override
    @Transactional
    public Group find(Integer integer) {
        return jdbcTemplate.queryForObject("SELECT * FROM groups WHERE id = ?",
                new Object[]{integer},
                new BeanPropertyRowMapper<>(Group.class));
    }
}
