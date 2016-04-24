package fr.ipst.cnam.managedBeans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManagerFactory;

import fr.ipst.cnam.daos.ManagerDAO;
import fr.ipst.cnam.daos.OcDAO;
import fr.ipst.cnam.daos.OcDAOInterface;
import fr.ipst.cnam.entities.ParcOc;
import fr.ipst.cnam.entities.Oc;

@ManagedBean(name="parcOcService")
@ApplicationScoped
public class ParcOcService {
	
	public List<Oc> getParcOc()
	{
		return ParcOc.getInstance();
	}

}
