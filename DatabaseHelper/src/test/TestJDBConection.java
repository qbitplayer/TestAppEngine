package test;

import java.util.ArrayList;

import org.junit.Test;

import dao.Dao;

public class TestJDBConection {
	
	//@Test
	public void testConnection(){
		Dao dao = new Dao();    
		
		try {
			dao.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			dao.close();
		}
		
		
	}
	
	
	//@Test
	public void testInsert(){
		Dao dao = new Dao();    
		
		try {
			dao.connect();
			dao.insert("Perro","gato","caballo" );
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally{
			dao.close();
		} 
		
	}
	
	//@Test
	public void testSelect(){
		Dao dao = new Dao();    
		
		try {
			dao.connect();
			dao.insert("Perro","gato","caballo" );
			dao.select(1); 
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally{
			dao.close();
		} 
		
	}
	
	
	//@Test
	public void testDelete(){
		Dao dao = new Dao();    
		
		try {
			dao.connect();
			int id = dao.insert("Perro","gato","caballo" );
			dao.delete(id); 
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally{
			dao.close();
		} 
		
	}

	
	//@Test
	public void testDeleteAll(){
		Dao dao = new Dao();    
		
		try {
			dao.connect();
			dao.insert("Perro","gato","caballo" );
			dao.deleteAll(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			dao.close();
		} 
		
	}
	
	
	@Test
	public void array(){
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		
		list.add(4); 
		list.add(5); 
		list.add(6); 
		
		
	}


}
