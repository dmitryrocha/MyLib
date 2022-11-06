package br.com.mylib.mylib.controller;

import br.com.mylib.mylib.dto.PersonCreateDto;
import br.com.mylib.mylib.dto.PersonDto;
import br.com.mylib.mylib.mapper.PersonMapper;
import br.com.mylib.mylib.model.Person;
import br.com.mylib.mylib.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable Long id) {
        Person person = service.findById(id);
        return ResponseEntity.ok(mapper.toPersonDto(person));
    }

    @PostMapping
    public ResponseEntity<PersonDto> create(@RequestBody PersonCreateDto personCreateDto) {
        var personCreate = mapper.toPersonCreate(personCreateDto);
        var person = service.create(personCreate);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toPersonDto(person));
    }

    @PostMapping("/{id}")
    public ResponseEntity<PersonDto> update(@PathVariable Long id, @RequestBody PersonCreateDto personCreateDto) {
        var personCreate = mapper.toPersonCreate(personCreateDto);
        var person = service.update(id, personCreate);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toPersonDto(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
