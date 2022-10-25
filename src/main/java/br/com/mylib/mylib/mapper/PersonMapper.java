package br.com.mylib.mylib.mapper;

import br.com.mylib.mylib.dto.PersonDto;
import br.com.mylib.mylib.model.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public PersonDto toPersonDto(Person person) {
        return MODEL_MAPPER.map(person, PersonDto.class);
    }

    public Person toPerson(PersonDto personDto) {
        return MODEL_MAPPER.map(personDto, Person.class);
    }

    public Person toPersonCreate(PersonDto personDto) {
        return MODEL_MAPPER.map(personDto, Person.class);
    }

    public List<PersonDto> toPersonDtoList(List<Person> personList) {
        return personList.stream().map(this::toPersonDto).collect(Collectors.toList());
    }
}
