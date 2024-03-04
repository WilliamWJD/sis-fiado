package com.wjd.sisfiado.domain;

import jakarta.persistence.*;
import lombok.*;
@Entity(name = "tbl_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    private String avatarUrl;
}
