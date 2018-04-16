package ncir1923MV;

import ncir1923MV.enumeration.DidacticFunction;
import ncir1923MV.model.Employee;
import ncir1923MV.repository.implementations.EmployeeImpl;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class RepositoryTestReq2_WBT {
    EmployeeImpl employeeImpl = new EmployeeImpl();
    List<Employee> employeeList;

    @org.junit.Before
    public void setUp() throws Exception {
        employeeList = new ArrayList<Employee>();
        employeeList = employeeImpl.getEmployeeList();

    }

    @org.junit.Test
    public void testModifyEmployeeTest1() throws Exception {
        String nume = "Ionescu";
        String prenume = "Andrei";
        String cnp = "1934567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "2546";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);
        Employee newemployee = new Employee(nume, prenume, cnp, function, "986");
        Employee findEmployee = employeeImpl.getEmployeeByCNP(cnp);
        if (findEmployee != null) {
            employeeImpl.modifyEmployee(employee, newemployee);
            employee = employeeImpl.getEmployeeByCNP(cnp);
            Assert.assertEquals(employee.getSalary(), "986");
        }
    }

    @org.junit.Test
    public void testModifyEmployeeTest2() throws Exception {
        String nume = "Ionescu";
        String prenume = "Andrei";
        String cnp = "1934567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "2546";
        Employee oldEmployee = new Employee(nume, prenume, cnp, function, salariu);

        Employee newEmployee = new Employee("Ed", prenume, cnp, function, salariu);

        try {
            employeeImpl.modifyEmployee(oldEmployee, newEmployee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }

    }

    @org.junit.Test
    public void testModifyEmployeeTest3() throws Exception {
        String nume = "Voicu";
        String prenume = "Andrei";
        String cnp = "1984567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        DidacticFunction newfunction = DidacticFunction.LECTURER;
        String salariu = "2546";
        Employee oldEmployee = new Employee(nume, prenume, cnp, function, salariu);

        Employee newEmployee = new Employee(nume, prenume, "0000000000000", newfunction, salariu);

        try {
            employeeImpl.modifyEmployee(oldEmployee, newEmployee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee doesn't exist!");

        }

    }
}
