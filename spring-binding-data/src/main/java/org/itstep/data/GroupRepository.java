package org.itstep.data;

import org.itstep.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Repository
public class GroupRepository implements Repository<Group, Integer> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GroupRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer save(Group data) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT groups (name) values (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, data.getName());
            return ps;
        }, holder);
        System.out.println(holder.getKey().intValue());
        return Objects.requireNonNull(holder.getKey().intValue());
    }

    @Override
    public void update(Group data) {
        jdbcTemplate.update("UPDATE `groups` SET name = ? WHERE id = ?", preparedStatement -> {
            preparedStatement.setString(1, data.getName());
            preparedStatement.setInt(2, data.getId());
        });
    }

    @Override
    public boolean delete(Group data) {
        boolean result = false;
        try {
            result = jdbcTemplate.update("DELETE FROM `groups` where id = ?", data.getId()) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Group> findAll() {
        return jdbcTemplate.query("SELECT * FROM groups",
                (rs, rowNum) -> new Group(rs.getInt(1), rs.getString(2)));
    }

    @Override
    public Group find(Integer integer) {
        return jdbcTemplate.queryForObject("SELECT * FROM groups WHERE id = ?",
                new Object[]{integer},
                new BeanPropertyRowMapper<>(Group.class));
    }
}
