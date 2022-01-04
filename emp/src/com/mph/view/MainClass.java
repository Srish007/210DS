package com.mph.view;

import java.lang.*;
import java.util.Scanner;

import com.mph.controller.EmployeeController;
import com.mph.controller.EmployeeInterface;
import com.mph.exception.UserNotFoundException;
import com.mph.model.Employee;
import java.io.*;

public class MainClass {

	public static void displayChoices() {
		Scanner sc = new Scanner(System.in);
		EmployeeInterface ec = new EmployeeController();
		String c = null;
		do {
			System.out.println("Enter your Choice :");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Sort Employee byName");
			System.out.println("4. Serialize Employee");
			System.out.println("5. De-Serialize Employee");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				ec.addEmployee();
				break;
			}
			case 2: {
				ec.viewEmployee();
				break;
			}
			case 3: {
				ec.sortEmployeeByName();
				break;
			}
			case 4: {
				try {
					ec.serializeEmp();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			
			case 5: {
				try {
					ec.deserializeEmp();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			default: {
				System.out.println("Choose the right choice !!!");
			}
			}
			System.out.println("Do you want to continue? Y or y");
			c = sc.next();
		} while (c.equals("y") || c.equals("Y"));
		System.out.println("Exited from application.");
		System.exit(0);
	}

	public static boolean validateUser() {
	
	try {
			String un, pw;

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter Username");
			un = br.readLine();
			System.out.println("Enter password");
			pw = br.readLine();

			if (un.equals("Srish") && pw.equals("sri")) {
				System.out.println("Welcome " + un);
				
				return true;
			} else {
				throw new UserNotFoundException();
			}
		} catch (UserNotFoundException unfe) {
			System.out.println(unfe);
			//unfe.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("From Finally");
		}
		return false;
		
	}

	public static void main(String[] args) {
		System.out.println("Hi All");
		for(int i=1;i<=3;i++)
		{
			System.out.println(validateUser());
				if(validateUser()) {
					displayChoices();
					break;
				}
				else
				{
					 System.out.println("Invalid User :(");
				}
				
		}
		
	}

}
