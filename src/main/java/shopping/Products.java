package shopping;

import java.util.UUID;

public class Products {

    public String product;
    public float price;
    public int quantity;

    public Products() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Products(UUID id) {
        this.id = id;
    }

    public String name;
    public UUID id;

    public String getFlower() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products(String product, float price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }
}
