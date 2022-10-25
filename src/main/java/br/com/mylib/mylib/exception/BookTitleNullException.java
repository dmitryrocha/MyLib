package br.com.mylib.mylib.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BookTitleNullException extends RuntimeException {

    public BookTitleNullException() {
        super("Título é um campo obrigatório");
    }
}
