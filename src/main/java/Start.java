import human_resources.*;
import orders.*;
import products.*;

import interfaces.Export;
import interfaces.Import;

import static human_resources.HumanResources.*;
import static orders.Wholesale.*;
import static products.Warehouse.*;

//Import.importFromText("<filename>.txt") - to import from text
//Export.exportToText(Object) - to export object to text
//Export.exportAllToText(ArrayList) - to export all orders/products/employees/shops to text
//test.txt is a sample import text filled with data.

//Order needs to be created with Shop object parameter.
//Then, product can be added to order by <order>.addProductToOrder method.
//Order can be accepted by acceptOrder method. Every product needs to be in stock to do that.
//Then, product can be completed by completeOrder method.

//I leave commented code, so program can be easily checked by uncommenting parts of code.

public class Start implements Import, Export {
    public static void main(String[] args) {
        addFoodProduct("Kokos", "Kokosland", 390, 1000, 60);
        addTextileProduct("Przescieradlo", "Przescieradlorex", 200, 1000, "Bawelna");
        addCleaningProduct("Spray do czyszczenia kominkow", "Kominex", 250, 50, "Czyszczenie kominkow", false);

//        printAllProducts();
//        getProducts().get(2).deleteProduct();
//        getProducts().get(1).removeQuantity(150);
//        getProducts().get(1).removeQuantity(140);
//        getProducts().get(0).addQuantity(10);
//        getProducts().get(2).cleanQuantity();
//        printAllProducts();
//        System.out.println(getHowManyProducts());

        addDriverEmployee("Bartosz", "Nowak", "123452389", "bartosz.rosiek@program.com", "2012-05-14", 3200, "123453232");
        addOfficeEmployee("Elzbieta", "Kawka", "123456792", "ela.kawusia@program.com", "2006-03-12", 4300, "Textile Products");
        addWarehouseEmployee("Andrzej", "Gawron", "987654321", "andrzej.gawron@program.com", "2015-07-12", 2900, "Textile Products");
//        printAllEmployees();
//        getEmployees().get(0).deleteEmployee();
//        printAllEmployees();
//        System.out.println(getHowManyDistinctJobs());
//        System.out.println(getHowManyEmployees());
//        printHowManySpecifiedEmployees();
//        printHowManySpecifiedProducts();

        addShop("Shoppex", "Warsaw", "Strzelecka 37", "00-001", "123456789");
//        printAllShops();
        addOrder(getShops().get(0));
//        addOrder(getShops().get(0));
//        addOrder(getShops().get(0));
        getOrders().get(0).addProductToOrder(getProducts().get(0), 30);
        getOrders().get(0).addProductToOrder(getProducts().get(1), 150);
        getOrders().get(0).addProductToOrder(getProducts().get(2), 50);
        getOrders().get(0).addProductToOrder(getProducts().get(2), 5);
//
//        getOrders().get(1).addProductToOrder(getProducts().get(0), 30);
//
//        getOrders().get(2).addProductToOrder(getProducts().get(0), 30);


//        printAllOrders();
//
//        getOrders().get(0).removeProductFromOrder(getProducts().get(2));
//        getOrders().get(0).changeQuantityOfProductInOrder(getProducts().get(0), 100);
//
        printAllOrders();
//
        acceptOrder(getOrders().get(0), "2023-01-12", (WarehouseWorker) getEmployees().get(2), (OfficeWorker) getEmployees().get(1), (Driver) getEmployees().get(0));
//
        getProducts().get(2).addQuantity(1000);
//
        acceptOrder(getOrders().get(0), "2023-01-12", (WarehouseWorker) getEmployees().get(2), (OfficeWorker) getEmployees().get(1), (Driver) getEmployees().get(0));
//        acceptOrder(getOrders().get(2), "2023-01-12", (WarehouseWorker) getEmployees().get(2), (OfficeWorker) getEmployees().get(1), (Driver) getEmployees().get(0));
//
        printAllOrders();
//
//        getOrders().get(0).addProductToOrder(getProducts().get(1), 150);
//        getOrders().get(0).removeProductFromOrder(getProducts().get(1));
//        getOrders().get(0).changeQuantityOfProductInOrder(getProducts().get(1), 1000);
//
//        printAllOrders();
//
//        printAllEmployees();
//
        completeOrder((AcceptedOrder) getOrders().get(0), "2023-01-12");
//
        printAllOrders();
//
//        getOrders().get(0).addProductToOrder(getProducts().get(1), 150);
//        getOrders().get(0).removeProductFromOrder(getProducts().get(1));
//        getOrders().get(0).changeQuantityOfProductInOrder(getProducts().get(1), 1000);
//
//        printAllOrders();
//
//        printAllEmployees();
//        printAllProducts();
//        exportToText(getOrders().get(0));
//        exportAllToText(getOrders());
//        exportAllToText(getShops());
//        exportAllToText(getProducts());
//        exportAllToText(getEmployees());

//        addOrder(getShops().get(0));
//        addOrder(getShops().get(0));
//        addOrder(getShops().get(0));
//
//        getOrders().get(1).addProductToOrder(getProducts().get(0), 10);
//        getOrders().get(2).addProductToOrder(getProducts().get(1), 20);
//        getOrders().get(3).addProductToOrder(getProducts().get(2), 30);
//
//        printAllProducts();
//        printAllOrders();
//
//        acceptOrder(getOrders().get(0), "2023-01-23", (WarehouseWorker) getEmployees().get(2), (OfficeWorker) getEmployees().get(1), (Driver) getEmployees().get(0));
//        acceptOrder(getOrders().get(1), "2023-01-23", (WarehouseWorker) getEmployees().get(2), (OfficeWorker) getEmployees().get(1), (Driver) getEmployees().get(0));
//        acceptOrder(getOrders().get(2), "2023-01-23", (WarehouseWorker) getEmployees().get(2), (OfficeWorker) getEmployees().get(1), (Driver) getEmployees().get(0));
//        acceptOrder(getOrders().get(3), "2023-01-23", (WarehouseWorker) getEmployees().get(2), (OfficeWorker) getEmployees().get(1), (Driver) getEmployees().get(0));
//        acceptOrder(getOrders().get(2), "2023-01-23", (WarehouseWorker) getEmployees().get(2), (OfficeWorker) getEmployees().get(1), (Driver) getEmployees().get(0));
//
//        completeOrder((AcceptedOrder) getOrders().get(2), "2023-01-17");
//        printAllProducts();
//        printAllOrders();
//        exportAllToText(getOrders());
//        Import.importFromText("test.txt");
//        Export.exportToText(getOrders().get(1));
//        Export.exportToText(getEmployees().get(3));
//        getOrders().get(1).printOrder();
//        getEmployees().get(3).printEmployee();
//        getProducts().get(3).printProduct();
//        getProducts().get(4).printProduct();
//        getShops().get(1).printShop();

//        printAllEmployees();
//        printAllOrders();
//        printAllShops();
//        printAllProducts();
//        Import.importFromText("test.txt");
//        Export.exportAllToText(getEmployees());

    }
}