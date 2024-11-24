package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
@Entity
public class Restaurant {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titre;
	private String description ;
	private String adresse;
	private String specialite;

	@Lob
	private byte[] image;
	
	@OneToMany(mappedBy ="rest", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<ItemeMenu> menu;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(Integer id, String titre, String description, String adresse, String specialite,
			List<ItemeMenu> menu) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.adresse = adresse;
		this.specialite = specialite;
		this.menu = new ArrayList<ItemeMenu>();
	}

	public Restaurant(byte[] image, String titre, String description, String adresse, String spescialite) {
		super();
		this.image = image;
		this.titre = titre;
		this.description = description;
		this.adresse = adresse;
		this.specialite = specialite;
		this.menu = new ArrayList<ItemeMenu>();
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String spescialite) {
		this.specialite = spescialite;
	}

	public List<ItemeMenu> getMenu() {
		return menu;
	}

	public void setMenu(List<ItemeMenu> menu) {
		this.menu = menu;
	}
	
	
}
