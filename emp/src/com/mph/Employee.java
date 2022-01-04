package com.mph;

public class Employee {
	private String ename;
	private int salary;

	public void setEname(String ename)
	 {
		 this.ename=ename;
	 }
	 public String getEname()
	 {
		 return ename;
	 }	 
	 public void setSalary(int salary) {
		 this.salary=salary;
	 }
	 
	 public int getSalary()
	 {
		 return salary;
	 }
	 
	 public String toString()
	 {
		 return "Employee  [ " + this.ename +"  " + this.salary+  "  ]";
	 }
	 

}
