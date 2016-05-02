package fr.ipst.cnam.managedBeansDialog;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.ipst.cnam.entities.User;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean {
	
	private User user;
	
	
	
	
	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	/*
	private int id;

	private String mail;

	private String nom;

	private String password;

	private String prenom;

	private String statut;

	private String tel;
*/
	public UserBean() {
		System.out.println("User constructor");
	}
/*
	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	*/

}
