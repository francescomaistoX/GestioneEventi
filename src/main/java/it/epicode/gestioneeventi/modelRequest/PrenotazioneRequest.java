package it.epicode.gestioneeventi.modelRequest;

import it.epicode.gestioneeventi.model.Evento;
import it.epicode.gestioneeventi.model.Utente;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PrenotazioneRequest {
    @NotBlank(message = "nome obbligatorio")
    private Utente utente;
    @NotBlank(message = "scegli numero prenotati")
    private int numeroPosti;
    @NotBlank(message = "scegli il nome dell'evento")
    private Evento nomeEvento;
}
