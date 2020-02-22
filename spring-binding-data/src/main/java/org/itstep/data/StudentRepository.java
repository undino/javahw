package org.itstep.data;

import org.itstep.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class StudentRepository implements org.itstep.data.Repository<Student, Integer> {

    //private final static List<Student> storage = new CopyOnWriteArrayList<>();

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer save(Student data) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps =
                    con.prepareStatement("insert into students(first_name, last_name, age, group_id) values(?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, data.getFirstName());
            ps.setString(2, data.getLastName());
            ps.setInt(3, data.getAge());
            ps.setInt(4, data.getGroup());
            return ps;
        }, holder);
        return Objects.requireNonNull(holder.getKey()).intValue();
    }

    @Override
    public void update(Student data) {
        jdbcTemplate.update("UPDATE students SET first_name = ?, last_name = ?, age = ?, group_id = ? WHERE id = ?", preparedStatement -> {
            preparedStatement.setString(1, data.getFirstName());
            preparedStatement.setString(2, data.getLastName());
            preparedStatement.setInt(3, data.getAge());
            preparedStatement.setInt(4, data.getGroup());
            preparedStatement.setInt(5, data.getId());
        });
    }

    @Override
    public boolean delete(Student data) {
        return jdbcTemplate.update("DELETE FROM students WHERE id = ?", data.getId()) > 0;
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("select id, first_name, last_name, age, group_id from students",
                (rs, rowNum) -> new Student(rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age"),
                        rs.getInt("group_id")));
    }

    @Override
    public Student find(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM students WHERE id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Student.class));
    }
}
