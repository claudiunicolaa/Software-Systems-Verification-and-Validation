package ncir1923MV.repository.implementations;


import ncir1923MV.exception.EmployeeException;
import ncir1923MV.model.Employee;
import ncir1923MV.repository.interfaces.EmployeeRepositoryInterface;
import ncir1923MV.validator.EmployeeValidator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl implements EmployeeRepositoryInterface {
	
	private final String employeeDBFile = "employeeDB/employees.txt";
	private EmployeeValidator employeeValidator = new EmployeeValidator();

	@Override
	public boolean addEmployee(Employee employee) {
		if( employeeValidator.isValid(employee) ) {
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(employeeDBFile, true));
				bw.write(employee.toString());
				bw.newLine();
				bw.close();
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyEmployee(Employee oldEmployee, Employee newEmployee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getEmployeeList() {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(employeeDBFile));
			String line;
			int counter = 0;
			while ((line = br.readLine()) != null) {
				Employee employee = new Employee();
				try {
					employee = Employee.getEmployeeFromString(line, counter);
					employeeList.add(employee);
				} catch(EmployeeException ex) {
					System.err.println("Error while reading: " + ex.toString());
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error while reading: " + e);
		} catch (IOException e) {
			System.err.println("Error while reading: " + e);
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (IOException e) {
					System.err.println("Error while closing the file: " + e);
				}
		}
		
		return employeeList;
	}


	@Override
	public List<Employee> getEmployeeByCriteria(String criteria) {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		return employeeList;
	}

}
