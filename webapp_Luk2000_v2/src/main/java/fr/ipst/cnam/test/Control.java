package fr.ipst.cnam.test;

import java.util.Iterator;

import fr.ipst.cnam.controllers.ControlMessagerie;
import fr.ipst.cnam.entities.Message;
import fr.ipst.cnam.entities.Oc;

public class Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Oc oc = new Oc();
		oc.setId(37);
		oc.setDomaineAct("Domotique");
		
		ControlMessagerie control = new ControlMessagerie();
		control.utiliserServiceOC(oc, "A");
		
		Oc oc2 = new Oc();
		oc2.setId(28);
		oc2.setDomaineAct("tuche");
		
		control.utiliserServiceOC(oc2, "A");
		
		/*
		Iterator<Message> it = ControlMessagerie.getMessagerie().iterator();
		while(it.hasNext())
		{
			Message m = it.next();
			System.out.println(m.getContenu());
		}
		*/

	}
	
	static public int getAge()
	{
		return 3;
	}

}
