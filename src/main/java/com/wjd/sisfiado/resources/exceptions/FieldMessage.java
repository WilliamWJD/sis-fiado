package com.wjd.sisfiado.resources.exceptions;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class FieldMessage {
    private String fieldName;
    private String message;
}
