package codigo.src;

public class Product {
    private static int firstId = 0;
    private int id;
    private String name;
    private String description;
    private double cost;
    private double price;
    private double tax;
    private double finalPrice;
    private int quantity;
    private int minimumQuantity;

    public Product() {
        this.id = ++firstId;
        this.setName("Product");
        this.setDescription("Descrição");
        this.setCost(5.00);
        this.setPrice(7.5);
        this.addQuantity(100);
        this.setMinimumQuantity(50);
    }

    public Product(String name, String description, double cost, double price, int quantity, int minimumQuantity) {
        this.id = ++firstId;
        this.setName(name);
        this.setDescription(description);
        this.setCost(cost);
        this.setPrice(price);
        this.addQuantity(quantity);
        this.setMinimumQuantity(minimumQuantity);
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description_) {
        if(description_.length() > 3)
            this.description = description_;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if( price - this.getCost() <= this.getCost()*0.8 && price - this.getCost() >= this.getCost()*0.3) {
            this.price = price;
            this.setTax();
        }
    }

    public double getTax() {
        return this.tax;
    }

    private void setTax() {
        this.tax = this.getPrice() * 0.18;
        double value = this.getTax() + this.getPrice();
        this.setFinalPrice(value);
    }

    public double getFinalPrice() {
        return this.finalPrice;
    }

    private void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public double getGain() {
        return this.getPrice() - this.getCost();
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void decreaseQuantity(int quantity) {
        if(this.quantity - quantity >= 0)
            this.quantity -= quantity;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }
}
