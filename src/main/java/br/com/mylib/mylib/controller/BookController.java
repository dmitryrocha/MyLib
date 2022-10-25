package br.com.mylib.mylib.controller;

import br.com.mylib.mylib.dto.BookCreateDto;
import br.com.mylib.mylib.dto.BookDto;
import br.com.mylib.mylib.mapper.BookMapper;
import br.com.mylib.mylib.model.Book;
import br.com.mylib.mylib.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService service;
    private final BookMapper mapper;

    public BookController(BookService service, BookMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> findAll() {
        List<Book> bookList = service.findAll();
        return ResponseEntity.ok(mapper.toBookDtoList(bookList));
    }

    @GetMapping(";{id}")
    public ResponseEntity<BookDto> findById(@PathVariable Long id) {
        Book book = service.findById(id);
        return ResponseEntity.ok(mapper.toBookDto(book));
    }

    @PostMapping
    public ResponseEntity<BookDto> create(@RequestBody BookCreateDto bookCreateDto) {
        var bookCreate = mapper.toBookCreate(bookCreateDto);
        var book = service.create(bookCreate);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toBookDto(book));

    }

    @PostMapping("/{id}")
    public ResponseEntity<BookDto> update(@PathVariable Long id, @RequestBody BookCreateDto bookCreateDto) {
        var bookCreate = mapper.toBookCreate(bookCreateDto);
        var book = service.update(bookCreate.getId(), bookCreate);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toBookDto(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
