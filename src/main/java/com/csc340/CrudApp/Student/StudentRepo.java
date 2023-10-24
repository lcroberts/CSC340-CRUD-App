package com.csc340.CrudApp.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepo {
    @Autowired
    NamedParameterJdbcTemplate template;

    List<Student> findAll() {
        String query = "select id, name, email from student";
        return template.query(query,
                (result, rowNum)
                        -> new Student(result.getLong("id"),
                        result.getString("name"),
                        result.getString("email")));
    }

    public Student getStudentById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        String query = "select * from student where id=:id ";
        return template.queryForObject(query, namedParameters, BeanPropertyRowMapper.newInstance(Student.class));
    }

    public int saveStudent(Student student) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", student.getName());
        paramMap.put("email", student.getEmail());
        String query = "INSERT INTO student(name,email) VALUES(:name, :email)";
        return template.update(query, paramMap);
    }

    void deleteStudentById(long id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        String query = "delete from student where id=:id";
        template.update(query, namedParameters);
    }

    void updateStudent(Student student) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", student.getId());
        paramMap.put("name", student.getName());
        paramMap.put("email", student.getEmail());
        String query = "update student set name=:name, email=:email where id=:id";
        template.update(query, paramMap);
    }
}
