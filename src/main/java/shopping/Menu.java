package shopping;

import entity.Product;
import entity.User;
import types.UserType;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Shop shop = new Shop();
    public void showHomeScreen(){
        String choice = "";
        System.out.println("Welcome to shop"
                + "\n1. Add User \t\t 4. Add Product"
                + "\n2. View Users \t\t 5. View Products"
                + "\n3. Remove User \t\t 6. Buy Product"
                + "\n7. Exit shop"
        );

        System.out.print("Choose one of the below options please: ");
        choice = scanner.nextLine();

        switch (choice){
            case "1":
                collectUserInfoAndAddUser();
                break;
            case "2":
                showAllUsers();
                break;
            case "4":
                collectProductInfoAndCreate();
                break;
            case "5":
                showAllProduct();
                break;
            case "6":
                sellProductToUser();
                break;
            case "7":
                return;
            default:
                break;
        }
        this.showHomeScreen();
    }

    private void showAllProduct() {
        for (Product currentProduct: shop.getProducts()){
            System.out.println(currentProduct.getId() +
                    " | " + currentProduct.getName() +
                    " | " + currentProduct.getPrice() +
                    " | " + currentProduct.getQuantity() +
                    " | " + currentProduct.getCreatedAt());
        }
    }

    private void collectProductInfoAndCreate() {
        Product product = new Product();
        System.out.println("Enter Product Name:");
        product.setName(scanner.nextLine());

        System.out.println("Product Price e.g 10.50:");
        product.setPrice(Float.parseFloat(scanner.nextLine()));

        System.out.println("Enter Product Quantity:");
        product.setQuantity(Integer.parseInt(scanner.nextLine()));

        product.setId(UUID.randomUUID());
        product.setCreatedAt(LocalDate.now());

        System.out.println(shop.createProduct(product));
    }

    private void collectUserInfoAndAddUser() {
        System.out.println("Enter User's Name:");
        String name = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter balance e.g 25.00:");

        //Float parseFloat are wrapper classes, help us to convert
        float balance = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter User Type (owner / buyer):");
        UserType userType = (scanner.nextLine().trim().toUpperCase().equals("OWNER")) ? UserType.OWNER : UserType.BUYER;
        LocalDate createdAt = LocalDate.now();

        User user = new User(name, email, balance, userType, createdAt);
        System.out.println(shop.createUser(user));
    }

    private void showAllUsers(){
        for (User currentUser: shop.getUsers()){
            System.out.println(currentUser.getName() +
                    " | " + currentUser.getEmail() +
                    " | " + currentUser.getBalance() +
                    " | " + currentUser.getType() +
                    " | " + currentUser.getCreatedAt());
        }
    }

    private void sellProductToUser() {
        /*
         * do we have enough product to sell
         * does user have enough balance
         * deduct users balance
         * deduct product from total available products
         * */
        System.out.println("Enter registered email address:");
        String userEmail = scanner.nextLine();
        System.out.println("Enter product name:");
        String nameOfProduct = scanner.nextLine();
        System.out.println("How many items:");
        Integer noOfItems = Integer.parseInt(scanner.nextLine());

        System.out.println(shop.buyProduct(nameOfProduct, userEmail, noOfItems));
    }

}
