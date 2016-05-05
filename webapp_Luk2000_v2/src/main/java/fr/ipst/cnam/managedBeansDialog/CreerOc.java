package fr.ipst.cnam.managedBeansDialog;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import fr.ipst.cnam.controllers.CrudOc;
import fr.ipst.cnam.entities.Oc;
@ManagedBean(name="creerOc")
@SessionScoped
public class CreerOc {
	
	private String domaineAct;
	
	private String nom;
	
	@ManagedProperty("#{userBean}")
	private UserBean userBean;
	
	@ManagedProperty("#{OrganisationOc}")
	private OrganisationOc organisationOc;
	
	public OrganisationOc getOrganisationOc() {
		return organisationOc;
	}
	
	public void setOrganisationOc(OrganisationOc organisationOc) {
		this.organisationOc = organisationOc;
	}

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
		List<Oc> parcRafraichi = control.valider(this);
		this.organisationOc.setParcOc(parcRafraichi);
		
		this.domaineAct = null;
		this.nom = null;
		return "OK";
	}

}
