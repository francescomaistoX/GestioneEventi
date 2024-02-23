package it.epicode.gestioneeventi.modelRequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "username obbligatoria")
    private String userName;
    @NotBlank(message = "password obbligatorio")
    private String password;
}
