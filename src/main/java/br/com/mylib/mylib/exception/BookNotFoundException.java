package br.com.mylib.mylib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super("Livro não encontrado no id: " + id);
    }
}
