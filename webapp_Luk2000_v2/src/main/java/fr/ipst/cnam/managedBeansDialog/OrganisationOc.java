package fr.ipst.cnam.managedBeansDialog;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import fr.ipst.cnam.entities.Oc;

@ManagedBean(name="OrganisationOc")
@SessionScoped
public class OrganisationOc {
	
	List<Oc> parcOc;
	
	@ManagedProperty("#{parcOcService}")
	private ParcOcService parcOcService;
	
	private Oc ocSelected;
	
	public OrganisationOc() {
		System.out.println("appel du constructeur");
	}
	
	@PostConstruct
	public void init()
	{
		parcOc = parcOcService.getParcOc();
		
	}

	public void modifierOc()
	{
		System.out.println("modifierOC dans organisationOC");
		System.out.println(this.ocSelected.getIdProprietaire());
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
	

}
