package org.itstep.model;

import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.itstep.enums.IsWarden;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @NotBlank
    private String firstName;

    @NotBlank
    @NonNull
    private String lastName;

    @Range(min = 8, max = 60)
    @NonNull
    private int age;

    @NotBlank
    @NonNull
    @Column(name = "groups", nullable = false, length = 50)
    private String group;

    @Past
    @NonNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "berth_day")
    private LocalDate birthDate;

    private IsWarden isWarden = IsWarden.NON;

    private double score;
}
