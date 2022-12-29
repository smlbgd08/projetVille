package org.sid.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;
@Entity
@Table(name="ticket")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Ticket {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String nomClient ;
	private double prix ;
	@Column(unique = false , nullable = true)
	private Integer codePayement ;
	private boolean reserve ;
	@ManyToOne
	private Place place;
	@ManyToOne
	private Salle salle;
	@ManyToOne
	@JsonProperty(access = Access.READ_WRITE)
	private Projection projection;

}
