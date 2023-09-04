package com.marcos.lazarte.ejercicio.service;

import com.marcos.lazarte.ejercicio.model.DTO.RequestLoginDTO;
import com.marcos.lazarte.ejercicio.model.DTO.RequestSignUpDTO;
import com.marcos.lazarte.ejercicio.model.DTO.ResponseLoginDTO;
import com.marcos.lazarte.ejercicio.model.DTO.ResponseSignUpDTO;

public interface IUserSerivce {

    public ResponseLoginDTO login(RequestLoginDTO login);

    public ResponseSignUpDTO signUp(RequestSignUpDTO signUp);
}