package ncir1923MV;

import org.junit.Assert;
import ncir1923MV.model.Employee;
import ncir1923MV.enumeration.DidacticFunction;
import org.junit.Assert;
import ncir1923MV.repository.implementations.EmployeeImpl;

import java.util.ArrayList;
import java.util.List;

public class RepositoryTestReq1_EP {


    EmployeeImpl employeeImpl = new EmployeeImpl();
    List<Employee> employeeList;

    @org.junit.Before
    public void setUp() throws Exception {

        employeeList = new ArrayList<Employee>();
        employeeList = employeeImpl.getEmployeeList();
    }

    @org.junit.Test
    public void testAddEmployeeTest1() throws Exception {
        String nume = "Popescu";
        String prenume = "Adrian";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.ASISTENT;
        String salariu = "1700";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        Boolean added = employeeImpl.addEmployee(employee);
        Assert.assertEquals(added, Boolean.TRUE);

    }

    @org.junit.Test
    public void testAddEmployeeTest2() throws Exception {
        String nume = "Florea";
        String prenume = "Cristina";
        String cnp = "2034557890173";
        DidacticFunction function = DidacticFunction.LECTURER;
        String salariu = "11";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        Boolean added = employeeImpl.addEmployee(employee);
        Assert.assertEquals(added, Boolean.TRUE);

    }


    @org.junit.Test
    public void testAddEmployeeTest3() throws Exception {
        String nume = "Marin";
        String prenume = "Marin";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.CAD;
        String salariu = "17";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        Boolean added = employeeImpl.addEmployee(employee);
        Assert.assertEquals(added, Boolean.TRUE);
    }

    @org.junit.Test
    public void testAddEmployeeTest4() throws Exception {
        String nume = "Gaia";
        String prenume = "Alinna";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.TEACHER;
        String salariu = "8736";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        Boolean added = employeeImpl.addEmployee(employee);
        Assert.assertEquals(added, Boolean.TRUE);


    }

    @org.junit.Test
    public void testAddEmployeeTest5() throws Exception {
        String nume = "";
        String prenume = "Florin";
        String cnp = "8754210236458";
        DidacticFunction function = DidacticFunction.CAD;
        String salariu = "87";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }

    }

    @org.junit.Test
    public void testAddEmployeeTest6() throws Exception {
        String nume = "Ra";
        String prenume = "Florin";
        String cnp = "8754210236458";
        DidacticFunction function = DidacticFunction.CAD;
        String salariu = "87";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }

    }

    @org.junit.Test
    public void testAddEmployeeTest7() throws Exception {
        String nume = "Manu";
        String prenume = "";
        String cnp = "8754210236458";
        DidacticFunction function = DidacticFunction.CAD;
        String salariu = "88";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }

    }


    @org.junit.Test
    public void testAddEmployeeTest8() throws Exception {
        String nume = "Manu";
        String prenume = "G";
        String cnp = "8754210236458";
        DidacticFunction function = DidacticFunction.CAD;
        String salariu = "88";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }

    }


    @org.junit.Test
    public void testAddEmployeeTest9() throws Exception {
        String nume = "Benchea";
        String prenume = "Vlad";
        String cnp = "8er7542106458";
        DidacticFunction function = DidacticFunction.TEACHER;
        String salariu = "2";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }
    }

    @org.junit.Test
    public void testAddEmployeeTest10() throws Exception {
        String nume = "Benchea";
        String prenume = "Vlad";
        String cnp = "123";
        DidacticFunction function = DidacticFunction.TEACHER;
        String salariu = "5432";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }

    }


    @org.junit.Test
    public void testAddEmployeeTest12() throws Exception {
        String nume = "Benchea";
        String prenume = "Vlad";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.TEACHER;
        String salariu = "tyr6";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");
        }

    }

    @org.junit.Test
    public void testAddEmployeeTest13() throws Exception {
        String nume = "Benchea";
        String prenume = "Vlad";
        String cnp = "1234567890123";
        DidacticFunction function = DidacticFunction.TEACHER;
        String salariu = "-25";
        Employee employee = new Employee(nume, prenume, cnp, function, salariu);

        try {
            employeeImpl.addEmployee(employee);
        } catch (Exception ex) {
            Assert.assertEquals(ex.getMessage(), "Employee it's not valid");

        }

    }
}

