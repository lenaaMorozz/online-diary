package com.mer.onlinediary.service;

import com.mer.onlinediary.dto.GradeModificationDTO;
import com.mer.onlinediary.dto.StudentWithAvgGradeDTO;
import java.util.List;

public interface DiaryService {
    List<StudentWithAvgGradeDTO> getAvgGradesByGroup(int groupId);
    void updateGradeForSubjectByStudentId(GradeModificationDTO dto);
}
