package org.sid;

import org.sid.model.Film;
import org.sid.model.Projection;
import org.sid.model.Ville;
import org.sid.service.CinemaServiceImpl;
import org.sid.service.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProjetCinemaApplication implements CommandLineRunner {
	
	@Autowired
	private ICinemaService cinemaService;
	
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(ProjetCinemaApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// for get id in objet 
		restConfiguration.exposeIdsFor(Film.class , Projection.class , Ville.class);
//		  cinemaService.initVille(); cinemaService.initCinemas();
//		  cinemaService.initSalles(); cinemaService.initPlaces();
//		  cinemaService.initSalles(); cinemaService.initSeances();
//		  cinemaService.initCategories(); cinemaService.initFilms();
//		  cinemaService.initProjections();
		 
		//cinemaService.initTickets();
		
	}

}
