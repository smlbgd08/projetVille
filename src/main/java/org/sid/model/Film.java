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
@Table(name="film")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Film {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String titre ;
	private String decription ;
	private String realisateur ;
	private Date dateSortie ;
	private double duree ;
	private String photo ;
	@OneToMany(mappedBy = "film")
	private List<Projection> projections;
	@ManyToOne
	private Categorie categorie;
	

}
