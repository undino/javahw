package org.itstep.dto;

import lombok.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class GroupDto {

    private Integer id;

    @NonNull
    @NotBlank
    private String name;
}
