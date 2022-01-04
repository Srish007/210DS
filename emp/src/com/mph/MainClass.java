package com.mph;

import java.lang.*;

public class MainClass {

	public static void main(String[] args) {

		Employee emp= new Employee();
		emp.setEname("Srish");
		emp.setSalary(20000);
		System.out.println(emp.getEname()+" "+emp.getSalary());
		Employee emp1= new Employee();
		emp1.setEname("Sanket");
		emp1.setSalary(21000);
		System.out.println(emp1.getEname()+" "+emp1.getSalary());
		
	
		
	}

}

