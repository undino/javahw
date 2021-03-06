package org.itstep.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.io.File;
import java.time.LocalDate;

@Table(name = "students")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @NotBlank
    @Length(max = 50)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank
    @NonNull
    @Length(max = 50)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "avatar_path")
    private String avatar;// = "default.jpg";

    @Past
    @NonNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_fk", nullable = false) // поле для внешнего ключа
    private Group group;

    public Student(String firstName, String lastName, LocalDate birthDate, String avatar, Group g) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.avatar = avatar;
        this.group = g;
    }
}
