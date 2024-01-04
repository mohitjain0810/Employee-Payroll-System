import java.util.*;
import java.lang.reflect.Array;

abstract class Employee {

   private String name;
   private int id;

   public Employee(String name, int id) {
      this.name = name;
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public int getId() {
      return id;
   }

   // Abstract method to be implemented by subclass
   public abstract double calculateSalary();

   @Override
   public String toString() {
      return "Employee[name = " + name + ", id = " + id + ", Salary = " + calculateSalary() + "]";
   }

}

class FullTimeEmployee extends Employee {

   private double mounthlySalary;

   public FullTimeEmployee(String name, int id, double mounthlySalary) {
      super(name, id);
      this.mounthlySalary = mounthlySalary;
   }

   @Override
   public double calculateSalary() {
      return mounthlySalary;
   }
}

class PatTimeEmployee extends Employee {

   private int hourseWorked;
   private double hourlyRate;

   public PatTimeEmployee(String name, int id, int hourseWorked, double hourlyRate) {
      super(name, id);
      this.hourseWorked = hourseWorked;
      this.hourlyRate = hourlyRate;
   }

   @Override
   public double calculateSalary() {
      return hourseWorked * hourlyRate;
   }
}

class PayRollSystem {
   private List<Employee> EmployeesList;

   public PayRollSystem() {
      EmployeesList = new ArrayList<>();
   }

   public void addEmplyee(Employee employee) {
      EmployeesList.add(employee);
   }

   public void removeEmployee(int id) {
      Employee employeeToRemove = null;
      for (Employee employee : EmployeesList) {
         if (employee.getId() == id) {
            employeeToRemove = employee;
            break;
         }
      }
      if (employeeToRemove != null) {
         EmployeesList.remove(employeeToRemove);
      }
   }

   public void displayEmployees() {
      for (Employee employee : EmployeesList) {
         System.out.println(employee);
      }
   }

}

public class Main {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      PayRollSystem payRollSystem = new PayRollSystem();

      System.out.print("Enter the number of Full-Time Employees: ");
      int numFullTimeEmployees = scanner.nextInt();
      for (int i = 0; i < numFullTimeEmployees; i++) {
         System.out.println("Enter details for Full-Time Employee " + (i + 1) + ":");
         System.out.print("Enter name: ");
         String ftName = scanner.next();
         System.out.print("Enter ID: ");
         int ftId = scanner.nextInt();
         System.out.print("Enter monthly salary: ");
         double ftMonthlySalary = scanner.nextDouble();
         FullTimeEmployee emp1 = new FullTimeEmployee(ftName, ftId, ftMonthlySalary);
         payRollSystem.addEmplyee(emp1);
      }

      System.out.print("Enter the number of Part-Time Employees: ");
      int numPartTimeEmployees = scanner.nextInt();
      for (int i = 0; i < numPartTimeEmployees; i++) {
         System.out.println("Enter details for Part-Time Employee " + (i + 1) + ":");
         System.out.print("Enter name: ");
         String ptName = scanner.next();
         System.out.print("Enter ID: ");
         int ptId = scanner.nextInt();
         System.out.print("Enter hours worked: ");
         int ptHoursWorked = scanner.nextInt();
         System.out.print("Enter hourly rate: ");
         double ptHourlyRate = scanner.nextDouble();
         PatTimeEmployee emp2 = new PatTimeEmployee(ptName, ptId, ptHoursWorked, ptHourlyRate);
         payRollSystem.addEmplyee(emp2);
      }

      System.out.println("Employee Details: ");
      payRollSystem.displayEmployees();

      // Additional logic for removing an employee
      System.out.println("Removing an Employee");
      System.out.print("Enter ID of the employee to remove: ");
      int idToRemove = scanner.nextInt();
      payRollSystem.removeEmployee(idToRemove);

      System.out.println("Remaining Employees Details: ");
      payRollSystem.displayEmployees();

      // Close the scanner
      scanner.close();
   }
}