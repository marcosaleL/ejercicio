package com.marcos.lazarte.ejercicio.service;

import com.marcos.lazarte.ejercicio.model.DTO.RequestLoginDTO;
import com.marcos.lazarte.ejercicio.model.DTO.RequestSignUpDTO;
import com.marcos.lazarte.ejercicio.model.DTO.ResponseLoginDTO;
import com.marcos.lazarte.ejercicio.model.DTO.ResponseSignUpDTO;

public interface IUserService {

    public ResponseLoginDTO login(RequestLoginDTO requestLoginDTO);

    public ResponseSignUpDTO signUp(RequestSignUpDTO requestSignUpDTO);
}