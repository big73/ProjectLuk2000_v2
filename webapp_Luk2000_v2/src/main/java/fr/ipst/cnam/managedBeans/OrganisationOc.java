package fr.ipst.cnam.managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import fr.ipst.cnam.entities.Oc;

@ManagedBean(name="OrganisationOc")
@RequestScoped
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
