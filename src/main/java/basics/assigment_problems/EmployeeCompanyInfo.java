package main.java.basics.assigment_problems;

public class EmployeeCompanyInfo {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeCompanyInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        EmployeeCompanyInfo employee1 =
                new EmployeeCompanyInfo("Ravi", 40000);

        EmployeeCompanyInfo employee2 =
                new EmployeeCompanyInfo("Anitha", 50000);

        EmployeeCompanyInfo employee3 =
                new EmployeeCompanyInfo("Karthik", 45000);

        EmployeeCompanyInfo.printCompanyInfo();
    }
}