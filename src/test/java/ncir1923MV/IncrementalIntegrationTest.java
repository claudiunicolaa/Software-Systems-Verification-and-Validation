package ncir1923MV;

import org.junit.Assert;
import org.junit.Test;
import ncir1923MV.model.Employee;
import ncir1923MV.enumeration.DidacticFunction;
import ncir1923MV.repository.implementations.EmployeeImpl;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class IncrementalIntegrationTest {

    private static final String EMPTY = "";
    private static final String NUME = "Florea";
    private static final String PRENUME = "Andrei";
    private static final String CNP = "2890502047863";
    private static final DidacticFunction FUNCTION = DidacticFunction.ASISTENT;
    private static final String SALARIU = "87";

    EmployeeImpl employeeImpl = new EmployeeImpl("employeeDB/employees_test.txt");
    List<Employee> employeeList;

    @org.junit.Before
    public void setUp() throws Exception {
        employeeList = new ArrayList<>();
        employeeList = employeeImpl.getEmployeeList();

    }

    @Test
    public void testA() throws Exception {
        Employee employee = new Employee(NUME, PRENUME, CNP, FUNCTION, SALARIU);
        Boolean added = employeeImpl.addEmployee(employee);
        Assert.assertEquals(added, Boolean.TRUE);


        employee = new Employee(EMPTY, PRENUME, CNP, FUNCTION, SALARIU);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");
        }

        employee = new Employee("Ram", "Ion", CNP, FUNCTION, SALARIU);
        added = employeeImpl.addEmployee(employee);
        Assert.assertEquals(added, Boolean.TRUE);

        employee = new Employee("T", "Ion", CNP, FUNCTION, SALARIU);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }
    }

    @Test
    public void testB() throws Exception {
        testA();
        Employee employee = new Employee(NUME, PRENUME, CNP, FUNCTION, SALARIU);
        Employee newemployee = new Employee(NUME, PRENUME, CNP, FUNCTION, "986");
        Employee findEmployee = employeeImpl.getEmployeeByCNP(CNP);
        if (findEmployee != null) {
            employeeImpl.modifyEmployee(employee, newemployee);
            employee = employeeImpl.getEmployeeByCNP(CNP);
            Assert.assertEquals(employee.getSalary(), "986");
        }


        Employee oldEmployee = new Employee(NUME, PRENUME, CNP, FUNCTION, SALARIU);
        Employee newEmployee = new Employee("Ed", PRENUME, CNP, FUNCTION, SALARIU);
        try {
            employeeImpl.modifyEmployee(oldEmployee, newEmployee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }
    }


    @Test
    public void testC() throws Exception {
        testB();
        employeeImpl.clear();
        Employee employee = new Employee(NUME, PRENUME, CNP, FUNCTION, SALARIU);
        employeeImpl.addEmployee(employee);
        Employee employee2 = new Employee(NUME, PRENUME, "2951205011150", FUNCTION, String.valueOf(Integer.valueOf(SALARIU) - 10));
        employeeImpl.addEmployee(employee2);
        List<Employee> sortedEmployee = employeeImpl.getEmployeeByCriteria("salary");
        assert (sortedEmployee.get(1).getCnp().equals(CNP));


        employeeImpl.clear();
        employeeImpl.addEmployee(employee);
        sortedEmployee = employeeImpl.getEmployeeByCriteria("salary");
        assertThat(sortedEmployee.size(), equalTo(1));
        assert (sortedEmployee.get(0).getCnp().equals(employee.getCnp()));
    }


}
