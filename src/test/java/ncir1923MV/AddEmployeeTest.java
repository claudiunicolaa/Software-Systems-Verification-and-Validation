package ncir1923MV;

import ncir1923MV.controller.EmployeeController;
import ncir1923MV.enumeration.DidacticFunction;
import ncir1923MV.model.Employee;
import ncir1923MV.repository.interfaces.EmployeeRepositoryInterface;
import ncir1923MV.repository.mock.EmployeeMock;
import ncir1923MV.validator.EmployeeValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddEmployeeTest {

    private EmployeeRepositoryInterface employeeRepository;
    private EmployeeController controller;
    private EmployeeValidator employeeValidator;

    @Before
    public void setUp() {
        employeeRepository = new EmployeeMock();
        controller = new EmployeeController(employeeRepository);
        employeeValidator = new EmployeeValidator();
    }

    @Test
    public void testRepositoryMock() {
        assertFalse(controller.getEmployeesList().isEmpty());
        assertEquals(6, controller.getEmployeesList().size());
    }

    @Test
    public void testAddNewEmployee() {
        Employee newEmployee = new Employee("ValidLastName", "1910509055057", DidacticFunction.ASISTENT, "3000");
        assertTrue(employeeValidator.isValid(newEmployee));
        controller.addEmployee(newEmployee);
        assertEquals(7, controller.getEmployeesList().size());
        assertTrue(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));
    }

}
