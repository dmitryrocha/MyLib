package br.com.mylib.mylib.controller;

import br.com.mylib.mylib.dto.PersonDto;
import br.com.mylib.mylib.mapper.PersonMapper;
import br.com.mylib.mylib.model.Person;
import br.com.mylib.mylib.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;
    private final PersonMapper mapper;

    public PersonController(PersonService service, PersonMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAll() {
        List<Person> personList = service.findAll();
        return ResponseEntity.ok(mapper.toPersonDtoList(personList));
    }
}
