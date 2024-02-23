package it.epicode.gestioneeventi.modelRequest;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EventoRequest {
    @NotBlank(message = "titolo obbligatorio")
    private String titolo;
    @NotBlank(message = "luogo obbligatorio")
    private String luogo;
    @NotBlank(message = "data obbligatorio")
    private LocalDate data;
    private String descrizione;
    private int numeroPosti;
}
