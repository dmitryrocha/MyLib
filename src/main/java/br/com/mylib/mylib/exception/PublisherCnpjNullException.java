package br.com.mylib.mylib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PublisherCnpjNullException extends RuntimeException{

    public PublisherCnpjNullException() {
        super("CNPJ é um campo obrigatório");
    }
}
