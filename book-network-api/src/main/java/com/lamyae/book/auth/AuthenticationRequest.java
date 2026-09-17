package com.lamyae.book.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
    @NotEmpty(message = "Email is mandatory")
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is not formatted ")
    private String email;
    @NotEmpty(message = "password is mandatory")
    @NotBlank(message = "pasword is mandatory")
    @Size(min = 8, message = "Passord should be 8 caracters long minimum")
    private String password;
}
