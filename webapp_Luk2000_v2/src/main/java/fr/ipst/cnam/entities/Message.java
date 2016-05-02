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
 * The persistent class for the message database table.
 * 
 */
@Entity
@Table(name="message")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String contenu;

	@Temporal(TemporalType.DATE)
	@Column(name="date_envoi")
	private Date dateEnvoi;

	@Column(name="id_oc")
	private int idOc;

	@Column(name="id_service_emetteur")
	private int idServiceEmetteur;

	private byte lu;

	private String optionAB;

	private String titre;

	public Message() {
	}
	
	public Message(String titre, String contenu,
			int idOc, int idServiceEmetteur, String optionAB) {
			
			
			this.dateEnvoi = new Date();
			this.titre = titre;
			this.contenu = contenu;
			this.idOc = idOc;
			
			this.idServiceEmetteur = idServiceEmetteur;
			this.optionAB = optionAB;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateEnvoi() {
		return this.dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public int getIdOc() {
		return this.idOc;
	}

	public void setIdOc(int idOc) {
		this.idOc = idOc;
	}

	public int getIdServiceEmetteur() {
		return this.idServiceEmetteur;
	}

	public void setIdServiceEmetteur(int idServiceEmetteur) {
		this.idServiceEmetteur = idServiceEmetteur;
	}

	public byte getLu() {
		return this.lu;
	}

	public void setLu(byte lu) {
		this.lu = lu;
	}

	public String getOptionAB() {
		return this.optionAB;
	}

	public void setOptionAB(String optionAB) {
		this.optionAB = optionAB;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}