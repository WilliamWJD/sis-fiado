package com.wjd.sisfiado.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserOutputDto {
    private Long id;
    private String name;
    private String email;
    private String avatarUrl;
}
