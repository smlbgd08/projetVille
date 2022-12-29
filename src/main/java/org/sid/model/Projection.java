package org.sid.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="projection")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Projection {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private Date dateProjection;
	private double prix;
	@ManyToOne
	private Film film;
	@ManyToOne
	private Salle salle;
	@OneToMany(mappedBy = "projection")
	private List<Ticket> tickets;
	@ManyToOne
	private Seance seance;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
