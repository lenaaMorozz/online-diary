package com.mer.onlinediary.service;

import com.mer.onlinediary.dto.GradeModificationDTO;
import com.mer.onlinediary.dto.StudentCreationDTO;
import com.mer.onlinediary.dto.StudentWithAvgGradeDTO;
import com.mer.onlinediary.entity.Group;
import com.mer.onlinediary.entity.Student;
import com.mer.onlinediary.repository.GradeRepository;
import com.mer.onlinediary.repository.GroupRepository;
import com.mer.onlinediary.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaryServiceImpl implements DiaryService {
    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;
    private final GroupRepository groupRepository;

    public List<StudentWithAvgGradeDTO> getAvgGradesByGroup(int groupId) {
        return gradeRepository.getAvgGradesByGroup(groupId);
    }

    public int updateGradeForSubjectByStudentId(GradeModificationDTO dto) {

        return gradeRepository.updateGradeForSubjectByStudentId(dto.getNewGrade(),
                dto.getStudentId(),
                dto.getSubjectName());
    }

    @Override
    public void createStudent(StudentCreationDTO dto) {
        studentRepository.save(Student.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .group(groupRepository.getReferenceById(dto.getGroup()))
                .build());
    }
}
