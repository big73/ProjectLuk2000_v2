package fr.ipst.cnam.daos;

import java.util.List;

import javax.persistence.EntityManager;

import fr.ipst.cnam.entities.Message;

public interface MessageDAOInterface {
	
	public EntityManager getEntityManager();
	
	public void persistMessage(Message msg);
	
	public List<Message> findAllMessages();

}
