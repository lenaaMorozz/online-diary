package com.mer.onlinediary.service;

import com.mer.onlinediary.dto.StudentWithAvgGradeDTO;
import com.mer.onlinediary.repository.GradeRepository;
import com.mer.onlinediary.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryRepositoryImpl implements DiaryService{
    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;

    public List<StudentWithAvgGradeDTO> getAvgGradesByGroup(int groupId) {
        return gradeRepository.getAvgGradesByGroup(groupId);
    }
}
