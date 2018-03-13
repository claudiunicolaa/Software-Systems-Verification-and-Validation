package ncir1923MV.repository.mock;


import ncir1923MV.enumeration.DidacticFunction;
import ncir1923MV.model.Employee;
import ncir1923MV.repository.interfaces.EmployeeRepositoryInterface;
import ncir1923MV.validator.EmployeeValidator;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMock implements EmployeeRepositoryInterface {

	private List<Employee> employeeList;
	private EmployeeValidator employeeValidator;
	
	public EmployeeMock() {
		
		employeeValidator = new EmployeeValidator();
		employeeList = new ArrayList<Employee>();
		
		Employee Ionel   = new Employee("Alin","Pacuraru", "1234567890876", DidacticFunction.ASISTENT, "2500");
		Employee Mihai   = new Employee("Dan","Dumitrescu", "1234567890876", DidacticFunction.LECTURER, "2500");
		Employee Ionela  = new Employee("Catalin","Ionescu", "1234567890876", DidacticFunction.LECTURER, "2500");
		Employee Mihaela = new Employee("Alin","Pacuraru", "1234567890876", DidacticFunction.ASISTENT, "2500");
		Employee Vasile  = new Employee("Mihai","Georgescu", "1234567890876", DidacticFunction.TEACHER,  "2500");
		Employee Marin   = new Employee("Codrut","Puscas", "1234567890876", DidacticFunction.TEACHER,  "2500");
		
		employeeList.add( Ionel );
		employeeList.add( Mihai );
		employeeList.add( Ionela );
		employeeList.add( Mihaela );
		employeeList.add( Vasile );
		employeeList.add( Marin );
	}
	
	@Override
	public boolean addEmployee(Employee employee) {
		if ( employeeValidator.isValid(employee)) {
			employeeList.add(employee);
			return true;
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
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeeByCriteria(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByCnp(String cnp) {
		return null;
	}

}
