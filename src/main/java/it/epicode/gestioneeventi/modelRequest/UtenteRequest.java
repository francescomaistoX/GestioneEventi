package it.epicode.gestioneeventi.modelRequest;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UtenteRequest {
    @NotBlank(message = "nome obbligatorio")
    private String nome;
    @NotBlank(message = "username obbligatorio")
    private String userName;
    @NotBlank(message = "password obbligatorio")
    private String password;
}
