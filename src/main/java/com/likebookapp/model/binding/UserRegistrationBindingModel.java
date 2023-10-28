package com.likebookapp.model.binding;


import com.likebookapp.util.FieldMath;
import com.likebookapp.util.UniqueEmail;
import com.likebookapp.util.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@FieldMath(
        first = "password",
        second = "confirmPassword",
        message = "Passwords do not match."
)

public class UserRegistrationBindingModel {
    @NotNull
    @Size(min =3, max = 20,message = "Username length must be between 3 and 20 characters!")
    @UniqueUsername(message = "Username should be unique and not taken.")
    private String username;
    @NotNull
    @Size(min =3, max = 20,message = "Password length must be between 3 and 20 characters!")
    private String password;
    @NotNull
    @Size(min =3, max = 20,message = "Password length must be between 3 and 20 characters!")
    private String confirmPassword;
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid.")
    @UniqueEmail(message = "Email should be unique and not taken.")
    private String email;

    public UserRegistrationBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
