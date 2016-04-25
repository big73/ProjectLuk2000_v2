package fr.ipst.cnam.managedBeansDialog;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import fr.ipst.cnam.controllers.CrudOc;
import fr.ipst.cnam.entities.Oc;

@ManagedBean(name="parcOcService")
@ApplicationScoped
public class ParcOcService {
	
	public List<Oc> getParcOc()
	{
		return CrudOc.getParcOcInstance();
	}

}
