package it.epicode.gestioneeventi.controller;

import it.epicode.gestioneeventi.exception.BadRequestException;
import it.epicode.gestioneeventi.model.Role;
import it.epicode.gestioneeventi.model.Utente;
import it.epicode.gestioneeventi.modelRequest.UtenteRequest;
import it.epicode.gestioneeventi.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtenteController {

    @Autowired
    private UtenteService utenteService;
    @GetMapping("/utenti")
    public List<Utente> getAllUtenti (){
        return utenteService.getAllUtenti();
    }
    @GetMapping("/utenti/{userName}")
    public Utente getUtenteUserName(@PathVariable String userName){
        return utenteService.getUtenteByUserName(userName);
    }
    @PostMapping("/utenti/")

    public Utente saveUtente (@RequestBody @Validated UtenteRequest utenteRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }
          return utenteService.save(utenteRequest);
    }
    @PutMapping("/utenti/{userName}")
    public Utente updateUtente (@PathVariable String userName,@RequestBody @Validated UtenteRequest utenteRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }
        return utenteService.updateUtente(userName,utenteRequest);
    }
    @PatchMapping("/utenti/{userName}/update")
    public Utente updateRole (@PathVariable String userName,@RequestBody @Validated Role role){
        return utenteService.updateRole(userName,role);
    }
    @DeleteMapping("/utenti/{userName}")
    public void deleteUtente (@PathVariable String userName){
       utenteService.deleteUtente(userName);
    }

    @PatchMapping("/utenti/{userName}/{idprenotazione}/update")
    public void deletePrenotazione (@PathVariable String userName,@RequestBody @Validated int idPrenotazione){
        utenteService.deletePrenotazione(userName,idPrenotazione);
    }
}

