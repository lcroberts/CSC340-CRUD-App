package com.csc340.CrudApp.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {
    @Autowired
    NamedParameterJdbcTemplate template;
}
