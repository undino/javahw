package org.itstep.service;

import org.itstep.dto.GroupDto;
import org.itstep.dto.StudentDto;
import org.itstep.dto.TeacherDto;
import org.itstep.model.Group;
import org.itstep.model.Student;
import org.itstep.model.Teacher;
import org.itstep.repository.GroupRepository;
import org.itstep.repository.StudentRepository;
import org.itstep.repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AcademyServiceTest {

    @InjectMocks
    AcademyService academyService;

    @BeforeEach
    void setUp() {
        StudentRepository studentRepository = mock(StudentRepository.class);
        GroupRepository groupRepository = mock(GroupRepository.class);
        TeacherRepository teacherRepository = mock(TeacherRepository.class);
        academyService = new AcademyService(studentRepository, groupRepository, teacherRepository);

        List<Student> studentList = new ArrayList<>();
        Set<Teacher> teacherSet = new LinkedHashSet<>();
        Set<Group> groupSet = new LinkedHashSet<>();

        Group group = new Group(
                1,
                "Java",
                studentList,
                teacherSet
        );

        groupSet.add(group);

        Student student = new Student(
                1,
                "Bob",
                "Konti",
                LocalDate.of(1999, 1, 16),
                group
        );

        studentList.add(student);

        Teacher teacher = new Teacher(
                1,
                "Tomm",
                "Brelk",
                LocalDate.of(1979, 6, 12),
                groupSet
        );

        teacherSet.add(teacher);

        when(studentRepository.findById(1))
                .thenReturn(Optional.of(studentList.get(0)));

        when(groupRepository.findById(1))
                .thenReturn(Optional.of(groupSet
                        .stream()
                        .filter(g -> g.getId() == 1)
                        .findFirst()
                        .get()));

        when(teacherRepository.findById(1))
                .thenReturn(Optional.of(teacherSet
                        .stream()
                        .filter(t -> t.getId() == 1)
                        .findFirst()
                        .get()
                ));
    }

    @Test
    void getStudentDto() {
        StudentDto studentDto = academyService.getStudentDto(1);
        assertNotNull(studentDto);
        assertEquals(1, studentDto.getId());
        assertEquals("Bob", studentDto.getFirstName());
        assertEquals("Konti", studentDto.getLastName());
        assertEquals(LocalDate.of(1999, 1, 16), studentDto.getBirthDate());
        assertEquals(1, studentDto.getGroup());
        assertEquals("Java", studentDto.getGroupName());
        verify(academyService.studentRepository, times(1)).findById(1);
    }

    @Test
    void getGroupDto() {
        GroupDto groupDto = academyService.getGroupDto(1);
        assertNotNull(groupDto);
        assertEquals(1, groupDto.getId());
        assertEquals("Java", groupDto.getName());
        verify(academyService.groupRepository, times(1)).findById(1);
    }

    @Test
    void getTeacherDto() {
        TeacherDto teacherDto = academyService.getTeacherDto(1);
        assertNotNull(teacherDto);
        assertEquals(1, teacherDto.getId());
        assertEquals("Tomm", teacherDto.getFirstName());
        assertEquals("Brelk", teacherDto.getLastName());
        assertEquals(LocalDate.of(1979, 6, 12), teacherDto.getCareerStart());
        assertArrayEquals(new Integer[]{1}, teacherDto.getGroupId().toArray());
    }
}