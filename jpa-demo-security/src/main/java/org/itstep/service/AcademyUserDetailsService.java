package org.itstep.service;

import org.itstep.domain.Student;
import org.itstep.domain.Teacher;
import org.itstep.repository.StudentRepository;
import org.itstep.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AcademyUserDetailsService implements UserDetailsService {

    @Autowired
    private final TeacherRepository teacherRepository;
    @Autowired
    private final StudentRepository studentRepository;

    public AcademyUserDetailsService(TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Student student = studentRepository.findByFirstName(username);
        Teacher teacher = teacherRepository.findByFirstName(username);

        if (student != null)
            return student;
        if (teacher != null)
            return teacher;
        return null;
    }
}

