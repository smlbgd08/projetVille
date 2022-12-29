package org.sid.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ticketProj" , types = org.sid.model.Ticket.class)
public interface TicketProjection {
	
	public Long getId() ;
	public String nomClient() ;
	public String getCodePayement() ;
	public double getPrix() ;
	public Boolean getReserve() ;
	public Place getPlace() ;
	
	

}
