package fr.ipst.cnam.managedBeansDialog;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.ipst.cnam.controllers.CrudOc;
@ManagedBean(name="creerOc")
@SessionScoped
public class CreerOc {
	
	private String domaineAct;
	
	private String nom;
	
	@ManagedProperty("#{userBean}")
	private UserBean userBean;

	public String getDomaineAct() {
		return domaineAct;
	}

	public void setDomaineAct(String domaineAct) {
		this.domaineAct = domaineAct;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public String valider()
	{
		CrudOc control = new CrudOc();
		control.valider(this);
		
		return "OK";
	}

}
