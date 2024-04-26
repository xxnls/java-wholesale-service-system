package products;

import interfaces.WhatClass;

import static products.Warehouse.getProducts;

public abstract class Product implements WhatClass {
    private static int productCounter;
    private int productID;
    private String name;
    private String manufacturer;
    private int weight; //in grams
    private int quantity;

    static {
        productCounter = 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Product(String name, String manufacturer, int weight, int quantity) {
        productID = productCounter;
        this.name = name;
        this.manufacturer = manufacturer;
        this.weight = weight;
        this.quantity = quantity;
        productCounter++;
    }

    @Override
    public String toString() {
        return "Product ID: #" + productID +
                "\nType: " + WhatClass.whatClass(this) +
                "\nName: " + name +
                "\nManufacturer: " + manufacturer +
                "\nWeight: " + weight + " grams" +
                "\nQuantity: " + quantity;
    }

    public void deleteProduct() {
        for(int productIndex = 0; productIndex < getProducts().size(); productIndex++)
            if(productID == getProducts().get(productIndex).productID) {
                System.out.println("Deleted product from the list (" + name + ", #" + productID + ").\n");
                getProducts().remove(productIndex);
            }
    }

    public void printProduct() {
        System.out.println(toString());
    }

    public void removeQuantity(int quantityToRemove) {
        if(quantity - quantityToRemove < 0) {
            System.out.println("You cannot remove " + quantityToRemove + " products! There is only " + quantity + " in the stock!\n");
        }else{
            int oldQuantity = quantity;
            quantity -= quantityToRemove;
//            System.out.println("Removed " + quantityToRemove + " products from the stock.\n" +
//                                "Quantity before/after operation: " + oldQuantity + "/" + quantity + ".\n");
        }
    }

    public void addQuantity(int quantityToAdd) {
        int oldQuantity = quantity;
        quantity += quantityToAdd;
        System.out.println("Added " + quantityToAdd + " products to the stock.\n" +
                            "Quantity before/after operation: " + oldQuantity + "/" + quantity + ".\n");
    }

    public void cleanQuantity() {
        int oldQuantity = quantity;
        quantity = 0;
        System.out.println("Removed every product from the stock.\n" +
                            "Quantity before/after operation: " + oldQuantity + "/" + quantity + ".\n");
    }
}
