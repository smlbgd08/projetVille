package org.sid.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

@Projection(name = "p1" , types = org.sid.model.Projection.class)
public interface ProjectionProj {
	
	public Long getId();
	public Date getDateProjection();
	public double getPrix();
	public Film getFilm();
	public Salle getSalle();
	public List<Ticket> getTickets();
	public Seance getSeance();
	
	
}
