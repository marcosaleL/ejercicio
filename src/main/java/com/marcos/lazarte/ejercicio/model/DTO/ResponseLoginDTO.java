package com.marcos.lazarte.ejercicio.model.DTO;

import com.marcos.lazarte.ejercicio.model.entities.PhoneEntity;
import com.marcos.lazarte.ejercicio.model.entities.UserEntity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseLoginDTO {

    private Long userId;
    private String created;
    private String lastLogin;
    private String token;
    private boolean isActive;
    private String name;
    private String email;
    private String password;
    private List<PhoneEntity> phones;

    public ResponseLoginDTO(UserEntity user) {
        this.userId = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.phones = user.getPhones();
        this.created = user.getCreated();
        this.lastLogin = user.getLastLogin();
        this.isActive = true;
    }

}