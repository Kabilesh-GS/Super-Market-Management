package SuperMarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static List<User> users = new ArrayList<>();
    static List<Product> products = new ArrayList<>();
    static List<Cart> carts = new ArrayList<>();
    static boolean menuOn = true;

    public static void main(String[] args) {
        while(true) {
            while(menuOn){
                System.out.println("----Welcome to Super Market System----");
                System.out.println("1.Register\n2.Login\n3.Exit");
                int choice = sc.nextInt();
                if(choice == 1){
                    register();
                }
                else if(choice == 2){
                    if(login()){
                        menuOn = false;
                    }
                }
                else if(choice == 3){
                    System.out.println("Closing System!");
                    System.exit(0);
                }
                else {
                    System.out.println("Invalid option!");
                }
            }
            menuOn = true;
        }
    }

    public static void register(){
        sc.nextLine();
        System.out.print("Enter email : ");
        String email = sc.nextLine();
        System.out.print("Enter password : ");
        String password = sc.nextLine();
        System.out.print("Enter role : ");
        String role = sc.nextLine();

        users.add(new User(email,password,role));
    }
    public static boolean login(){
        sc.nextLine();
        System.out.print("Enter email : ");
        String email = sc.nextLine();
        System.out.print("Enter password : ");
        String password = sc.nextLine();

        for(User u : users){
            if(u.email.equalsIgnoreCase(email) && u.password.equalsIgnoreCase(password)){
                if(u.role.equalsIgnoreCase("admin")){
                    adminMenu(u);
                }
                else if (u.role.equalsIgnoreCase("customer")) {
                    customerMenu(u);
                }
                return true;
            }
        }
        System.out.println("Invalid Credentials");
        return false;
    }

    public static void adminMenu(User users){
        System.out.println("Welcome "+ users.email);
        boolean adminMenuOn = true;
        while(adminMenuOn){
            System.out.println("1.View All Products\n2.Add New Product\n3.Delete New Product\n4.Log Out");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    viewAllProduct();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    break;
                case 4:
                    adminMenuOn = false;
                    menuOn = true;
                    break;
                default:
                    System.out.println("Select a valid options");
            }
        }
    }

    public static void customerMenu(User users){
        System.out.println("Welcome "+ users.email);
        boolean customerMenuOn = true;
        while(customerMenuOn){
            System.out.println("1.View products\n2.Add product to cart\n3.View cart\n4.Log Out");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    viewAllProduct();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    customerMenuOn = false;
                    menuOn = true;
                    break;
                default:
                    System.out.println("Select a valid options");
            }
        }
    }

    public static void addNewProduct(){
        sc.nextLine();
        System.out.print("Product ID : ");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.print("Prdoduct name : ");
        String name = sc.nextLine();
        System.out.print("Set quantity : ");
        int quantity = sc.nextInt();
        System.out.print("Set price : ");
        double price = sc.nextDouble();

        products.add(new Product(ID, name, quantity, price));
        System.out.println("Product added Successfully");
    }

    public static void viewAllProduct(){
        for(Product u : products){
            System.out.println(u.Id + " || " + u.Name +" || "+ u.Quantity +" || "+ u.Price);
        }
    }

    public static void addToCart(){
        sc.nextLine();
        System.out.print("Enter ID : ");
        int id = sc.nextInt();
        System.out.print("Enter Quantity : ");
        int quantity = sc.nextInt();

        for(Product p : products) {
            if (p.Id == id) {
                if (p.Quantity >= quantity) {
                    double totalPrice = quantity * p.Price;
                    carts.add(new Cart(p.Id, p.Name, quantity, totalPrice));
                } else {
                    System.out.println("Insufficient quantity");
                }
            }
            else {
                System.out.println("Product not found");
            }
        }
    }

    public static void viewCart(){
        for (Cart c : carts){
            System.out.println(c.Id + " || " + c.name +" || "+ c.quantity +" || "+ c.price);
        }
    }
}