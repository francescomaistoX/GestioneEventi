package it.epicode.gestioneeventi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private String titolo;
    private String luogo;
    private LocalDate data;
    @OneToMany(mappedBy = "evento",cascade = CascadeType.REMOVE)
    private List<Prenotazione> prenotazioni;
    private  int numeroPostiDisponibili;
    private String descrizione;
}
