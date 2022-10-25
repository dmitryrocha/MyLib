package br.com.mylib.mylib.mapper;

import br.com.mylib.mylib.dto.BookCreateDto;
import br.com.mylib.mylib.dto.BookDto;
import br.com.mylib.mylib.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public BookDto toBookDto(Book book) {
        return MODEL_MAPPER.map(book, BookDto.class);
    }

    public List<BookDto> toBookDtoList (List<Book> bookList) {
        return bookList.stream().map(this::toBookDto).collect(Collectors.toList());
    }

    public Book toBookCreate(BookCreateDto bookCreateDto) {
        return MODEL_MAPPER.map(bookCreateDto, Book.class);
    }
}
