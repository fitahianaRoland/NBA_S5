package com.nba.equipe;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nba.statistique.StatistiqueSaison;
import com.nba.statistique.StatistiqueSaisonRepository;

@RestController
public class EquipeController {

    private final EquipeRepository equipeRepo ;
    private final StatistiqueSaisonRepository statistiqueRepo ;

    public EquipeController(EquipeRepository equipeRepo,StatistiqueSaisonRepository statistiqueRepo){
        this.equipeRepo = equipeRepo ;
        this.statistiqueRepo = statistiqueRepo ;
    }

    @GetMapping("/equipes")
  	public List<Equipe> findAllEquipes() {
    	return this.equipeRepo.findAll();
  	}

    @GetMapping("/equipes/{idequipe}/{idsaison}")
  	public List<StatistiqueSaison> showStatistique(@PathVariable( "idequipe" ) Integer idEquipe,@PathVariable( "idsaison" ) Integer idSaison) {
    	return this.statistiqueRepo.getStatistiqueSaison(idEquipe, idSaison);
  	}
}
