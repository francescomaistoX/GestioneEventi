package it.epicode.gestioneeventi.controller;

import it.epicode.gestioneeventi.exception.BadRequestException;
import it.epicode.gestioneeventi.model.Evento;
import it.epicode.gestioneeventi.model.Utente;
import it.epicode.gestioneeventi.modelRequest.EventoRequest;
import it.epicode.gestioneeventi.modelRequest.UtenteRequest;
import it.epicode.gestioneeventi.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventoController {
    @Autowired
    private EventoService eventoService;
    @GetMapping("/eventi")
    public List<Evento> getAllUtenti (){
        return eventoService.getAllEvento();
    }

    @GetMapping("/eventi/{titolo}")
    public Evento getUtenteTitolo(@PathVariable String titolo){
        return eventoService.getEventoByTitolo(titolo);
    }

    @PostMapping("/eventi")

    public Evento saveEvento (@RequestBody @Validated EventoRequest eventoRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }
        return eventoService.save(eventoRequest);
    }
    @PutMapping("/eventi/{titolo}")
    public Evento updateEvento (@PathVariable String titolo,@RequestBody @Validated EventoRequest eventoRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }
        return eventoService.updateEvento(titolo,eventoRequest);
    }
    @DeleteMapping("/eventi/{titolo}")
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    public void deleteEvento (@PathVariable String titolo){
        eventoService.deleteEvento(titolo);
    }
    @GetMapping("/eventi/{titolo}/partecipanti")
    @PreAuthorize("hasAuthority('ORGANIZZATORE')")
    public void getAllPartecipanti (@PathVariable String titolo){
        eventoService.getAllPartecipanti(titolo);
    }
}


