package org.mylibraryproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Book {
    public enum Genre {
        FANTASY,
        SCIENCEFICTION,
        SPORT,
        BUSINESS,
        COMEDY,
        MYSTERY,
        HORROR
    }
    public enum Status {
        AVAILABLE,
        CHECHEDOUT,
        INPROCESSING,
        ARCHIVED
    }
    @NotBlank(message = "Title must be not blank")
    @Size(min = 5,max = 50)
    private  String title;
    @NotBlank(message = "Book description must be not blank")
    @Column(nullable = false)
    private String bookDescription;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Author author;

}
