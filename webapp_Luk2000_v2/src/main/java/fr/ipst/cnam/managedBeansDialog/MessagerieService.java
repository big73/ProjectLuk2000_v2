package fr.ipst.cnam.managedBeansDialog;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.ipst.cnam.controllers.ControlMessagerie;
import fr.ipst.cnam.entities.Message;

@ManagedBean(name="messagerieService")
@SessionScoped
public class MessagerieService {
	
	@ManagedProperty("#{OrganisationOc}")
	private OrganisationOc organisationOc;
	
	@ManagedProperty("#{userBean}")
	private UserBean userBean;
	
	private List<Message> messagerie;
	
	private Message msg;
	
	public Message getMsg() {
		return msg;
	}
	
	public void setMsg(Message msg) {
		this.msg = msg;
	}
	
	public List<Message> getMessagerie() {
		return messagerie;
	}
	
	public void setMessagerie(List<Message> messagerie) {
		this.messagerie = messagerie;
	}
	
	public void utiliserServiceA()
	{
		System.out.println("début de la méthode a");
		ControlMessagerie control = new ControlMessagerie();
		msg = control.utiliserServiceOC(organisationOc.getOcSelected(), null);
		
		if(msg == null)
		{
			System.out.println("msg vide");
		}
		else
		{
			System.out.println("msg plein");
		}
		
	}
	
	public void utiliserServiceB()
	{
		System.out.println("opération b");
	}

	public OrganisationOc getOrganisationOc() {
		return organisationOc;
	}

	public void setOrganisationOc(OrganisationOc organisationOc) {
		this.organisationOc = organisationOc;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	

}
