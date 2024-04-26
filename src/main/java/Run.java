//import java.util.Scanner;
//
//import static human_resources.HumanResources.*;
//
//public class Run {
//    public void clearConsole() {
//        System.out.print("\033\143");
//    }
//
//    public static String printMenu(String variant) {
//        String out = "";
//        switch(variant) {
//            case("start") -> {
//                out = """
//                      Administrator Panel - input command from square brackets to use it.
//                      [hr] - Human Resources Manager (employees)
//                      [wh] - Warehouse Manager (products)
//                      [om] - Orders Manager
//                      [ei] - Export/Import
//                      [exit] - Exit program.
//                      """;
//            }
//
//            case("hr") -> {
//                out = """
//                      Human Resources Manager
//                      [add] - Add employee.
//                      [del] - Delete employee.
//                      [print] - Print employee info.
//                      [prall] - Print all employees info.
//                      [howmany] - Print how many employees are in each profession.
//                      """;
//            }
//
//            case("wh") -> {
//                out = """
//                      Warehouse Manager
//                      [add] - Add product.
//                      [del] - Delete product.
//                      [remq] - Remove quantity.
//                      [addq] - Add quantity.
//                      [remall] - Remove all quantity.
//                      [print] - Print product info.
//                      [prall] - Print all products info.
//                      """;
//            }
//
//            case("om") -> {
//                out = """
//                      Orders Manager
//                      [add] - Add order.
//                      [del] - Delete order.
//                      [addsh] - Add shop.
//                      [delsh] - Delete shop.
//                      [addpr] - Add product to order.
//                      [rempr] - Remove product from order.
//                      [chquan] - Change quantity of product in order.
//                      [accept] - Accept order.
//                      [complete] - Complete order.
//                      [print] - Print order info.
//                      [prall] - Print all orders.
//                      [prshop] - Print shop info.
//                      [prallshop] - Print all shops info.
//                      """;
//            }
//        }
//        return out;
//    }
//
//    public static void runProgram() {
//        boolean running = true;
//        while(running) {
//            System.out.println(printMenu("start"));
//            Scanner sc = new Scanner(System.in);
//
//            switch(sc.nextLine()) {
//                case("hr") -> {
//                System.out.println(printMenu("hr"));
//                switch(sc.nextLine()) {
//                    case("add") -> {
//                        String fn, ln, phone, email, dateofstart, resOrPhone, choice;
//                        int salary;
//                        System.out.println("Please input [ow] to add Office Worker, [ww] to add Warehouse Worker, [dr] to add Driver.");
//                        choice = sc.nextLine();
//
//                        System.out.print("First name: ");
//                        fn = sc.nextLine();
//
//                        System.out.print("Last name: ");
//                        ln = sc.nextLine();
//
//                        System.out.print("Phone number: ");
//                        phone = sc.nextLine();
//
//                        System.out.print("E-mail address: ");
//                        email = sc.nextLine();
//
//                        System.out.print("Date of start (yyyy-mm-dd format): ");
//                        dateofstart = sc.nextLine();
//
//                        System.out.print("Salary: ");
//                        salary = sc.nextInt();
//
//                        if(choice.equals("ow")) {
//                            System.out.print("Responsible for: ");
//                            resOrPhone = sc.nextLine();
//                            addOfficeEmployee(fn, ln, phone, email, dateofstart, salary, resOrPhone);
//                        } else if (choice.equals("ww")) {
//                            System.out.print("Responsible for: ");
//                            resOrPhone = sc.nextLine();
//                            addWarehouseEmployee(fn, ln, phone, email, dateofstart, salary, resOrPhone);
//                        } else if (choice.equals("dr")) {
//                            System.out.print("Work phone number: ");
//                            resOrPhone = sc.nextLine();
//                            addDriverEmployee(fn, ln, phone, email, dateofstart, salary, resOrPhone);
//                        } else {
//                            System.out.println("Wrong input. Adding process stopped.");
//                        }
//                    }
//
//                }
//            }
//            }
//
//
//
//
//
//
//
//
//
//
//        }
//    }
//}
//
//        //                        switch(sc.nextLine()) {
//        //                            System.out.print("Responsible for: ");
//        //                            resOrPhone = sc.nextLine();
//        //                            addOfficeEmployee(fn, ln, phone, email, dateofstart, salary, resOrPhone);
//        //                        else if (sc.nextLine().equals("ww")) {
//        //                            System.out.print("Responsible for: ");
//        //                            resOrPhone = sc.nextLine();
//        //                            addWarehouseEmployee(fn, ln, phone, email, dateofstart, salary, resOrPhone);
//        //                        else if (sc.nextLine().equals("dr")) {
//        //                            System.out.print("Work phone number: ");
//        //                            resOrPhone = sc.nextLine();
//        //                            addDriverEmployee(fn, ln, phone, email, dateofstart, salary, resOrPhone);
//        //                        else {
//        //                            System.out.println("Wrong input. Adding process stopped.");
//        //                        }