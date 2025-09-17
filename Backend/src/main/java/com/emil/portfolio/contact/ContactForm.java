package com.emil.portfolio.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContactForm {

    @NotBlank(message = "First name is required!")
    @Size(max = 30, message = "First name is too long!")
    private String firstName;

    @NotBlank(message = "Last name is required!")
    @Size(max = 30, message = "Last name is too long!")
    private String lastName;

    @Size(max = 15, message = "Phone number is too long!")
    private String phoneNumber;

    @NotBlank(message = "Email is required!")
    @Email(message = "Email must be valid!")
    @Size(max = 80, message = "Email is too long!")
    private String email;

    @NotBlank(message = "You must leave a message!")
    @Size(max = 3000, message = "Message can only be 3000 characters long!")
    private String message;

}
