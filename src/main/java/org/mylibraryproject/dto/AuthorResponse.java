package org.mylibraryproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorResponse {

    private String firstName;
    private String lastName;
    private String aboutAuthor;
    private String email;

}
