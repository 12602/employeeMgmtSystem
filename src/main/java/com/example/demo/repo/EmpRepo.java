package com.example.demo.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmpImpl;
@Repository
public class EmpRepo 
{
	
	@Autowired
	private EmpImpl empImp;
	public List<Employee> findEmp()
	{
		List<Employee>emp=new ArrayList<>();
		Iterable<Employee>it=empImp.findAll();
	       for(Employee e:it)
	       {
	    	  emp.add(e);   
	       }
	       return emp;
	}
	public Employee addEmp(Employee e)
	{
		
		empImp.save(e);
		
		return e;
	}
	
	
	
	// it returns a record when matches 
	public  Employee findById(int id)
	{
		Iterable<Employee> emp=empImp.findAll();
	   
		for(Employee e:emp)
	     {
			if(e.getId()==id)
			return e;
	    	
	     }
	
	    
	       return null;
	
	}
	

	// it deletes the table if the given record was found

	public  void deleteById(int id)
	{
		empImp.deleteById(id);
		

	
	}
	
	
	
	
	
	// it updates the table if the given record was found
	public  void updateById(Employee empl)
	{
		Iterable<Employee> emp=empImp.findAll();
	    List<Employee>newEmp=new ArrayList<>(); 
		for(Employee e:emp)
	     {
			if(e.getId()==empl.getId())
				{
				
				 e.setId(empl.getId());
				 e.setName(empl.getName());
				 e.setEmail(empl.getEmail());
				 e.setPhone(empl.getPhone());
				
			   }
			newEmp.add(e);
			
		
	     }
	
	       empImp.saveAll(newEmp);
	       
	}

}
