package ncir1923MV.view;

import ncir1923MV.controller.EmployeeController;
import ncir1923MV.enumeration.DidacticFunction;
import ncir1923MV.exception.EmployeeException;
import ncir1923MV.model.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeView {
    private EmployeeController employeeController;

    public EmployeeView(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void start() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            displayMenu();
            try {
                String input = br.readLine();
                switch (input) {
                    case "0": {
                        System.out.println("Exiting app");
                        break;
                    }
                    case "1": {
                        addEmployee();
                        break;
                    }

                    case "2": {
                        editEmployee();
                        break;
                    }

                    case "3": {
                        displayEmployeeList();
                        break;
                    }

                    case "4": {
                        deleteEmployee();
                        break;
                    }

                    default: {
                        System.out.println("Wrong input! Try again...");
                    }
                }
                if (input.equals("0")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void editEmployee() {
        String firstName = null, lastName = null, cnp = null, newFistName = null;
        String newLastName = null, newCnp = null, functionId = null, newSalary = null;
        DidacticFunction function = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        System.out.print("CNP: ");
        try {
            cnp = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Employee oldEmployee = null;
        try {
            oldEmployee = employeeController.searchByCnp(cnp);
        } catch (EmployeeException e) {
            System.err.println(e.getMessage());
            return;
        }

        System.out.print("\nFirst name: ");
        try {
            newFistName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("\nLast name: ");
        try {
            newLastName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("\nSalary: ");
        try {
            newSalary = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("\nFunction 1-Asistent, 2-Lecturer, 3-Teacher, 4-Phd, 5-CAD: ");
        try {
            functionId = br.readLine();
            switch (functionId) {
                case "1": {
                    function = DidacticFunction.ASISTENT;
                    break;
                }
                case "2": {
                    function = DidacticFunction.LECTURER;
                    break;
                }
                case "3": {
                    function = DidacticFunction.TEACHER;
                    break;
                }
                case "4": {
                    function = DidacticFunction.PHD;
                    break;
                }
                case "5": {
                    function = DidacticFunction.CAD;
                    break;
                }
                default: {
                    System.err.println("Nu ati introdus o functie valida, reincercati!");
                    return;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Employee newEmployee = new Employee(newFistName, newLastName, cnp, function, newSalary);
        try {
            employeeController.modifyEmployee(oldEmployee, newEmployee);
        } catch (EmployeeException e) {
            System.err.println(e.getMessage());
            return;
        }
    }

    private void deleteEmployee() {
        String cnp = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("CNP: ");
        try {
            cnp = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            employeeController.deleteEmployee(employeeController.searchByCnp(cnp));
        } catch (EmployeeException e) {
            System.err.println(e.getMessage());
        }
    }

    private void addEmployee() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstName = null, lastName = null, cnp = null, function_id, salary = null;
        DidacticFunction function = null;
        System.out.print("First name: ");
        try {
            firstName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("\nLast name: ");
        try {
            lastName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("\nCNP: ");
        try {
            cnp = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("\nFunction 1-Asistent, 2-Lecturer, 3-Teacher, 4-Phd, 5-CAD: ");
        try {
            function_id = br.readLine();
            switch (function_id) {
                case "1": {
                    function = DidacticFunction.ASISTENT;
                    break;
                }
                case "2": {
                    function = DidacticFunction.LECTURER;
                    break;
                }
                case "3": {
                    function = DidacticFunction.TEACHER;
                    break;
                }
                case "4": {
                    function = DidacticFunction.PHD;
                    break;
                }
                case "5": {
                    function = DidacticFunction.CAD;
                    break;
                }

                default: {
                    System.err.println("Nu ati introdus o functie valida, reincercati!");
                    return;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("\nSalary: ");
        try {
            salary = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Employee e = new Employee(firstName, lastName, cnp, function, salary);
        employeeController.addEmployee(e);
        for (Employee _employee : employeeController.getEmployeesList())
            System.out.println(_employee.toString());
    }

    private void displayEmployeeList() {
        System.out.println("\n\n\n1.Unordered employees");
        System.out.println("2.Salary orderred");
        System.out.println("3.Age orderred");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = br.readLine();
            switch (input) {
                case "1": {
                    for (Employee _employee : employeeController.getEmployeesList())
                        System.out.println(_employee.toString());
                    System.out.println("-----------------------------------------");
                    break;
                }

                case "2": {
                    for (Employee _employee : employeeController.getOrderedEmployees("salary"))
                        System.out.println(_employee.toString());
                    System.out.println("-----------------------------------------");
                    break;
                }

                case "3": {
                    for (Employee _employee : employeeController.getOrderedEmployees("age"))
                        System.out.println(_employee.toString());
                    System.out.println("-----------------------------------------");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void displayMenu() {
        System.out.println("~Menu~");
        System.out.println("1. Add new Employee");
        System.out.println("2. Modify Employee");
        System.out.println("3. Display Employee list");
        System.out.println("4. Delete Employee");
        System.out.println("0. Exit");
        System.out.print("Command: ");
    }
}

