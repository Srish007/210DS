package com.mph.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.mph.dao.EmployeeDao;
import com.mph.dao.EmployeeDaoImpl;
import com.mph.model.Employee;
import com.mph.model.Salary;

public class EmployeeController implements EmployeeInterface {
	Employee emp;
	Salary sal = new Salary();
	Scanner sc = new Scanner(System.in);
	List<Employee> emplist = new ArrayList<Employee>();
	EmployeeDao dao = new EmployeeDaoImpl();

	public void addEmployee() {
		emp = new Employee();
		System.out.println("Enter your Name:");
		String name = sc.next();
		emp.setEname(name);

		System.out.println("Enter Basic");
		int basic = sc.nextInt();
		sal.setBasic(basic);

		System.out.println("Enter Da");
		int da = sc.nextInt();
		sal.setDa(da);

		System.out.println("Enter HRA");
		int hra = sc.nextInt();
		sal.setHra(hra);

		System.out.println("Enter PF");
		int pf = sc.nextInt();
		sal.setPf(pf);

		sal.setGross();
		sal.setNet();

		emp.setSalary(sal);
		emplist.add(emp);
		
		System.out.println("Employee Details Added Successfully");
		dao.createEmployee(emp);
		System.out.println("Employee added Successfully to DB");

	}

	public void viewEmployee() {

		// System.out.println(emp.getEname() + " " + emp.getSalary());
		Iterator i = emplist.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		
		dao.viewEmployee();
	}

	@Override
	public void sortEmployeeByName() {

	}

	@Override
	public void serializeEmp() throws IOException {
		try {

			FileOutputStream fos = new FileOutputStream("myfile210.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(emplist);
			System.out.println("Serialized to file myfile210.txt");
			oos.close();
			fos.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("No file");
		}
	}

	@Override
	public void deserializeEmp() throws IOException {
		try {

			FileInputStream fis = new FileInputStream("myfile210.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			List<Employee> elist = (List<Employee>) ois.readObject();

			System.out.println("DeSerilized from file myfile210.txt");
			Iterator i = elist.iterator();
			while (i.hasNext()) {
				System.out.println(i.next());
			}
			ois.close();
			fis.close();
		} catch (FileNotFoundException fnf) {
			System.out.println("No file");
		} catch (ClassNotFoundException cnf) {
			System.out.println("No Emp class");
		}

	}
}	
