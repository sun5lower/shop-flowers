package entity;

public class User {
    public String name;
    private double id;
    public String  email;
    private double balance;

    public User(String name,double id, String email, double balance) {
        this.name = name;
        this .id = id;
        this.email = email;
        this.balance = balance;
    }

    public User() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    private User user;

    public String setActiveUser(User user) {
        this.user = user;
        return "user update successfully";
    }
    public double getUserBalance() {
        return user.getBalance();
    }
    public String creditUser(float amount) {
        float newBalance = (float) (user.getBalance() + amount);
        this.user.setBalance(newBalance);
        return amount + " added successfully";
    }

}
