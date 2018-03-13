package ncir1923MV.repository.interfaces;


import ncir1923MV.exception.EmployeeException;
import ncir1923MV.model.Employee;

import java.util.List;

public interface EmployeeRepositoryInterface {
	
	boolean addEmployee(Employee employee);
	void deleteEmployee(Employee employee) throws EmployeeException;
	void modifyEmployee(Employee oldEmployee, Employee newEmployee) throws EmployeeException;
	List<Employee> getEmployeeList();
	List<Employee> getEmployeeByCriteria(String criteria);
	Employee getEmployeeByCnp(String cnp) throws EmployeeException;
}
