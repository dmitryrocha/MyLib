package br.com.mylib.mylib.service;

import br.com.mylib.mylib.exception.BookNotFoundException;
import br.com.mylib.mylib.exception.BookTitleNullException;
import br.com.mylib.mylib.model.Book;
import br.com.mylib.mylib.model.GenreEnum;
import br.com.mylib.mylib.model.Publishing;
import br.com.mylib.mylib.model.Reader;
import br.com.mylib.mylib.repository.BookRepository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly =true)
    public Book findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Transactional
    public Book create(Book bookCreate) {
        if(bookCreate.getTitle() == null)
            throw new BookTitleNullException();
        return repository.save(bookCreate);
    }

    @Transactional
    public Book update(Long id, Book bookCreate) {
        Book book = findById(id);
        book.setTitle(bookCreate.getTitle());
        book.setAuthor(bookCreate.getAuthor());
        book.setEdition(bookCreate.getEdition());
        book.setCode(bookCreate.getCode());
        book.setGenre(bookCreate.getGenre());
        book.setImgUrl(bookCreate.getImgUrl());

        return repository.save(book);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
