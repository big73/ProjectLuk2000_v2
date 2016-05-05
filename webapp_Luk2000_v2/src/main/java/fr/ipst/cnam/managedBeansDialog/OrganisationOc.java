package fr.ipst.cnam.managedBeansDialog;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import fr.ipst.cnam.controllers.ControlPrivilege;
import fr.ipst.cnam.controllers.CrudOc;
import fr.ipst.cnam.entities.Oc;

@ManagedBean(name="OrganisationOc")
@SessionScoped
public class OrganisationOc {
	
	List<Oc> parcOc;
	
	@ManagedProperty("#{parcOcService}")
	private ParcOcService parcOcService;
	
	@ManagedProperty("#{userBean}")
	private UserBean userBean;
	
	/*
	@ManagedProperty("#{messageBean}")
	private MessageBean messageBean;
	*/
	
	//private Message msg;
	
	private Oc ocSelected;
	
	public OrganisationOc() {
		System.out.println("appel du constructeur");
		//System.out.println(this.userBean.getPrenom());
	}
	
	@PostConstruct
	public void init()
	{
		parcOc = CrudOc.getParcOcInstance();
		
	}
	
	public String creerOc()
	{
		System.out.println("ok creeroc");
		return "OK";
	}
	
	public void modifierOc()
	{
		ControlPrivilege control = new ControlPrivilege();
		boolean droitModification = control.checkPrivileges(userBean.getUser(), ocSelected, "m");
		
		if(droitModification == false)
		{
			FacesMessage msg = new FacesMessage("Privilèges insuffisant !");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		else
		{
			CrudOc controlCrudoc = new CrudOc();
			controlCrudoc.modifierOc(ocSelected.getId()
					, ocSelected.getNom(), 
					ocSelected.getDomaineAct(), 
					ocSelected.getIdProprietaire());
		}
	}
	
	private String resultSuppression = null;
	
	public String getResultSuppression() {
		return resultSuppression;
	}
	
	public void setResultSuppression(String resultSuppression) {
		this.resultSuppression = resultSuppression;
	}
	
	public String supprimerOc()
	{
		setResultSuppression(null);
		ControlPrivilege control = new ControlPrivilege();
		boolean droitSuppression = control.checkPrivileges(userBean.getUser(), ocSelected, "s");
		if(droitSuppression == false)
		{
			setResultSuppression("Privilèges insuffisant !");
		}
		else
		{
			
						
			//suppression de l'oc en base de données
			CrudOc controlCrudOc = new CrudOc();			
			parcOc = controlCrudOc.supprimerOC(ocSelected);
			System.out.println("parcour de la liste après bd");
			Iterator<Oc> it1 = parcOc.iterator();
			while(it1.hasNext())
			{
				Oc oc = it1.next();
				System.out.println("it1 : " + oc.getId());
			}
			
			setResultSuppression("Objet connecté supprimé avec succès !");
			//RequestContext.getCurrentInstance().reset("form:form");
		}
		return "OK";
	}

	public List<Oc> getParcOc() {
		return parcOc;
	}

	public void setParcOc(List<Oc> parcOc) {
		this.parcOc = parcOc;
	}

	public ParcOcService getParcOcService() {
		return parcOcService;
	}

	public void setParcOcService(ParcOcService parcOcService) {
		this.parcOcService = parcOcService;
	}

	public Oc getOcSelected() {
		return ocSelected;
	}

	public void setOcSelected(Oc ocSelected) {
		this.ocSelected = ocSelected;
	}
	
	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage( ((Oc) event.getObject()).getNom());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage( ((Oc) event.getObject()).getNom());
        
    	FacesContext.getCurrentInstance().addMessage(null, msg);
    }

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	public void fatal() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
    }

	

}
