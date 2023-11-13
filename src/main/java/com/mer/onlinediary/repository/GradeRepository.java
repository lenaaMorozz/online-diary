package com.mer.onlinediary.repository;

import com.mer.onlinediary.dto.StudentWithAvgGradeDTO;
import com.mer.onlinediary.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
    @Query("select new com.mer.onlinediary.dto.StudentWithAvgGradeDTO(s.firstName, s.lastName, avg(gr.grade))" +
           "from Student s join Grade gr on gr.student.id = s.id " +
           "join Group gp on gp.id = s.group.id " +
           "where gp.id = :groupId " +
           "group by s.firstName, s.lastName")
    List<StudentWithAvgGradeDTO> getAvgGradesByGroup(@Param("groupId") int groupId);
}
