package interfaces;

import orders.Order;
import orders.Shop;
import products.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static human_resources.HumanResources.*;
import static orders.Wholesale.*;
import static products.Warehouse.*;

public interface Import {
    static void importFromText(String path) {
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                switch (line) {
                    case "+++ORDER" -> {
                        String dataOne = br.readLine();

                        for (Shop shop : getShops()) {
                            if (shop.getShopID() == Integer.parseInt(dataOne))
                                addOrder(shop);
                        }
                    }

                    case "+++ADD TO ORDER" -> {
                        String[] data = new String[3];
                        for (int i = 0; i < 3; i++)
                            data[i] = br.readLine();

                        Order or = null;

                        for (Order order : getOrders())
                            if (order.getOrderID() == Integer.parseInt(data[0]))
                                or = order;

                        if (or != null)
                            for (Product product : getProducts()) {
                                if (product.getProductID() == Integer.parseInt(data[0]))
                                    or.addProductToOrder(product, Integer.parseInt(data[2]));
                            }
                    }

                    case "+++ADD EMPLOYEE" -> {
                        String[] data = new String[8];
                        for (int i = 0; i < 8; i++)
                            data[i] = br.readLine();

                        if (data[0].equals("OFFICE")) {
                            addOfficeEmployee(data[1], data[2], data[3], data[4], data[5], Integer.parseInt(data[6]), data[7]);
                        }

                        if (data[0].equals("WAREHOUSE")) {
                            addWarehouseEmployee(data[1], data[2], data[3], data[4], data[5], Integer.parseInt(data[6]), data[7]);
                        }

                        if (data[0].equals("DRIVER")) {
                            addDriverEmployee(data[1], data[2], data[3], data[4], data[5], Integer.parseInt(data[6]), data[7]);
                        }
                    }

                    case "+++ADD PRODUCT" -> {
                        if(br.readLine().equals("FOOD")) {
                            String[] data = new String[5];
                            for (int i=0; i < 5; i++)
                                data[i] = br.readLine();

                            addFoodProduct(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]));
                        }

                        if(br.readLine().equals("TEXTILE")) {
                            String[] data = new String[5];
                            for (int i=0; i < 5; i++)
                                data[i] = br.readLine();

                            addTextileProduct(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]);
                        }

                        if(br.readLine().equals("CLEANING")) {
                            String[] data = new String[6];
                            for (int i=0; i < 6; i++)
                                data[i] = br.readLine();

                            addCleaningProduct(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4], Boolean.parseBoolean(data[5]));
                        }
                    }

                    case "+++ADD SHOP" -> {
                        String[] data = new String[5];
                        for (int i=0; i < 5; i++)
                            data[i] = br.readLine();

                        addShop(data[0], data[1], data[2], data[3], data[4]);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error while importing data.");
        }
    }
}

//public static void importPeople(String path) {
//        BufferedReader br;
//        String line;
//        try{
//            br = new BufferedReader(new FileReader(path));
//
//            while((line = br.readLine()) != null){
//                if(line.equals("FULL")) {
//                    String [] data = new String [7];
//                    for(int i=0; i<7; i++) {
//                        data[i] = br.readLine();
//                    }
//                    createFullTimeStudent(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4], Integer.parseInt(data[5]), data[6]);
//                }
//
//                if(line.equals("PART")) {
//                    String [] data = new String [7];
//                    for(int i=0; i<7; i++) {
//                        data[i] = br.readLine();
//                    }
//                    createPartTimeStudent(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4], Integer.parseInt(data[5]), data[6]);
//                }
//
//                if(line.equals("CONTRACT")) {
//                    String [] data = new String [6];
//                    for(int i=0; i<6; i++) {
//                        data[i] = br.readLine();
//                    }
//                    createContractLecturer(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4], Integer.parseInt(data[5]));
//                }
//
//                if(line.equals("MANDATE")) {
//                    String [] data = new String [6];
//                    for(int i=0; i<6; i++) {
//                        data[i] = br.readLine();
//                    }
//                    createMandateLecturer(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4], Double.parseDouble(data[5]));
//                }
//
//                if(line.equals("ACCOUNTANT")) {
//                    String [] data = new String [5];
//                    for(int i=0; i<5; i++) {
//                        data[i] = br.readLine();
//                    }
//                    createAccountant(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]);
//                }
//
//            }
//        }catch(IOException e){
//            System.out.println("File not found.");
//            e.printStackTrace();
//        }
//    }