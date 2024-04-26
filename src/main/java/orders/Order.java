package orders;

import interfaces.WhatClass;
import products.Product;

import java.time.LocalDate;
import java.util.HashMap;

import static java.lang.Math.abs;
import static orders.Wholesale.getOrders;

public class Order implements WhatClass {
    private static int orderCounter;
    protected int orderID;
    protected Shop customer;
    protected HashMap<Product, Integer> orderList = new HashMap<>();
    protected LocalDate dateOfOrder;

    static {
        orderCounter = 0;
    }

    public Order(){};

    public Order(Shop customer) {
        this.orderID = orderCounter;

        this.customer = customer;
        customer.setNumberOfOrders(customer.getNumberOfOrders() + 1);

        LocalDate lt = LocalDate.now();
        this.dateOfOrder = lt;

        orderCounter++;
    }

    public HashMap<Product, Integer> getOrderList() {
        return orderList;
    }

    public Shop getCustomer() {
        return customer;
    }

    public int getOrderID() {
        return orderID;
    }

    public void addProductToOrder(Product product, Integer quantity) {
        if(this instanceof AcceptedOrder)
            System.out.println("You cannot add more products to accepted/completed order.");
        else {
            if(!orderList.containsKey(product))
                orderList.put(product, quantity);
            else
                changeQuantityOfProductInOrder(product, orderList.get(product) + quantity);
        }
    }

    public void removeProductFromOrder(Product product) {
        if(this instanceof AcceptedOrder)
            System.out.println("You cannot remove a product in an accepted/completed order.");
        else
            orderList.remove(product);
    }

    public void changeQuantityOfProductInOrder(Product product, Integer quantity) {
        if(this instanceof AcceptedOrder)
            System.out.println("You cannot change quantity of product in an accepted/completed order.");
        else
            orderList.replace(product, quantity);
    }

    public int getHowManyProductsInOrder() {
        return orderList.size();
    }

    public boolean areAllProductsInStock() {
        boolean result = true;

        for(HashMap.Entry<Product, Integer> product : orderList.entrySet()){
            if(product.getKey().getQuantity() < product.getValue())
                result = false;
        }

        return result;
    }

    @Override
    public String toString() {
                String out = "Status: " + WhatClass.whatClass(this) +
                            "\n\nOrder ID: #" + orderID +
                            "\nCustomer: " + customer.getName() +
                            "\nDate of order: " + dateOfOrder +
                            "\nAre all products in stock? ";

                    out += areAllProductsInStock() ? " YES" : " NO";

                    out += "\nOrder list: \n";

                            for(HashMap.Entry<Product, Integer> product : orderList.entrySet()) {
                                out += product.getKey().getName() + " (ID: #" + product.getKey().getProductID() +
                                    ") \tManufacturer: " + product.getKey().getManufacturer() +
                                    " \tQuantity of order: " + product.getValue() + " \t\tIs product in stock? ";

                                    if(product.getKey().getQuantity() >= product.getValue())
                                        out += "Yes\n";
                                    else
                                        out += "No (missing " + abs(product.getKey().getQuantity() - product.getValue()) + " items)\n";
                            }

                            return out;
    }

    public void printOrder() {
        System.out.println(toString());
    }

    public void deleteOrder() {
        for(int orderIndex = 0; orderIndex < getOrders().size(); orderIndex++)
            if(orderID == getOrders().get(orderIndex).orderID) {
                //System.out.println("Deleted order from the list (" + customer + ", #" + orderID + ").\n");
                getOrders().remove(orderIndex);
            }
    }

}
