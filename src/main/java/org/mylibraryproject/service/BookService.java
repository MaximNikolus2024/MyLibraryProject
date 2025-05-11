package org.mylibraryproject.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mylibraryproject.dto.BookRequest;
import org.mylibraryproject.dto.BookResponse;
import org.mylibraryproject.entity.Author;
import org.mylibraryproject.entity.Book;
import org.mylibraryproject.repository.AuthorRepository;
import org.mylibraryproject.repository.BookRepository;
import org.mylibraryproject.service.util.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final Converter converter;

    @Transactional
    public BookResponse createBook(BookRequest bookRequest) {
        Author author = authorRepository.findByLastName(bookRequest.getAuthorName())
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Book book = converter.fromDto(bookRequest);
        book.setAuthor(author);
        Book savedBook = bookRepository.save(book);
        return converter.toDto(savedBook);
    }

    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(converter::toDto)
                .toList();
    }

    public Optional<BookResponse> getBookById(Integer id) {
        return bookRepository.findById(id).map(converter::toDto);
    }

    @Transactional
    public BookResponse updateBook(Integer id, BookRequest bookRequest) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(bookRequest.getTitle());
        book.setAuthor(authorRepository.findByLastName(bookRequest.getAuthorName())
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found")));
        // обновите другие поля по необходимости

        Book updatedBook = bookRepository.save(book);
        return converter.toDto(updatedBook);
    }

    @Transactional
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }


}
