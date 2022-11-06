package br.com.mylib.mylib.service;

import br.com.mylib.mylib.exception.PublisherCnpjNullException;
import br.com.mylib.mylib.exception.PublisherNotFoundException;
import br.com.mylib.mylib.model.Publishing;
import br.com.mylib.mylib.repository.PublishingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PublishingService {

    private final PublishingRepository repository;

    public PublishingService(PublishingRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Publishing findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PublisherNotFoundException(id));
    }

    @Transactional
    public List<Publishing> findAl() {
        return repository.findAll();
    }

    @Transactional
    public Publishing create(Publishing publishingCreate) {
        if(publishingCreate.getCnpj() == null) {
            throw new PublisherCnpjNullException();
        }
        return repository.save(publishingCreate);
    }

    @Transactional
    public Publishing update(Long id, Publishing publishingCreate) {
        Publishing publishing = findById(id);
        publishing.setName(publishingCreate.getName());
        publishing.setAddress(publishingCreate.getAddress());
        publishing.setCnpj(publishingCreate.getCnpj());
        publishing.setEmail(publishingCreate.getEmail());
        publishing.setNameContactPerson(publishingCreate.getNameContactPerson());
        publishing.setPhoneNumber(publishingCreate.getPhoneNumber());

        return repository.save(publishing);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
