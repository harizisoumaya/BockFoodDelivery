package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ItemeMenu {
	
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    private String titre;
	    private String description;
	    private float prix;

	    @ManyToOne
	    @JoinColumn(name = "rest_id")
	    private Restaurant rest ;

		public ItemeMenu() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ItemeMenu(Integer id, String titre, String description, float prix, Restaurant rest) {
			super();
			this.id = id;
			this.titre = titre;
			this.description = description;
			this.prix = prix;
			this.rest = rest;
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

		public float getPrix() {
			return prix;
		}

		public void setPrix(float prix) {
			this.prix = prix;
		}

		public Restaurant getRest() {
			return rest;
		}

		public void setRest(Restaurant rest) {
			this.rest = rest;
		}
}
