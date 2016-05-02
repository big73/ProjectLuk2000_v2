package fr.ipst.cnam.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the oc database table.
 * 
 */
@Entity
@Table(name="oc")
@NamedQuery(name="Oc.findAll", query="SELECT o FROM Oc o")
public class Oc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_crea")
	private Date dateCrea;

	@Column(name="domaine_act")
	private String domaineAct;

	@Column(name="id_proprietaire")
	private int idProprietaire;

	private String nom;

	public Oc() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCrea() {
		return this.dateCrea;
	}

	public void setDateCrea(Date dateCrea) {
		this.dateCrea = dateCrea;
	}

	public String getDomaineAct() {
		return this.domaineAct;
	}

	public void setDomaineAct(String domaineAct) {
		this.domaineAct = domaineAct;
	}

	public int getIdProprietaire() {
		return this.idProprietaire;
	}

	public void setIdProprietaire(int idProprietaire) {
		this.idProprietaire = idProprietaire;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}