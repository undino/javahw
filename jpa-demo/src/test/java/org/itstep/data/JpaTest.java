package org.itstep.data;

import org.itstep.model.Group;
import org.itstep.model.Student;
import org.itstep.service.AcademyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringJUnitWebConfig(locations = "classpath:spring-jdbc.xml")
public class JpaTest {

    @Autowired
    AcademyService academyService;

    @PersistenceContext
    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    void insertStudentWithGroup() {
        assertNotNull(academyService);
        Group group = new Group("Java spring 2019");
        // save
        Student student = new Student("Вася", "Пупкин", LocalDate.of(2000, 1,1), group);
        group.setStudents(List.of(student));
        // save group
        academyService.save(group);
        // save student
        Integer id = academyService.save(student);

        // read
        // read student
        student = academyService.getStudent(id);
        assertEquals("Вася", student.getFirstName());
        assertEquals("Пупкин", student.getLastName());
        assertEquals(LocalDate.of(2000, 1,1), student.getBirthDate());
        assertNotNull(student.getGroup());
        assertEquals("Java spring 2019", student.getGroup().getName());

        // read group
        group = academyService.getGroup(group.getId());
        assertNotNull(group);
        assertEquals("Java spring 2019", group.getName());
        assertNotNull(group.getStudents());
        assertEquals(1, group.getStudents().size());
        assertEquals("Вася", group.getStudents().get(0).getFirstName());
        assertEquals("Пупкин", group.getStudents().get(0).getLastName());
        assertEquals(LocalDate.of(2000, 1,1), group.getStudents().get(0).getBirthDate());
    }
}
