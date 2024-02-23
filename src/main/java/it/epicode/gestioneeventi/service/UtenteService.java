package it.epicode.gestioneeventi.service;

import it.epicode.gestioneeventi.exception.NotFoundException;
import it.epicode.gestioneeventi.model.Role;
import it.epicode.gestioneeventi.model.Utente;
import it.epicode.gestioneeventi.modelRequest.UtenteRequest;
import it.epicode.gestioneeventi.repository.UtenteReposiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {
    @Autowired
    private UtenteReposiry utenteReposiry;
    @Autowired
    private PasswordEncoder encoder;


    public Utente save(UtenteRequest utenteRequest){

        Utente utente = new Utente();
        utente.setNome(utenteRequest.getUserName());
        utente.setUserName(utenteRequest.getUserName());
        utente.setPassword(encoder.encode(utenteRequest.getPassword()));
        utente.setRuolo(Role.UTENTE.UTENTE);

        return utenteReposiry.save(utente);
    }
    public  Utente getUtenteById(int id){
        return utenteReposiry.findById(id).orElseThrow(()->new NotFoundException("Utente non trovato"));
    }

    public Utente getUtenteByUserName(String userName){
        return utenteReposiry.findByUserName(userName).orElseThrow(()->new NotFoundException("Username non trovato"));
    }
    public List<Utente> getAllUtenti (){
        return utenteReposiry.findAll();
    }
    public Utente updateUtente (String userName,UtenteRequest utenteRequest){
        Utente utente = getUtenteByUserName(userName);
        utente.setNome(utenteRequest.getNome());
        utente.setUserName(utenteRequest.getUserName());
        utenteReposiry.save(utente);
        return utente;
    }
    public Utente updateRole (String userName,Role role){
        Utente utente = getUtenteByUserName(userName);
        utente.setRuolo(role);
        utenteReposiry.save(utente);
        return utente;
    }
    public void deleteUtente(String userName){
        Utente utente= getUtenteByUserName(userName);
        utenteReposiry.delete(utente);
    }
    public void deletePrenotazione(String userName,int idprenotazione){
        Utente utente = getUtenteByUserName(userName);
        utente.getPrenotazioni().remove(idprenotazione);
    }
}
