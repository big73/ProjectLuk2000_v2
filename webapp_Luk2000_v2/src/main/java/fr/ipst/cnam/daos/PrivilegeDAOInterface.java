package fr.ipst.cnam.daos;

import java.util.List;

import javax.persistence.EntityManager;

import fr.ipst.cnam.entities.Privilege;

public interface PrivilegeDAOInterface {
	
	public EntityManager getEntityManager();
	
	public List<Privilege> findPrivileges(int idUser);

}
