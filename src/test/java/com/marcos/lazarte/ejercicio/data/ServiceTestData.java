package com.marcos.lazarte.ejercicio.data;

import com.marcos.lazarte.ejercicio.model.DTO.RequestLoginDTO;
import com.marcos.lazarte.ejercicio.model.DTO.RequestSignUpDTO;
import com.marcos.lazarte.ejercicio.model.DTO.ResponseLoginDTO;
import com.marcos.lazarte.ejercicio.model.DTO.ResponseSignUpDTO;
import com.marcos.lazarte.ejercicio.model.entities.UserEntity;

public final class ServiceTestData {

    private static RequestSignUpDTO requestSingUp = RequestSignUpDTO.builder()
        .name("marcos").email("marcos@github.com").password("a2asfGfdfdf4").build();

    private static RequestLoginDTO requestLogin = RequestLoginDTO.builder()
        .email("marcos@github.com").password("a2asfGfdfdf4").token("blablablablabla").build();

    private ServiceTestData() {

    }

    public static RequestSignUpDTO getRequestSignUp() {
        return requestSingUp;
    }

    public static UserEntity getUserEntity() {
        return new UserEntity(requestSingUp);
    }

    public static ResponseSignUpDTO getResponseSignUp() {
        return new ResponseSignUpDTO(getUserEntity());
    }

    public static RequestLoginDTO getRequestLogin() {
        return requestLogin;
    }

    public static ResponseLoginDTO getResponseLogin() {
        return new ResponseLoginDTO(getUserEntity());
    }

}