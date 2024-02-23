package it.epicode.gestioneeventi.service;

import it.epicode.gestioneeventi.exception.NotFoundException;
import it.epicode.gestioneeventi.model.Evento;
import it.epicode.gestioneeventi.model.Prenotazione;
import it.epicode.gestioneeventi.model.Utente;
import it.epicode.gestioneeventi.modelRequest.EventoRequest;
import it.epicode.gestioneeventi.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> getAllEvento(){
        return eventoRepository.findAll();
    }

    public  Evento getEventoById(int id){
        return eventoRepository.findById(id).orElseThrow(()->new NotFoundException("Evento non trovato"));
    }
    public Evento getEventoByTitolo(String titolo){
        return eventoRepository.findByTitolo(titolo).orElseThrow(()->new NotFoundException("Evento non trovato"));
    }

    public Evento save(EventoRequest eventoRequest){
        Evento evento = new Evento();
        evento.setTitolo(eventoRequest.getTitolo());
        evento.setDescrizione(eventoRequest.getDescrizione());
        evento.setLuogo(eventoRequest.getLuogo());
        evento.setData(eventoRequest.getData());
        evento.setNumeroPostiDisponibili(eventoRequest.getNumeroPosti());
        return eventoRepository.save(evento);

    }
    public Evento updateEvento(String titolo,EventoRequest eventoRequest){
      Evento evento = getEventoByTitolo(titolo);
        evento.setTitolo(eventoRequest.getTitolo());
        evento.setDescrizione(eventoRequest.getDescrizione());
        evento.setLuogo(eventoRequest.getLuogo());
        evento.setData(eventoRequest.getData());
        return eventoRepository.save(evento);
    }
    public void  deleteEvento (String titolo){
        Evento evento= getEventoByTitolo(titolo);
         eventoRepository.delete(evento);
    }
    public  void getAllPartecipanti(String titoloEvento){
        Evento evento = getEventoByTitolo(titoloEvento);
        List<String> nomiPartecipanti = evento.getPrenotazioni().stream()
                .map(Prenotazione::getUtente)
                .map(Utente::getNome).collect(Collectors.toList());
         nomiPartecipanti.forEach(System.out::println);
        ;
    }
}
