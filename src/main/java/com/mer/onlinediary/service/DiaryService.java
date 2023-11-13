package com.mer.onlinediary.service;

import com.mer.onlinediary.dto.GradeModificationDTO;
import com.mer.onlinediary.dto.StudentCreationDTO;
import com.mer.onlinediary.dto.StudentWithAvgGradeDTO;
import java.util.List;

public interface DiaryService {
    List<StudentWithAvgGradeDTO> getAvgGradesByGroup(int groupId);
    int updateGradeForSubjectByStudentId(GradeModificationDTO dto);

    void createStudent(StudentCreationDTO dto);
}
