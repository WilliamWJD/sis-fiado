package com.wjd.sisfiado.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserInputDto {
    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String name;

    @Email(message = "Favor entrar com um e-mail válido")
    private String email;

    @Size(min = 6, max = 15, message = "Deve ter entre 6 e 15 caracteres")
    private String password;

    private String avatarUrl;
}
