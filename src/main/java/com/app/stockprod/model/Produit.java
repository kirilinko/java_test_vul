package com.app.stockprod.model;

public class Produit {
	private int id;
    private String nom;
    private double prix;
    
    
    
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit(int id, String nom, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
}
