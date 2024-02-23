package it.epicode.gestioneeventi.service;

import it.epicode.gestioneeventi.exception.BadRequestException;
import it.epicode.gestioneeventi.exception.NotFoundException;
import it.epicode.gestioneeventi.model.Evento;
import it.epicode.gestioneeventi.model.Prenotazione;
import it.epicode.gestioneeventi.model.Utente;
import it.epicode.gestioneeventi.modelRequest.PrenotazioneRequest;
import it.epicode.gestioneeventi.repository.EventoRepository;
import it.epicode.gestioneeventi.repository.PrenotazioneRepository;
import it.epicode.gestioneeventi.repository.UtenteReposiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private EventoService eventoService;
    @Autowired
    private UtenteReposiry utenteReposiry;
    @Autowired
    private EventoRepository eventoRepository;

    public Prenotazione save (PrenotazioneRequest prenotazioneRequest,String userName,String titoloEvento) throws BadRequestException {
        Utente utente = utenteService.getUtenteByUserName(userName);
        Evento evento= eventoService.getEventoByTitolo(titoloEvento);
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setEvento(evento);
        prenotazione.setNumeroPosti(prenotazioneRequest.getNumeroPosti());
       if (prenotazione.getNumeroPosti()>=prenotazione.postiDisponibili()){
             throw new BadRequestException("I posti disponibili sono " + " " + prenotazione.postiDisponibili());}
            else if (prenotazione.postiDisponibili()== 0 ) {
           throw new BadRequestException("non ci sono posti disponibili");
       }
             else {
                 utente.getPrenotazioni().add(prenotazione);
                 evento.getPrenotazioni().add(prenotazione);
                 utenteReposiry.save(utente);
                 eventoRepository.save(evento);

           return prenotazioneRepository.save(prenotazione);
             }
       }
    public  Prenotazione getPrenotazioneById(int id){
        return prenotazioneRepository.findById(id).orElseThrow(()->new NotFoundException("prenotazione non trovata"));
    }
       public void deletePrenotazione (int idPrenotazione){
        Prenotazione prenotazione = getPrenotazioneById(idPrenotazione);
        prenotazioneRepository.delete(prenotazione);
       }

    }

