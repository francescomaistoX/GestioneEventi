package it.epicode.gestioneeventi.repository;

import it.epicode.gestioneeventi.model.Evento;
import it.epicode.gestioneeventi.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EventoRepository extends JpaRepository<Evento,Integer> {
    public Optional<Evento> findByTitolo(String titolo);
}
