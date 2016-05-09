package fr.ipst.cnam.entities;

import java.util.ArrayList;
import java.util.List;

public class Messagerie {
	
	private static ArrayList<Message> messagerie;
	
	private Messagerie()
	{
		messagerie = new ArrayList<>();
	}
	
	public static List<Message> getMessagerie()
	{
		if(messagerie == null)
		{
			System.out.println("si messagerie null");
			new Messagerie();
			return messagerie;
		}
		else
		{
			System.out.println("si messagerie full");
			return messagerie;
		}
	}

}
