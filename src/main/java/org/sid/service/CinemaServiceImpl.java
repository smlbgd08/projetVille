package org.sid.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.sid.dao.CategorieRepository;
import org.sid.dao.CinemaRepository;
import org.sid.dao.FilmRepository;
import org.sid.dao.PlaceRepository;
import org.sid.dao.ProjectionRepository;
import org.sid.dao.SalleRepository;
import org.sid.dao.SeanceRepository;
import org.sid.dao.TicketRepository;
import org.sid.dao.VilleRepository;
import org.sid.model.Categorie;
import org.sid.model.Cinema;
import org.sid.model.Film;
import org.sid.model.Place;
import org.sid.model.Projection;
import org.sid.model.Salle;
import org.sid.model.Seance;
import org.sid.model.Ticket;
import org.sid.model.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CinemaServiceImpl implements ICinemaService {

	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private CinemaRepository cinemaRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private SeanceRepository seanceRepository;
	@Autowired
	private PlaceRepository placeRepository;
	@Autowired
	private ProjectionRepository projectionRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private SalleRepository salleRepository;
	
	@Override
	public void initVille() {
		Stream.of("Casablanca","Marrakech","Rabat","Tanger","Fes").forEach(v -> {
			Ville vl = new Ville();
			vl.setName(v);
			villeRepository.save(vl);
		});
	}

	@Override
	public void initCinemas() {
		villeRepository.findAll().forEach(ville -> { 
			Stream.of("Megarama","IMAX","FOUNOUN" , "CHAHRAZAD" , "DAOULIZ").forEach(cinemaName ->{
				Cinema cinema = new Cinema();
				cinema.setName(cinemaName);
				cinema.setVille(ville);
				cinema.setNmbSalle(3+(int)(Math.random()*7));
				cinemaRepository.save(cinema);
			});
		});
		
	}

	@Override
	public void initSalles() {
		cinemaRepository.findAll().forEach(cinema ->{
			for (int i = 0; i < cinema.getNmbSalle(); i++) {
				Salle salle = new Salle();
				salle.setName("Salle" +(i+1));
				salle.setCinema(cinema);
				salle.setNombrePlace(15+(int)(Math.random()*20));
				
				salleRepository.save(salle);
			}
		});
	}

	@Override
	public void initPlaces() {
		salleRepository.findAll().forEach(salle -> {
			for (int i = 0; i < salle.getNombrePlace(); i++) {
				Place place = new Place();
				place.setNumero(i+1);
				place.setSalle(salle);
				placeRepository.save(place);
				
			}
		});
	}

	@Override
	public void initSeances() {
		DateFormat df = new SimpleDateFormat("HH:mm");
		Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s ->{
			Seance seance = new Seance();
			try {
				seance.setHeureDebut(df.parse(s));
				seanceRepository.save(seance);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

//	@Override
//	public void initCategories() {
//		Stream.of("Histoire","Actions","Fictions","Drama").forEach(catg -> {
//			Categorie categorie = new Categorie();
//			categorie.setName(catg);
//			categorieRepository.save(categorie);
//		});
//	}

//	@Override
//	public void initFilms() {
//		double[] durees = new double[] {1,1.5,2,2.5,3};
//		java.util.List<Categorie> ctg = categorieRepository.findAll();
//		Stream.of("Game of thrones","30 milione","El Farouje","Spider man" , "IRON man").forEach(titre -> {
//			Film film = new Film();
//			film.setTitre(titre);
//			film.setDuree(durees[new Random().nextInt(durees.length)] );
//			film.setCategorie(ctg.get(new Random().nextInt(ctg.size())));
//			filmRepository.save(film);
//		});
//	}

	@Override
	public void initProjections() {
		double[] prix = new double[] {30,50,60,70,90,100};
		List<Film> films = filmRepository.findAll();
		villeRepository.findAll().forEach(ville -> {
			ville.getCinemas().forEach(cinema->{
				cinema.getSalles().forEach(salle->{
					int index = new Random().nextInt(films.size());
					Film film  = films.get(index);
						seanceRepository.findAll().forEach(seance->{
							Projection projection = new Projection();
//							projection.setFilm(film);
//							projection.setSalle(salle);
//							projection.setSeance(seance);
//							projection.setPrix(prix[new Random().nextInt(prix.length)]);
//							projectionRepository.save(projection);
						});
					
				});
			});
		});
	}

	@Override
	public void initTickets() {
		projectionRepository.findAll().forEach(projection->{
//			projection.getSalle().getPlaces().forEach(place->{
//				Ticket ticket = new Ticket();
//				ticket.setPlace(place);
//				ticket.setReserve(false);
//				ticket.setPrix(projection.getPrix());
//				ticket.setProjection(projection);
//				ticketRepository.save(ticket);
//			});
		});
	}

}
