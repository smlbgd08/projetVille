package org.sid.web;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.sid.dao.FilmRepository;
import org.sid.dao.TicketRepository;
import org.sid.dao.VilleRepository;
import org.sid.model.Film;
import org.sid.model.Ticket;
import org.sid.model.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@CrossOrigin("*")
public class CinemaRestController {
	
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private VilleRepository villeRepository;
	
//	@GetMapping(path = "/imageFilm/{idFilm}",produces = MediaType.IMAGE_JPEG_VALUE)
//	public byte[] imageFilm(@PathVariable Long idFilm) throws IOException {
//		Film film =  filmRepository.findById(idFilm).get();
//		String photoName = film.getPhoto();
//		File file = new File(System.getProperty("user.home")+"/cinema/"+photoName);
//		Path path = Paths.get(file.toURI());
//		//return Files.readAllBytes(Paths.get((System.getProperty("user.home")+"/ecom/product/"+p.getPhotoName())));
//		//byte[] f = Files.readAllBytes(path);
//		return Files.readAllBytes(path);
//	}
	
//	@PostMapping("/payerTickets")
//	public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm)
//	{
//		List<Ticket> listTickets = new ArrayList<>();
//		ticketForm.getTickets().forEach(ticket->{
//			Ticket t =  ticketRepository.findById(ticket).get();
//			t.setNomClient(ticketForm.getNomClient());
//			t.setCodePayement(ticketForm.getCodePaiment());
//			t.setReserve(true);
//			ticketRepository.save(t);
//			listTickets.add(t);
//		});
//		return listTickets;
//	}
	@CrossOrigin("*")
	@GetMapping("/getAllVilles")
	public List<Ville> getAllVille()
	{
		return villeRepository.findAll();
	}

}
@Data
class TicketForm {
	private String nomClient;
	private int codePaiment;
	List<Long> tickets = new ArrayList<>();
}
