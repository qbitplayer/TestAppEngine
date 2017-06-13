package main;

import java.util.Arrays;

public class ListPerson {
	
	private Person[] contacts;

	
	public ListPerson(String[] strContacts){
		iniContact(strContacts); 
	}
	
	private void iniContact(String[] strContacts) {
		contacts = new Person[strContacts.length]; 
		  
		  for(int i=0; i<strContacts.length; i++){
			  String contactFileFormat = strContacts [i]; 
			  Person contact = new Person(contactFileFormat);
		      //add(contact); 
			  contacts[i] = contact;  
		  }
	}


	/**
	 * Retorna el numero de personas que contiene
	 * @return
	 */
	public int size() {
		return contacts.length;
	}

	/**
	 * Obtiene la persona que tiene el index i 
	 * @param i
	 * @return
	 */
	public Person get(int i) {
		return contacts[i];
	}
	
	/** Sobre escribe una persona de la lista en el index dado por index 
	 * @param person
	 * @param index
	 */
	public void set(Person person, int index){
		// TODO Auto-generated method stub
		if(index< 0 || index >= contacts.length)
			throw new RuntimeException("Indice fuera de rango");  
		
		contacts[index]=person; 
		
	}
	

	/**
	 * Retorna el index del objeto person 
	 * @param person
	 * @return
	 */
	public int indexOf(Person person){
		int index = -1; 
		for(int i=0; i<contacts.length; i++){
			if(contacts[i].equals(person)){
				index = i;
				 break; 
			}
		}	
		return index; 
	}

	/**
	 * Adiciona una persona al alrreglo interno de personas. 
	 * Se adiciona en la ultima posicion
	 * @param contact
	 */
	public void add(Person contact) {			
		Person[] copyContacts = new Person[contacts.length+1];	
		for(int i=0;i<contacts.length;i++){
			copyContacts[i]=contacts[i];
		}
		copyContacts[contacts.length]=contact;		
		
		contacts = copyContacts;	
	}
	
	/**
	 * Elimina una persona del la lista
	 * @param person
	 */
	public void remove(Person person) {
		remove(indexOf(person));   
	}
	
	public void remove(int index) {
		if(index< 0 || index >= contacts.length)
			return; 
			
		
	}
	
	/**
	 * Retorna todas las personas que coontengan strString en su campo name
	 * @return
	 */
	public Person[] findByName(String strName){
		// TODO Auto-generated method stub
		return contacts;	
	}

	/**
	 * Retorna todas las personas que contengan strMail en su campo email
	 * @return
	 */
	public Person[] findByEmail(String strMail){
		Person array[] = new Person[contacts.length];  
		int counter = 0;
		
		for(Person person: contacts){
			if(person.getEmail().contains(strMail))
				array[counter++]=person; 
		}
		
		Person personsWidthEmail[] = new Person[counter];  
		for(int i=0,k=0; i<contacts.length; i++){
			if(contacts[i].getEmail().contains(strMail))
				personsWidthEmail[k++]=contacts[i];
		}
		
	 return personsWidthEmail;
	}
	
	

	/**
	 * Retorna una copia de la lista ordenada alfabeticamente
	 * @return
	 */
	public Person[] sort(){
		// TODO Auto-generated method stub
		String fullNames[] = new String[contacts.length]; 
		Person[] listSort = new Person[contacts.length]; 
		
		fullNames[0] = contacts[0].getFullName(); 
		
		
		Arrays.sort(fullNames); 
		
		String name = Person.getNameFromFullName( fullNames[0]); 
		
		
		Person person = findByFullName(name);
		
		listSort[0] = person; 
		
		
		return contacts;
	}
	
	private Person findByFullName(String fullName) {
		 Person personFound =null;  
		// TODO Auto-generated method stub	
		for(int i=0; i< contacts.length; i++){
			if(contacts[i].getFullName().equals(fullName)){
				personFound = contacts[i]; 
				break; 
			}
		}
		return personFound;
	}

	
	public Person[] list(){
		Person array[] = new Person[contacts.length];  
		int counter = 0;
		
		for(int i=0; i<contacts.length; i++){
			array[i]=array[i]; 
		}
		
		return array; 
	}
}
