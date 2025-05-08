package org.mylibraryproject.service.util;

import org.mylibraryproject.dto.AuthorRequest;
import org.mylibraryproject.dto.AuthorResponse;
import org.mylibraryproject.dto.BookRequest;
import org.mylibraryproject.dto.BookResponse;
import org.mylibraryproject.entity.Author;
import org.mylibraryproject.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Converter {

    public Book fromDto(BookRequest dto) {
        return Book.builder()
                .title(dto.getTitle())
                .genre(dto.getGenre())

                .author(Author.builder().firstName(dto.getAuthorName()).build())
                .build();
    }

    public BookResponse toDto(Book book) {
        Author author = book.getAuthor();

        AuthorResponse authorResponse = AuthorResponse.builder()
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .aboutAuthor(author.getAboutAuthor())
                .email(author.getEmail())
                .build();

        return BookResponse.builder()
                .title(book.getTitle())
                .bookDescription(book.getBookDescription())
                .status(book.getStatus())
                .authorResponse(authorResponse)
                .build();
    }

    public Author fromDto(AuthorRequest dto) {
        return Author.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .authorPassword(dto.getAuthorPassword())
                .build();
    }

    public AuthorResponse toDto(Author author) {
        return AuthorResponse.builder()
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .aboutAuthor(author.getAboutAuthor())
                .email(author.getEmail())
                .build();
    }
}

