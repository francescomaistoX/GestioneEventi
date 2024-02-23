package it.epicode.gestioneeventi.controller;

import it.epicode.gestioneeventi.exception.BadRequestException;
import it.epicode.gestioneeventi.model.Prenotazione;
import it.epicode.gestioneeventi.model.Utente;
import it.epicode.gestioneeventi.modelRequest.PrenotazioneRequest;
import it.epicode.gestioneeventi.modelRequest.UtenteRequest;
import it.epicode.gestioneeventi.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrenotazioneController {
    @Autowired
    private PrenotazioneService prenotazioneService;
@PutMapping("/prenotazioni/userName/titoloEvento")
    public Prenotazione savePrenotazione (@RequestBody @Validated PrenotazioneRequest prenotazioneRequest, @RequestParam("userName") String userName, @RequestParam("titoloEvento") String titoloEvento , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }
        return prenotazioneService.save(prenotazioneRequest,userName,titoloEvento);
    }


}
