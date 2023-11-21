package com.nba.statistique;

import java.util.List;
import java.util.Optional;

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

@RestController
public class MatchController {
    MatchStatistiqueRepository matchStatRepo;

    public MatchController(MatchStatistiqueRepository matchStatRepo){
        this.matchStatRepo = matchStatRepo;
    }

    @GetMapping("/matchstats")
  	public List<MatchStatistique> findAllMatchStats() {
    	return this.matchStatRepo.findAll();
  	}

    @PostMapping("/matchstats")
	public MatchStatistique saveVehicule(@Validated @RequestBody MatchStatistique matchstats) {
    	return matchStatRepo.save(matchstats);
	}

	@PutMapping(value = "matchstats/{id}")
    public MatchStatistique update(@PathVariable( "id" ) Long id, @RequestBody MatchStatistique matchstats) {
        return matchStatRepo.save(matchstats);
    }
}
