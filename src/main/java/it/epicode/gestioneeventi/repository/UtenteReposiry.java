package it.epicode.gestioneeventi.repository;

import it.epicode.gestioneeventi.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UtenteReposiry extends JpaRepository<Utente,Integer> {
    public Optional<Utente> findByUserName(String userName);

}
