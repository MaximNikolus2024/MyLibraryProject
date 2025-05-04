package org.mylibraryproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {
    @NotBlank(message = "First name is required and must be not blank")
    @Size(min = 3, max = 15, message = "First name length not correct")
    private String firstName;
    private String lastName;
    private String email;
    private String authorPassword;
}
