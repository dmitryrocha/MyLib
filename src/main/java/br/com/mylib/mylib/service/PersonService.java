package br.com.mylib.mylib.service;

import br.com.mylib.mylib.exception.PersonCpfNullException;
import br.com.mylib.mylib.exception.PersonNotFoundException;
import br.com.mylib.mylib.model.Person;
import br.com.mylib.mylib.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
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

    @Transactional
    public Person create(Person personCreate) {
        if(personCreate.getCpf() == null) {
            throw new PersonCpfNullException();
        }
        return repository.save(personCreate);
    }

    @Transactional
    public Person update(Long id, Person personCreate) {
        Date date = new Date();
        Person person = findById(id);
        person.setName(personCreate.getName());
        person.setPronoun(personCreate.getPronoun());
        person.setCpf(personCreate.getCpf());
        person.setAddress(personCreate.getAddress());
        person.setPhoneNumber(personCreate.getPhoneNumber());
        person.setEmail(personCreate.getEmail());
        person.setImgUrl(personCreate.getImgUrl());
        person.setUpdatedAt(date);

        return repository.save(person);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);;
    }
}
