package br.com.mylib.mylib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(Long id) {
        super("Usuário não encontrado utilizando o id: "+ id);
    }
}
