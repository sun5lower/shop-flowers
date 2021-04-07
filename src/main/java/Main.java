import entity.User;
import shopping.Products;
import shopping.Shop;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    Shop shop = new Shop();
    User user = new User();
    Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }

    void showMenu() {
        String userInput = "";
        do {
            System.out.println("Hello, nice to see you here, please choose activity:");
            System.out.println("1. Add Flower");
            System.out.println("2. Display all flowers");
            System.out.println("3. View a single flower");
            System.out.println("4. Remove flower");
            System.out.println("5. Update flower");
            System.out.println("\nEnter Quit to end the program");
            System.out.print("What would you like to do?");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "quit":
                    System.out.println("Exiting application...");
                    break;
                case "1":
                    addProduct();
                    break;
                case "2":
                    viewAllProducts();
                case "3":
                    viewSingleProduct();
                    break;
                case "4":
                    removeProduct();
                    break;
                case "5":
                    updateProduct();
                    break;
                default:
                    break;
            }
            System.out.println("\n Enter N to continue\n");
            scanner.nextLine();
        } while (!userInput.equalsIgnoreCase("quit"));
        return;
    }

    void addProduct() {

        System.out.println("\nAdd flowers");
        Products products = new Products();

        System.out.println("Enter name of the flowers please");
        products.name = scanner.nextLine();

        System.out.println("Enter price");
        products.price = scanner.nextFloat();

        System.out.println("Enter quantity");
        products.quantity = scanner.nextInt();

        products.id = UUID.randomUUID();

        String message = shop.addProduct(products);

        System.out.println(message);


    }

    void viewAllProducts() {
        ArrayList<Products> allProducts = shop.getAllProducts();
        System.out.println("\nThese flowers are available\n");
        System.out.println("Flower Name\t Price\t Quantity ");
        int counter = 0;
        for (Products product : allProducts) {
            System.out.println(counter + ". \t" + product.name + " \t" + product.price + "" + product.quantity);
            counter++;
        }
    }

    void viewSingleProduct() {
        System.out.println("View Product\n");
        System.out.println("Enter product ID:");

        int productID = scanner.nextInt();
        Products product = shop.getSingleProduct(productID);

        System.out.println("Flower name:" + product.name);
        System.out.println("flower:" + product.price);
        String id = "";
        System.out.println("flower id:" + id);
        System.out.println("Quantity of flowers :" + product.quantity);
    }

    public void removeProduct() {
        System.out.println("Delete flower\n");
        System.out.println("Enter flower Id");

        int carId = scanner.nextInt();
        String message = shop.removeProduct(carId);
        System.out.println(message);

    }
    void updateProduct(){
        Products products = new Products();
        this.viewAllProducts();

        System.out.println("Update flowers");

        System.out.println("Enter flower Id");
        int productId = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter a new flower's name!");
        products.name = scanner.nextLine();

        System.out.println("Now enter a new price for a flower");
        products.price = scanner.nextFloat();

        System.out.println("Now enter the new quantity");
        products.quantity = scanner.nextInt();

    }
}
