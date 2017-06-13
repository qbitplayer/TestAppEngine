package test;

import org.junit.Assert;
import org.junit.Test;

import main.ListPerson;
import main.Person;
import util.FileHelper;

public class TestListPerson {

	
	
	
	
	
	@Test	
	public void testContructorList(){
		
	
		String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "Pablo Marmol; 003412415700; pablo@pica.com;Marmol 46"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1}; 
		
	    ListPerson list = new ListPerson(strContacts ); 
	     
		 Assert.assertEquals(strContacts.length,list.size());
		 Person person = list.get(0);  
		 Assert.assertEquals("Pedro", person.getName()); 
		 Assert.assertEquals("Picapiedra", person.getSurname());
		 Assert.assertEquals("003412415789", person.getPhone()); 
		 Assert.assertEquals("pedro@pica.com", person.getEmail()); 
		 Assert.assertEquals("Marmol 45", person.getAddress()); 
		
	}
	
	
	@Test	
	public void testAddList(){
		
		String strContactAdd= "Pablo Marmol; 0034123456789; pedro@pica.com;Marmol 47";
		
		String[] strNewList= new String[] 
				{"Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"};
		
		ListPerson list = new ListPerson(strNewList);	
		Person newPerson = new Person(strContactAdd);
		list.add(newPerson);
		Assert.assertEquals(2, list.size());
		Assert.assertEquals("Pablo", list.get(1).getName());
		Assert.assertEquals("Marmol", list.get(1).getSurname());
		
	}
	
	
	@Test	
	public void testRemoveList(){
		

		String strContact0= "Pedro Picapiedra;003412415789;pedro@pica.com;Marmol 45"; 
		String strContact1= "Pablo Marmol; 003412415700; pablo@pica.com;Marmol 46"; 
		String[] strContacts= 
				new String[]{strContact0,strContact1}; 
		
		ListPerson list = new ListPerson(strContacts);
		
		//list.remove(0);
		
		Assert.assertEquals(2, list.size());
		Assert.assertEquals("Pablo", list.get(1).getName());
		Assert.assertEquals("Marmol", list.get(1).getSurname());
		
	}
	
	
	
	
}
