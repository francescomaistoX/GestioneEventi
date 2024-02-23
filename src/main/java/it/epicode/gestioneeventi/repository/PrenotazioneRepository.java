package it.epicode.gestioneeventi.repository;

import it.epicode.gestioneeventi.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Integer> {
}
