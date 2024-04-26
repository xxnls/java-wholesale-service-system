package products;

import java.util.ArrayList;

public class Warehouse {
    private static ArrayList<Product> products;

    static {
        products = new ArrayList<Product>();
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void addFoodProduct(String name, String manufacturer, int weight, int quantity, int expiration) {
        FoodProduct product = new FoodProduct(name, manufacturer, weight, quantity, expiration);
        products.add(product);
    }

    public static void addTextileProduct(String name, String manufacturer, int weight, int quantity, String material) {
        TextileProduct product = new TextileProduct(name, manufacturer, weight, quantity, material);
        products.add(product);
    }

    public static void addCleaningProduct(String name, String manufacturer, int weight, int quantity, String purpose, Boolean safeWithFood) {
        CleaningProduct product = new CleaningProduct(name, manufacturer, weight, quantity, purpose, safeWithFood);
        products.add(product);
    }

    public static void printAllProducts() {
        if(getHowManyProducts() == 0)
            System.out.println("Product list is empty.");
        else
            for(Product product : products) {
                product.printProduct();
                System.out.println();
            }
    }

    //returns how many products are in the warehouse
    public static int getHowManyProducts() {
        return products.size();
    }

    //method that returns how many categories of products are in the list
    public static int getHowManyDistinctProducts() {
        ArrayList<String> prds = new ArrayList<>();

        for(Product product : products) {
            if(!prds.contains(product.getClass().getSimpleName())) {
                prds.add(product.getClass().getSimpleName());
            }
        }

        return prds.size();
    }

    //method that prints out how many products of each category are in the list
    public static void printHowManySpecifiedProducts() {
        String[][] tab = new String[getHowManyDistinctProducts()][2];

        for(int i=0; i<getHowManyProducts(); i++) {
            boolean exists = false;
            for(int j=0; j<getHowManyDistinctProducts(); j++) {
                if(products.get(i).getClass().getSimpleName().equals(tab[j][0])) {
                    exists = true;
                    tab[j][1] = Integer.toString(Integer.parseInt(tab[j][1]) + 1);
                }
            }

            if(!exists) {
                for(int j=0; j<getHowManyDistinctProducts(); j++) {
                    if(tab[j][0] == null) {
                        tab[j][0] = products.get(i).getClass().getSimpleName();
                        tab[j][1] = "1";
                        break;
                    }
                }
            }
        }

        for(int j=0; j<getHowManyDistinctProducts(); j++) {
            System.out.println(tab[j][0] + " = " + tab[j][1]);
        }
    }
}
