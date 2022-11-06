package br.com.mylib.mylib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PersonCpfNullException extends RuntimeException{

    public PersonCpfNullException() {
        super("CPF é um campo obrigatório");
    }
}
