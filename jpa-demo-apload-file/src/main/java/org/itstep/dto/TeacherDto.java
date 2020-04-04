package org.itstep.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class TeacherDto {
    private Integer id;

    @NonNull
    @NotBlank
    @Length(max = 50)
    private String firstName;

    @NonNull
    @NotBlank
    @Length(max = 50)
    private String lastName;

    private Set<Integer> groupsId;

    private List<String> groupsName;

    public TeacherDto(Integer id, String firstName, String lastName, List<String> groupsName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupsName = groupsName;
    }

    public TeacherDto(Integer id, String firstName, String lastName, Set<Integer> groupsId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupsId = groupsId;
    }


}
