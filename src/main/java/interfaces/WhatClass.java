package interfaces;

import human_resources.*;
import orders.*;
import products.*;

public interface WhatClass {
    //this method returns exactly what class the object is
    static String whatClass(Object obj){
        if(obj.getClass().equals(OfficeWorker.class))
            return "Office Worker";

        if(obj.getClass().equals(WarehouseWorker.class))
            return "Warehouse Worker";

        if(obj.getClass().equals(Driver.class))
            return "Driver";

        if(obj.getClass().equals(Order.class))
            return "Pending order";

        if(obj.getClass().equals(AcceptedOrder.class))
            return "Accepted order";

        if(obj.getClass().equals(CompletedOrder.class))
            return "Completed order";

        if(obj.getClass().equals(TextileProduct.class))
            return "Textile product";

        if(obj.getClass().equals(CleaningProduct.class))
            return "Cleaning product";

        if(obj.getClass().equals(FoodProduct.class))
            return "Food product";

        return "Undefined.";
    }
}
