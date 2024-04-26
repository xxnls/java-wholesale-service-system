package orders;

import human_resources.*;

import java.time.LocalDate;

public class AcceptedOrder extends Order{
    protected LocalDate executionDate;
    protected WarehouseWorker assignedWW;
    protected OfficeWorker assignedOW;
    protected Driver assignedDriver;
    protected String contactNumber;

    public AcceptedOrder(Order order, String executionDate, WarehouseWorker assignedWW, OfficeWorker assignedOW, Driver assignedDriver) {
        orderID = order.orderID;
        customer = order.customer;
        dateOfOrder = order.dateOfOrder;
        orderList = order.orderList;
        this.executionDate = LocalDate.of(Integer.parseInt(executionDate.substring(0,4)), Integer.parseInt(executionDate.substring(5,7)), Integer.parseInt(executionDate.substring(8, 10)));
        this.assignedWW = assignedWW;
        this.assignedOW = assignedOW;

        assignedOW.setNumberOfOrdersDone(assignedOW.getNumberOfOrdersDone() + 1);

        this.assignedDriver = assignedDriver;
        this.contactNumber = assignedDriver.getWorkPhoneNumber();
    }

    public AcceptedOrder(){};

    @Override
    public String toString() {
        return super.toString() + "\nExecution date: " + executionDate +
                                "\nAsigned Warehouse Worker: " + assignedWW.getFirstName() + " " + assignedWW.getLastName() + " (ID: #" + assignedWW.getEmployeeID() + ")" +
                                "\nAsigned Office Worker: " + assignedOW.getFirstName() + " " + assignedOW.getLastName() + " (ID: #" + assignedOW.getEmployeeID() + ")" +
                                "\nAsigned Driver: " + assignedDriver.getFirstName() + " " + assignedDriver.getLastName() + " (ID: #" + assignedDriver.getEmployeeID() + ")" +
                                "\nDriver contact number: " + contactNumber.substring(0, 3) + "-" + contactNumber.substring(3, 6) + "-" + contactNumber.substring(6, 9) + "\n";

    }
}
