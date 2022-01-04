package com.mph.controller;

import java.io.IOException;

public interface EmployeeInterface {
	public void addEmployee();
	public void viewEmployee();
	public void sortEmployeeByName();
	public void serializeEmp() throws IOException;
	public void deserializeEmp() throws IOException;
}
