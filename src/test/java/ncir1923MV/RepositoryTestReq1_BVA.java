package ncir1923MV;

import org.junit.Assert;
import org.junit.Test;

import ncir1923MV.model.Employee;
import ncir1923MV.enumeration.DidacticFunction;
import org.junit.Assert;
import org.junit.Test;
import ncir1923MV.repository.implementations.EmployeeImpl;

import java.util.ArrayList;
import java.util.List;

public class RepositoryTestReq1_BVA {

    EmployeeImpl employeeImpl = new EmployeeImpl();
    List<Employee> employeeList;

    @org.junit.Before
    public void setUp() throws Exception {

        employeeList = new ArrayList<Employee>();
        employeeList = employeeImpl.getEmployeeList();
    }

    @Test
    public void testAddEmployee1() throws Exception {
        String nume = "T";
        String prenume = "Ion";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "15";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }
    }

    @Test
    public void testAddEmployee2() throws Exception {
        String nume = "Ta";
        String prenume = "Ion";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "15";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }
    }

    @Test
    public void testAddEmployee() throws Exception {
        String nume = "Ram";
        String prenume = "Ion";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "15";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        Boolean added = employeeImpl.addEmployee(employee);
        Assert.assertEquals(added, Boolean.TRUE);

    }

    @Test
    public void testAddEmployee4() throws Exception {
        String nume = "";
        for (Integer i = 0; i < 254; i++) {
            char randomLetter = (char) ('a' + Math.random() * ('z' - 'a' + 1));
            nume += randomLetter;
        }
        String prenume = "Ion";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "15";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        Boolean added = employeeImpl.addEmployee(employee);
        Assert.assertEquals(added, Boolean.TRUE);

    }

    @Test
    public void testAddEmployee5() throws Exception {

        String nume = "";
        for (Integer i = 0; i < 255; i++) {
            char randomLetter = (char) ('a' + Math.random() * ('z' - 'a' + 1));
            nume += randomLetter;
        }
        String prenume = "Ion";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "15";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        Boolean added = employeeImpl.addEmployee(employee);
        Assert.assertEquals(added, Boolean.TRUE);
    }

    @Test
    public void testAddEmployee6() throws Exception {

        String nume = "";
        for (Integer i = 0; i < 256; i++) {
            char randomLetter = (char) ('a' + Math.random() * ('z' - 'a' + 1));
            nume += randomLetter;
        }
        String prenume = "Ion";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "15";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }

    }

    @Test
    public void testAddEmployee7() throws Exception {
        String nume = "Biga";
        String prenume = "I";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "15";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }
    }

    @Test
    public void testAddEmployee8() throws Exception {
        String nume = "Biga";
        String prenume = "Io";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "15";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }
    }

    @Test
    public void testAddEmployee9() throws Exception {
        String nume = "Biga";
        String prenume = "Ion";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "15";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        Boolean added = employeeImpl.addEmployee(employee);
        Assert.assertEquals(added, Boolean.TRUE);
    }

    @Test
    public void testAddEmployee10() throws Exception {
        String nume = "Biga";
        String prenume = "";

        for (Integer i = 0; i < 254; i++) {
            char randomLetter = (char) ('a' + Math.random() * ('z' - 'a' + 1));
            prenume += randomLetter;
        }
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "15";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        Boolean added = employeeImpl.addEmployee(employee);
        Assert.assertEquals(added, Boolean.TRUE);

    }

    @Test
    public void testAddEmployee11() throws Exception {

        String nume = "Biga";
        String prenume = "";

        for (Integer i = 0; i < 255; i++) {
            char randomLetter = (char) ('a' + Math.random() * ('z' - 'a' + 1));
            prenume += randomLetter;
        }
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "15";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        Boolean added = employeeImpl.addEmployee(employee);
        Assert.assertEquals(added, Boolean.TRUE);
    }


    @Test
    public void testAddEmployee12() throws Exception {

        String nume = "Biga";
        String prenume = "";

        for (Integer i = 0; i < 256; i++) {
            char randomLetter = (char) ('a' + Math.random() * ('z' - 'a' + 1));
            prenume += randomLetter;
        }
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "15";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }

    }

    @Test
    public void testAddEmployee13() throws Exception {
        String nume = "Biga";
        String prenume = "Ion";
        String cnp = null;
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "15";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), null);

        }


    }

    @Test
    public void testAddEmployee16() throws Exception {
        String nume = "Biga";
        String prenume = "Ion";
        String cnp = null;
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), null);

        }
    }

    @Test
    public void testAddEmployee26() throws Exception {
        String nume = "Biga";
        String prenume = "Ion";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = null;
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), null);

        }
    }

    @Test
    public void testAddEmployee33() throws Exception {
        String nume = "Biga";
        String prenume = "Ion";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = Integer.toString(Integer.MAX_VALUE + 1);
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }
    }
}
