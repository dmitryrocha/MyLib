package br.com.mylib.mylib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PublisherNotFoundException extends RuntimeException{
    public PublisherNotFoundException(Long id) {
        super("Editora não encontrada utilizando o id: " + id);
    }
}
