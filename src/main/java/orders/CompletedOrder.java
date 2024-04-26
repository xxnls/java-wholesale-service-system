package orders;

import java.time.LocalDate;

public class CompletedOrder extends AcceptedOrder{
    private LocalDate completionDate;

    public CompletedOrder(AcceptedOrder order, String completionDate) {
        orderID = order.orderID;
        customer = order.customer;
        dateOfOrder = order.dateOfOrder;
        orderList = order.orderList;
        executionDate = order.executionDate;

        assignedWW = order.assignedWW;
        assignedWW.setNumberOfOrdersDone(assignedWW.getNumberOfOrdersDone() + 1);

        assignedOW = order.assignedOW;

        assignedDriver = order.assignedDriver;
        assignedDriver.setNumberOfOrdersDone(assignedDriver.getNumberOfOrdersDone() + 1);

        contactNumber = order.assignedDriver.getWorkPhoneNumber();

        this.completionDate = LocalDate.of(Integer.parseInt(completionDate.substring(0,4)), Integer.parseInt(completionDate.substring(5,7)), Integer.parseInt(completionDate.substring(8, 10)));
    }

    @Override
    public String toString() {
        return super.toString() + "\nCompletion Date: " + completionDate;
    }
}
