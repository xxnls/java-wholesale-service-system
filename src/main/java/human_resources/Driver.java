package human_resources;

public class Driver extends Employee{
    public String workPhoneNumber;

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public Driver(String firstName, String lastName, String phoneNumber, String email, String dateOfStart, int salary, String workPhoneNumber) {
        super(firstName, lastName, phoneNumber, email, dateOfStart, salary);
        this.workPhoneNumber = workPhoneNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "Work phone: " + workPhoneNumber.substring(0, 3) + "-" + workPhoneNumber.substring(3, 6) + "-" + workPhoneNumber.substring(6, 9);
    }
}
