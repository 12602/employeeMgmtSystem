package com.example.demo.controller;

import java.awt.datatransfer.SystemFlavorMap;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmpRepo;
@Controller
public class EmpContoller {
	
@Autowired
EmpRepo rep;
	//this method will run when we hit run when we visit home page 
	@GetMapping("/home")
	public String home(Model m)
	{
	 
		List<Employee>e=new ArrayList<>();
	Iterable <Employee>emp=	rep.findEmp();
	 for(Employee em:emp)
	 {
		 e.add(em);
	 }
	 m.addAttribute("employee", e);
	 
	return "index";
	}
	
	//this method will run when we hit rquest for adding emplooye from home page 
	@GetMapping("/add")
	public String response( )
	{
		
		
	//	rep.addEmp(emp);
		return "AddEmp";
	}
	
	
	//this method will run we hit request to add new employee
	
	@PostMapping("/register")
	 	public String addUser(@ModelAttribute("employee") Employee emp)
		{
		
		   rep.addEmp(emp);
		       
		    return "redirect:/home";
		}
	
	@GetMapping("/employees")
	public List<Employee>getAllEmp()
	{
	
		
		return  rep.findEmp();
	}
	int empId=0;
	//this method will give us update employee id so we can find it
	
	
	@GetMapping("/edit/{id}")
	public String updateEmp(@PathVariable("id")String id,Model m)
	{
		
		int i=Integer.parseInt(id);
	   empId=i;
		
	   
		Employee e=rep.findById(i);
	           
		  m.addAttribute("name",e.getName());
		m.addAttribute("id",e.getId());
		m.addAttribute("phone", e.getPhone());
		m.addAttribute("address",e.getAddress());
		m.addAttribute("email",e.getEmail());
		return "update";
	
	
	}
	
       //this method is fire when we get request from update page
	
	@PostMapping("/update")
 	public String updateUse(@ModelAttribute("employee") Employee emp)
	{
	
		
	         emp.setId(empId);
	         System.out.print(emp);
	 		
	   rep.updateById(emp);
	       
	    return "redirect:/home";
	}

	
	
	
	//deleting a employee 
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable("id")String id)
	{
	
		int i=Integer.parseInt(id);
	
		System.out.print(id);
	      
		rep.deleteById(i);
		
		
		return "redirect:/home";
	}
	
	
	
}
