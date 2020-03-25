package org.itstep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class TeacherDto {


    private Integer id;
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    @NotNull
    private String lastName;
    @NotBlank
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate careerStart;

    private Set<Integer> groupId;

    private List<String> groupsName;

    public TeacherDto(Integer id, String firstName, String lastName, LocalDate careerStart, List<String> groupsName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.careerStart = careerStart;
        this.groupsName = groupsName;
    }

    @Override
    public String toString() {
        return "TeacherDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", careerStart=" + careerStart +
                ", groupId=" + groupId +
                ", groupsName=" + groupsName +
                '}';
    }
}