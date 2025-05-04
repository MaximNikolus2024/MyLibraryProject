package org.mylibraryproject.service.util;

import org.mylibraryproject.dto.AuthorRequest;
import org.mylibraryproject.dto.AuthorResponse;
import org.mylibraryproject.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class Converter {
public Author fromDto(AuthorRequest request) {
    return Author.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .authorPassword(request.getAuthorPassword())
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

public List<AuthorResponse> fromAuthors(List<Author> authors) {
    return authors.stream().map(author -> toDto(author)).toList();
}
}
