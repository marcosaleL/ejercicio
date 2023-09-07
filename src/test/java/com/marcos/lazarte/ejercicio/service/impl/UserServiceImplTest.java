package com.marcos.lazarte.ejercicio.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import com.marcos.lazarte.ejercicio.data.ServiceTestData;
import com.marcos.lazarte.ejercicio.exceptions.InternalServerErrorException;
import com.marcos.lazarte.ejercicio.model.DTO.ResponseLoginDTO;
import com.marcos.lazarte.ejercicio.model.DTO.ResponseSignUpDTO;
import com.marcos.lazarte.ejercicio.model.entities.UserEntity;
import com.marcos.lazarte.ejercicio.repository.IUserRepository;
import com.marcos.lazarte.ejercicio.security.JwtProvider;
import com.marcos.lazarte.ejercicio.security.PasswordSecurity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private IUserRepository userRepository;

    @Mock
    private JwtProvider jwtProvider;

    @Mock
    private PasswordSecurity passwordSecurity;

    @DisplayName("Test para comprobar que se retorne bien el usuario al momento de la creación")
    @Test
    void signUpTestOk() {
        UserEntity userTest = ServiceTestData.getUserEntity();
        ResponseSignUpDTO expectedResponseSignUp = ServiceTestData.getResponseSignUp();

        when(userRepository.existsByEmail(anyString())).thenReturn(Boolean.FALSE);
        when(passwordSecurity.passwordValidation(anyString())).thenReturn(Boolean.TRUE);
        when(userRepository.save(any(UserEntity.class))).thenReturn(userTest);

        ResponseSignUpDTO actualResponseSignUp = userService.signUp(ServiceTestData.getRequestSignUp());

        assertEquals(actualResponseSignUp, expectedResponseSignUp);
    }

    @DisplayName("Test para comprobar que se retorne bien el usuario al momento del login")
    @Test
    void loginTestOk() {
        UserEntity userTest = ServiceTestData.getUserEntity();
        ResponseLoginDTO expectedResponseLogin = ServiceTestData.getResponseLogin();

        when(userRepository.existsByEmail(anyString())).thenReturn(Boolean.TRUE);
        when(userRepository.findByEmail(anyString())).thenReturn(ServiceTestData.getUserEntity());
        when(passwordSecurity.verifyPassword(anyString(), anyString())).thenReturn(Boolean.TRUE);
        when(jwtProvider.validate(anyString())).thenReturn(Boolean.TRUE);
        when(userRepository.save(any(UserEntity.class))).thenReturn(userTest);
        ResponseLoginDTO actualResponseLogin = userService.login(ServiceTestData.getRequestLogin());

        assertEquals(actualResponseLogin, expectedResponseLogin);
    }

    @DisplayName("Test para comprobar que se lance la excepción cuando ya existe un usuario")
    @Test
    void getEmailExistTestFail() {

        when(userRepository.existsByEmail(anyString())).thenReturn(Boolean.TRUE);

        assertThrows(InternalServerErrorException.class, () -> {
            userService.signUp(ServiceTestData.getRequestSignUp());
        });
    }

    @DisplayName("Test para comprobar que se lance la excepción cuando no existe un usuario")
    @Test
    void getEmailNotExistTestFail() {

        when(userRepository.existsByEmail(anyString())).thenReturn(Boolean.FALSE);

        assertThrows(InternalServerErrorException.class, () -> {
            userService.login(ServiceTestData.getRequestLogin());
        });
    }

}
