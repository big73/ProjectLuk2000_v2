package fr.ipst.cnam.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the privilege database table.
 * 
 */
@Entity
@Table(name="privilege")
@NamedQuery(name="Privilege.findAll", query="SELECT p FROM Privilege p")
public class Privilege implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="action_crudoc")
	private String actionCrudoc;

	@Column(name="id_oc")
	private int idOc;

	@Column(name="id_user")
	private int idUser;

	public Privilege() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActionCrudoc() {
		return this.actionCrudoc;
	}

	public void setActionCrudoc(String actionCrudoc) {
		this.actionCrudoc = actionCrudoc;
	}

	public int getIdOc() {
		return this.idOc;
	}

	public void setIdOc(int idOc) {
		this.idOc = idOc;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

}