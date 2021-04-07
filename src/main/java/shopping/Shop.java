package shopping;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private ArrayList<Products> products = new ArrayList<Products>();

    User user = new User();

    public String addProduct(Products product) {
        this.products.add(product);
        return product.name + " Added successfully";
    }

    public ArrayList<Products> getAllProducts() {
        return products;
    }

    public Products getSingleProduct(int productId) {
        return this.products.get(productId);
    }

    public String removeProduct(int productId) {
        try {
            products.remove(productId);
        } catch (Exception ex) {
            return "Unable to remove specified flower!";
        }
        return "Flower removed successfully";

    }

    public String addUser(User user) {
        return user.name;
    }
    public String updateProduct(int productsIndex, Products newProduct) {
        if (this.products.get(productsIndex) != null) {
            //u can ask for an item,or make a loop,there are different ways to do it
            Products oldProduct = this.products.get(productsIndex);
            oldProduct.name = newProduct.name;
            oldProduct.price = newProduct.price;
            oldProduct.quantity = newProduct.quantity;
            return "flower updated successfully";

       }
        return "flower not found";
    }

}
