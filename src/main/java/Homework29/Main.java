package Homework29;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        employeeDAO.addEmployee("Ivan Biliak", 18, "Software Engineer", 5000.0f);
        employeeDAO.addEmployee("Dmytro Byriatynskii", 19, "Data Analyst", 4500.0f);

        System.out.println("All Employees:");
        employeeDAO.getAllEmployees().forEach(System.out::println);

        employeeDAO.updateEmployee(1, "Daryna Zui", 21, "Senior Software Engineer", 6000.0f);

        employeeDAO.deleteEmployee(2);

        System.out.println("Updated Employees:");
        employeeDAO.getAllEmployees().forEach(System.out::println);
    }
}
