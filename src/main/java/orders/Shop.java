package orders;

import static orders.Wholesale.getShops;

public class Shop {
    private static int shopCounter;
    private int shopID;
    private String name;
    private String city;
    private String address;
    private String postalCode;
    private String phoneNumber;
    private int numberOfOrders;

    static {
        shopCounter = 0;
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public String getName() {
        return name;
    }

    public int getShopID() {
        return shopID;
    }

    public Shop(String name, String city, String address, String postalCode, String phoneNumber) {
        this.shopID = shopCounter;
        this.name = name;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.numberOfOrders = 0;
        shopCounter++;
    }

    @Override
    public String toString() {
        return "Shop ID: #" + shopID +
                "\nName: " + name +
                "\nCity: " + city +
                "\nAddress: " + address +
                "\nPostal code: " + postalCode +
                "\nPhone number: " + phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6, 9) +
                "\nNumber of orders: " + numberOfOrders;
    }

    public void deleteShop() {
        for(int shopIndex = 0; shopIndex < getShops().size(); shopIndex++)
            if(shopID == getShops().get(shopIndex).shopID) {
                System.out.println("Deleted shop from the list (" + name + ", #" + shopID + ").\n");
                getShops().remove(shopIndex);
            }
    }

    public void printShop() {
        System.out.println(toString());
    }
}
