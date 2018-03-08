package ncir1923MV.controller;

import ncir1923MV.model.Employee;
import ncir1923MV.repository.interfaces.EmployeeRepositoryInterface;

import java.util.List;

public class EmployeeController {

    private EmployeeRepositoryInterface employeeRepository;

    public EmployeeController(EmployeeRepositoryInterface employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    public List<Employee> getEmployeesList() {
        return employeeRepository.getEmployeeList();
    }

    public void modifyEmployee(Employee oldEmployee, Employee newEmployee) {
        employeeRepository.modifyEmployee(oldEmployee, newEmployee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.deleteEmployee(employee);
    }

}
