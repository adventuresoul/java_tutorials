package com.spring.jdbc.repo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.models.Student;


@Component
public class StudentRepo {
   private JdbcTemplate template;

   @Autowired
   public void setTemplate(JdbcTemplate template) {
      this.template = template;
   }

   public JdbcTemplate getTemplate() {
      return template;
   }

   // ---------------------------------------------------- //
   public void save(Student stu) {
      String sql = "insert into student (id, name, tech) values (?, ?, ?)";

      int rows = template.update(sql, stu.getId(), stu.getName(), stu.getTech());

      System.out.printf("Rows affected: %d", rows);
      System.out.println();
   }
   
   public List<Student> findAll() {
      String sql = "select * from student";

      RowMapper<Student> mapper = new RowMapper<Student>() {
         @Override
         public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student stu = new Student();
            stu.setId(rs.getInt(1));
            stu.setName(rs.getString(2));
            stu.setTech(rs.getString(3));
            return stu;
         }
      };

      List<Student> res = template.query(sql, mapper);
            
      return res;
   }
}
