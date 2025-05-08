package org.mylibraryproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mylibraryproject.entity.Book;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
    private String title;
    private String bookDescription;
    private Book.Status status;
    private AuthorResponse authorResponse;
}
