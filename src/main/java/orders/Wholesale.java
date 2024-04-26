package orders;

import human_resources.*;
import orders.*;
import interfaces.WhatClass;
import products.Product;

import java.util.ArrayList;
import java.util.HashMap;

import static products.Warehouse.getProducts;

public class Wholesale implements WhatClass {
    private static ArrayList<Shop> shops;
    private static ArrayList<Order> orders;

    static{
        shops = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public static ArrayList<Shop> getShops() {
        return shops;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static int getHowManyShops() {
        return shops.size();
    }

    public static int getHowManyOrders() {
        return orders.size();
    }

    //method that adds new shop object
    public static void addShop(String name, String city, String address, String postalCode, String phoneNumber) {
        shops.add(new Shop(name, city, address, postalCode, phoneNumber));
    }

    //method that adds new order object
    public static void addOrder(Shop customer) {
        orders.add(new Order(customer));
    }

    //method that accepts order, order must be pending first
    public static void acceptOrder(Order order, String executionDate, WarehouseWorker assignedWW, OfficeWorker assignedOW, Driver assignedDriver) {
        if(WhatClass.whatClass(order).equals("Pending order")) {
            if (order.areAllProductsInStock()) {
                orders.set(orders.indexOf(order), new AcceptedOrder(order, executionDate, assignedWW, assignedOW, assignedDriver));

                for(HashMap.Entry<Product, Integer> productInOrder : order.getOrderList().entrySet()) {
                    for(Product productInWarehouse : getProducts()) {
                        if(productInOrder.getKey().getProductID() == productInWarehouse.getProductID()) {
                            productInWarehouse.removeQuantity(productInOrder.getValue());
                            break;
                        }
                    }
                }

                System.out.println("Successfully accepted order.\n");
            } else {
                System.out.println("You cannot accept order if there aren't all products in stock.\n");
            }
        }else{
            System.out.println("Order is already accepted/completed.\n");
        }
    }

    //method that completes order, order must be accepted first
    public static void completeOrder(AcceptedOrder order, String completionDate) {
        if(WhatClass.whatClass(order).equals("Accepted order")) {
            orders.set(orders.indexOf(order), new CompletedOrder(order, completionDate));
            System.out.println("Successfully completed order.\n");
        }else{
            System.out.println("Order is already completed or is pending.\n");
        }
    }

    //method that prints all shops
    public static void printAllShops() {
        if(getHowManyShops() == 0)
            System.out.println("Shops list is empty.");
        else
            for(Shop shop : shops) {
                shop.printShop();
                System.out.println();
            }
    }

    //method that prints all orders
    public static void printAllOrders() {
        if(getHowManyOrders() == 0)
            System.out.println("Orders list is empty.");
        else
            for(Order order : orders) {
                order.printOrder();
                System.out.println();
            }
    }
}
