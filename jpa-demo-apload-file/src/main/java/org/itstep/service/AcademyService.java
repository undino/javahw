package org.itstep.service;

import lombok.extern.slf4j.Slf4j;
import org.itstep.dto.GroupDto;
import org.itstep.dto.StudentDto;
import org.itstep.dto.TeacherDto;
import org.itstep.model.Group;
import org.itstep.model.Student;
import org.itstep.model.Teacher;
import org.itstep.repository.GroupRepository;
import org.itstep.repository.StudentRepository;
import org.itstep.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class AcademyService {

    final StudentRepository studentRepository;
    final GroupRepository groupRepository;
    final TeacherRepository teacherRepository;

    @Autowired
    public AcademyService(StudentRepository studentRepository, GroupRepository groupRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.teacherRepository = teacherRepository;
    }

    @Transactional(readOnly = true)
    public List<Student> findStudents() {
        return studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<StudentDto> findStudentsDto(int pageNumber, int size) {
        Page<Student> page = studentRepository.findAll(PageRequest.of(pageNumber, size));
        return page.getContent()
                .stream()
                .map(s -> new StudentDto(
                        s.getId(),
                        s.getFirstName(),
                        s.getLastName(),
                        s.getBirthDate(),
                        s.getAvatar(),
                        s.getGroup().getId(),
                        s.getGroup().getName()))
                .collect(Collectors.toList());

//        studentRepository.findAll().stream();
//                .map(s -> new StudentDto(s.getId(), s.getFirstName(), s.getLastName(), s.getBirthDate(),
//                        s.getGroup().getId(), s.getGroup().getName()))
//                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Student getStudent(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Integer save(Student student) {
        return studentRepository.saveAndFlush(student).getId();
    }

    public void update(Student student) {
        studentRepository.save(student);
    }

    public boolean delete(Integer id) {
        studentRepository.deleteById(id);
        return true;
    }

    @Transactional(readOnly = true)
    public Group getGroup(Integer id) {
        return groupRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Group> findGroups() {
        return groupRepository.findAll();
    }

    public Integer save(Group group) {
        return groupRepository.saveAndFlush(group).getId();
    }

    public void saveAll(List<Group> groups) {
        for (Group g : groups) {
            save(g);
        }
    }

    public void update(Group group) {
        groupRepository.save(group);
    }

    public boolean deleteGroup(int id) {
        groupRepository.deleteById(id);
        return true;
    }

    public void save(StudentDto s) {
        Group g = groupRepository.findById(s.getGroupId()).orElse(null);
        Student student = new Student(s.getFirstName(), s.getLastName(), s.getBirthDate(), s.getAvatar(), g);
        save(student);
    }

    public void update(StudentDto studentDto) {
        save(new Student(studentDto.getId(), studentDto.getFirstName(), studentDto.getLastName(), studentDto.getAvatar(), studentDto.getBirthDate(),
                getGroup(studentDto.getGroupId())));
    }

    public List<GroupDto> findGroupsDto(int pageNumber, int size) {
        Page<Group> page = groupRepository.findAll(PageRequest.of(pageNumber, size));
//        Pageable pageable = page.nextPageable();


//        log.warn("page.getTotalPages() = " + page.getTotalPages());
//        log.warn("page.getSize() = " + page.getSize());
//        log.warn("page.hasNext() = " + page.hasNext());
//        log.warn("page.isLast() = " + page.isLast());
//        log.warn("page.getNumber() = " + page.getNumber());
//        log.warn("page.getNumberOfElements() = " + page.getNumberOfElements());
//        log.warn("page.getPageable()= " + page.getPageable());


        return page.getContent().stream().map(g -> new GroupDto(g.getId(), g.getName()))
                .collect(Collectors.toList());

//        return groupRepository.findAll((Pageable) page)
//                .stream().map(g -> new GroupDto(g.getId(), g.getName()))
//                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public StudentDto getStudentDto(int id) {
        Student student = getStudent(id);
        log.debug(student.toString());
        return new StudentDto(student.getId(), student.getFirstName(), student.getLastName(), student.getBirthDate(), student.getAvatar(),
                student.getGroup().getId(), student.getGroup().getName());

    }

    public GroupDto getGroupDto(int id) {
        Group group = getGroup(id);
        return new GroupDto(group.getId(), group.getName());
    }

    public void update(GroupDto groupDto) {
        Group g = getGroup(groupDto.getId());
        g.setName(groupDto.getName());
        save(g);
    }

    public void save(GroupDto groupDto) {
        save(new Group(groupDto.getName()));
    }


    //TEACHER
    public Integer save(Teacher teacher) {
        return teacherRepository.saveAndFlush(teacher).getId();
    }

    public void save(TeacherDto teacherDto) {
        List<Group> groups = new ArrayList<>();

        for (Integer i : teacherDto.getGroupsId()) {
            System.out.println("i = " + i);
            groups.add(getGroup(i));
        }

        save(new Teacher(teacherDto.getId(), teacherDto.getFirstName(), teacherDto.getLastName(), groups));

    }

    @Transactional
    public Teacher getTeacher(int id) {
        return teacherRepository.findById(id).orElse(null);
    }


    public boolean deleteTeacher(int id) {
        teacherRepository.deleteById(id);
        return true;
    }

    public TeacherDto getTeacherDto(int id) {
        Teacher t = getTeacher(id);
        return new TeacherDto(t.getId(),
                t.getFirstName(),
                t.getLastName(),
                t.getGroups()
                        .stream()
                        .map(Group::getId)
                        .collect(Collectors.toSet()));
    }

    public void update(TeacherDto teacherDto) {
        List<Group> groupSet = new ArrayList<>();

        for (Integer i : teacherDto.getGroupsId())
            groupSet.add(getGroup(i));
        teacherRepository.
                save(new Teacher(teacherDto.getId(),
                        teacherDto.getFirstName(),
                        teacherDto.getLastName(),
                        groupSet));

    }

    public List<TeacherDto> findAllTeachers(int pageNumber, int size) {
        Page<Teacher> teacherPage = teacherRepository.findAll(PageRequest.of(pageNumber, size));
        return teacherPage.getContent()
                .stream()
                .map(t -> new TeacherDto(
                        t.getId(),
                        t.getFirstName(),
                        t.getLastName(),
                        t.getGroups()
                                .stream()
                                .map(Group::getName)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());

    }

    public long countGroups() {
        return groupRepository.count();
    }

    public long countStudents() {
        return studentRepository.count();
    }

    public long countTeacher() {
        return teacherRepository.count();
    }

    public List<Group> searchGroups(String text) {
        return groupRepository.findAllByNameContainsIgnoreCase(text);
    }
}
