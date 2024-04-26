package human_resources;

public class OfficeWorker extends Employee{
    public String responsibleFor;

    public OfficeWorker(String firstName, String lastName, String phoneNumber, String email, String dateOfStart, int salary, String responsibleFor) {
        super(firstName, lastName, phoneNumber, email, dateOfStart, salary);
        this.responsibleFor = responsibleFor;
    }

    @Override
    public String toString() {
        return super.toString() + "Responsible for: " + responsibleFor;
    }
}
