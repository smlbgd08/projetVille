package org.sid.model;

import java.io.Serializable;
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
@Table(name="cinema")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Cinema implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String name ;
	private double longitude , latitude , altitude ;
	private int nmbSalle ;
	@OneToMany(mappedBy = "cinema")
	private List<Salle> salles ;
	@ManyToOne
	private Ville ville ;
	
	private String git ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public int getNmbSalle() {
		return nmbSalle;
	}

	public void setNmbSalle(int nmbSalle) {
		this.nmbSalle = nmbSalle;
	}

	public List<Salle> getSalles() {
		return salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public String getGit() {
		return git;
	}

	public void setGit(String git) {
		this.git = git;
	}
	
	


	
	
}
