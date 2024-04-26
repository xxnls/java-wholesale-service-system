package human_resources;

import java.util.ArrayList;

public class HumanResources {
    private static ArrayList<Employee> employees;

    static {
        employees = new ArrayList<>();
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void addOfficeEmployee(String firstName, String lastName, String phoneNumber, String email, String dateOfStart, int salary, String responsibleFor) {
        employees.add(new OfficeWorker(firstName, lastName, phoneNumber, email, dateOfStart, salary, responsibleFor));
    }

    public static void addWarehouseEmployee(String firstName, String lastName, String phoneNumber, String email, String dateOfStart, int salary, String responsibleFor) {
        employees.add(new WarehouseWorker(firstName, lastName, phoneNumber, email, dateOfStart, salary, responsibleFor));
    }
    public static void addDriverEmployee(String firstName, String lastName, String phoneNumber, String email, String dateOfStart, int salary, String workPhoneNumber) {
        employees.add(new Driver(firstName, lastName, phoneNumber, email, dateOfStart, salary, workPhoneNumber));
    }

    public static void printAllEmployees() {
        if(getHowManyEmployees() == 0)
            System.out.println("Employee list is empty.");
        else
            for(Employee employee : employees) {
                employee.printEmployee();
                System.out.println();
            }
    }

    //returns how many employees are hired
    public static int getHowManyEmployees() {
        return employees.size();
    }

    //method that returns how many categories of employees are in the list
    public static int getHowManyDistinctJobs() {
        ArrayList<String> jobs = new ArrayList<>();

        for(Employee emp : employees) {
            if(!jobs.contains(emp.getClass().getSimpleName())) {
                jobs.add(emp.getClass().getSimpleName());
            }
        }

        return jobs.size();
    }

    //method that prints out how many employees of each category are in the list
    public static void printHowManySpecifiedEmployees() {
        String[][] tab = new String[getHowManyDistinctJobs()][2];

        for(int i=0; i<getHowManyEmployees(); i++) {
            boolean exists = false;
            for(int j=0; j<getHowManyDistinctJobs(); j++) {
                if(employees.get(i).getClass().getSimpleName().equals(tab[j][0])) {
                    exists = true;
                    tab[j][1] = Integer.toString(Integer.parseInt(tab[j][1]) + 1);
                }
            }

            if(!exists) {
                for(int j=0; j<getHowManyDistinctJobs(); j++) {
                    if(tab[j][0] == null) {
                        tab[j][0] = employees.get(i).getClass().getSimpleName();
                        tab[j][1] = "1";
                        break;
                    }
                }
            }
        }

        for(int j=0; j<getHowManyDistinctJobs(); j++) {
            System.out.println(tab[j][0] + " = " + tab[j][1]);
        }
    }


}
