package org.mylibraryproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
    private String title;
    private String bookDescription;
    private String status;
    private AuthorResponse authorResponse;
}
