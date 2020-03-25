package org.itstep.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Table(name = "teacher")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @NotBlank
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "creer_start", nullable = false)
    private LocalDate careerStart;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_group",
            joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id")
    )
    private Set<Group> groups;


    public Teacher(String firstName, String lastName, LocalDate careerStart, Set<Group> groupSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.careerStart = careerStart;
        this.groups = groupSet;
    }
}
