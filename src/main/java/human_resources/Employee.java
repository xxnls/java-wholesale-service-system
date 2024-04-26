package human_resources;

import interfaces.WhatClass;

import java.time.LocalDate;

import static human_resources.HumanResources.getEmployees;


public abstract class Employee implements WhatClass {
    private static int employeeCounter;
    private int employeeID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfStart;
    private int numberOfOrdersDone;
    private int salary;

    static {
        employeeCounter = 0;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumberOfOrdersDone() {
        return numberOfOrdersDone;
    }

    public void setNumberOfOrdersDone(int numberOfOrdersDone) {
        this.numberOfOrdersDone = numberOfOrdersDone;
    }

    //date needs to be put in format yyyy/mm/dd
    public Employee(String firstName, String lastName, String phoneNumber, String email, String dateOfStart, int salary) {
        employeeID = employeeCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfStart = LocalDate.of(Integer.parseInt(dateOfStart.substring(0,4)), Integer.parseInt(dateOfStart.substring(5,7)), Integer.parseInt(dateOfStart.substring(8, 10)));
        this.numberOfOrdersDone = 0;
        this.salary = salary;
        employeeCounter++;
    }

    @Override
    public String toString() {
        return  "Employee ID: #" + employeeID +
                "\nProfession: " + WhatClass.whatClass(this) +
                "\nName: " + firstName + " " + lastName +
                "\nPhone Number: " + phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6, 9) +
                "\nE-mail: " + email +
                "\nDate of start: " + dateOfStart +
                "\nNumber of orders done: " + numberOfOrdersDone +
                "\nSalary: " + salary + " PLN\n";
    }

    public void printEmployee() {
        System.out.println(toString());
    }

    public void deleteEmployee() {
        for(int employeeIndex = 0; employeeIndex < getEmployees().size(); employeeIndex++)
            if(employeeID == getEmployees().get(employeeIndex).employeeID) {
                System.out.println("Deleted employee from the list (" + firstName + " " + lastName + ", #" + employeeID + ").\n");
                getEmployees().remove(employeeIndex);
            }
    }
}
