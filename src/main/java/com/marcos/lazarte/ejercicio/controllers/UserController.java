package com.marcos.lazarte.ejercicio.controllers;

import com.marcos.lazarte.ejercicio.model.DTO.RequestLoginDTO;
import com.marcos.lazarte.ejercicio.model.DTO.RequestSignUpDTO;
import com.marcos.lazarte.ejercicio.model.DTO.ResponseLoginDTO;
import com.marcos.lazarte.ejercicio.model.DTO.ResponseSignUpDTO;
import com.marcos.lazarte.ejercicio.service.IUserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<ResponseLoginDTO> login(@Valid @RequestBody RequestLoginDTO requestLoginDTO){
        return new ResponseEntity<>(userService.login(requestLoginDTO), HttpStatus.OK);
    }

    @PostMapping("/signUp")
    public ResponseEntity<ResponseSignUpDTO> singUp(@Valid @RequestBody RequestSignUpDTO requestSignUpDTO){
        return new ResponseEntity<>(userService.signUp(requestSignUpDTO), HttpStatus.OK);
    }

}