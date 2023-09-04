package com.marcos.lazarte.ejercicio.model.DTO;

import com.marcos.lazarte.ejercicio.model.entities.PhoneEntity;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestSignUpDTO {

    private String name;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email it has to be valid")
    private String email;

    @NotEmpty(message = "Password must not be empty")
    private String password;

    private List<PhoneEntity> phones;
}