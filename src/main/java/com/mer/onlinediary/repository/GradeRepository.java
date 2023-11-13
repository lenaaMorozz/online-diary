package com.mer.onlinediary.repository;

import com.mer.onlinediary.dto.StudentWithAvgGradeDTO;
import com.mer.onlinediary.entity.Grade;
import com.mer.onlinediary.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
    @Query("select new com.mer.onlinediary.dto.StudentWithAvgGradeDTO(s.firstName, s.lastName, avg(gr.grade))" +
           "from Student s join Grade gr on gr.student.id = s.id " +
           "join Group gp on gp.id = s.group.id " +
           "where gp.id = :groupId " +
           "group by s.firstName, s.lastName")
    List<StudentWithAvgGradeDTO> getAvgGradesByGroup(@Param("groupId") int groupId);

    @Transactional
    @Modifying
    @Query("update Grade gr set gr.grade = :newGrade " +
           "where gr.student.id = :studentId and gr.subject.name = :subjectName")
    int updateGradeForSubjectByStudentId(@Param("newGrade") int newGrade,
                                          @Param("studentId") int studentId,
                                          @Param("subjectName") String subjectName);
}
