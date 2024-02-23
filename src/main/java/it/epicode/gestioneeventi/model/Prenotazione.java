package it.epicode.gestioneeventi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    private int numeroPosti;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;



    public int postiDisponibili(){
        int postiPrenotati =evento.getPrenotazioni().stream().mapToInt(Prenotazione::getNumeroPosti).sum();
        return evento.getNumeroPostiDisponibili() - postiPrenotati;


    }


}
