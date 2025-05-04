package org.mylibraryproject.repository;

import org.mylibraryproject.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    boolean existsByEmail(String email);

    Optional<Author> findByEmail(String email);
    List<Author> findByLastName(String lastName);
}
