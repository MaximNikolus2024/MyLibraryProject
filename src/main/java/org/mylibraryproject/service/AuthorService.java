package org.mylibraryproject.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mylibraryproject.dto.AuthorRequest;
import org.mylibraryproject.dto.AuthorResponse;
import org.mylibraryproject.entity.Author;
import org.mylibraryproject.repository.AuthorRepository;
import org.mylibraryproject.service.exception.AlreadyExistsException;
import org.mylibraryproject.service.util.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final Converter converter;
    @Transactional
    public AuthorResponse createAuthor(AuthorRequest authorRequest) {
        if (authorRepository.existsByEmail(authorRequest.getEmail())) {
            throw new AlreadyExistsException("Email already exists");
        }
        Author author = converter.fromDto(authorRequest);
        Author savedAuthor = authorRepository.save(author);
        return converter.toDto(savedAuthor);
    }

    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(converter::toDto)
                .toList();
    }

    public Optional<AuthorResponse> getAuthorById(Integer id) {
        return authorRepository.findById(id).map(converter::toDto);
    }

    @Transactional
    public AuthorResponse updateAuthor(Integer id, AuthorRequest authorRequest) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        if (authorRepository.existsByEmail(authorRequest.getEmail()) &&
                !author.getEmail().equals(authorRequest.getEmail())) {
            throw new AlreadyExistsException("Email already exists");
        }

        author.setFirstName(authorRequest.getFirstName());
        author.setLastName(authorRequest.getLastName());
        author.setEmail(authorRequest.getEmail());
        // обновите другие поля по необходимости

        Author updatedAuthor = authorRepository.save(author);
        return converter.toDto(updatedAuthor);
    }

    @Transactional
    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }


}
