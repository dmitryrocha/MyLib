package br.com.mylib.mylib.service;

import br.com.mylib.mylib.exception.PersonNotFoundException;
import br.com.mylib.mylib.model.Person;
import br.com.mylib.mylib.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Person findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @Transactional
    public List<Person> findAll() {
        return repository.findAll();
    }
}
