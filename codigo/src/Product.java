/**
 * @file  Product.java
 * @brief Classe de Produto
 * 
 * Implementação da classe Produto adequando-a a regra de negócio especificada
*/
 
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

    /**
    * Retorna o nome do produto.
    * 
    * 
    * @return Nome do produto como String
    */
    public String getName() {
        return this.name;
    }

    /**
    * Atribui uma String ao nome do produto
    * 
    * @param name - o nome do produto a ser definido
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * Retorna a descrição do produto
    * 
    * 
    * @return A descrição do produto.
    */
    public String getDescription() {
        return this.description;
    }

    /**
    * Estabelece a descrição do produto.
    * 
    * @param description_ - A descrição a ser atribuida
    */
    public Boolean setDescription(String description_) {
        if(description_.length() > 3) {
            this.description = description_;
            return true;
        }

        return false;
    }

    /**
    * Retorna o custo do produto.
    */
    public double getCost() {
        return this.cost;
    }

    /**
    * Atribui um valor como custo do produto
    * 
    * @param cost - O custo do
    */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
    * Retorna o preço do produto
    */
    public double getPrice() {
        return this.price;
    }

    /**
    * Estabelece o preço do Produto
    * 
    * @param price - O preço a ser atribuido
    */
    public Boolean setPrice(double price) {
        // Confirma se o preço está de acordo com a regra estabelecida de lucro
        if( price - this.getCost() <= this.getCost()*0.8 && price - this.getCost() >= this.getCost()*0.3) {
            this.price = price;
            this.setTax();
            return true;
        }
        
        return false;
    }

    /**
    * Retorna o imposto sobre o item.
    */
    public double getTax() {
        return this.tax;
    }

    /**
    * Calcula o imposto sobre o preço final do produto, a partir de sua definição
    */
    private void setTax() {
        this.tax = this.getPrice() * 0.18;
        double value = this.getTax() + this.getPrice();
        this.setFinalPrice(value);
    }

    /**
    * Retorna o preço final do  produto.
    */
    public double getFinalPrice() {
        return this.finalPrice;
    }

    /**
    * Quando o preço do produto e os impostos são definidos o preço final recebe esse valor
    * 
    * @param finalPrice - O preço final calculado
    */
    private void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    /**
    * Retorna o lucro
    */
    public double getGain() {
        return this.getPrice() - this.getCost();
    }

    /**
    * Retorna a quantidade deste item em estoque
    */
    public int getQuantity() {
        return this.quantity;
    }

    /**
    * Adiciona uma quantidade de itens do produto no estoque
    * 
    * @param quantity - A quantidade a adicionar
    */
    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    /**
    * A redução da quantidade de itens do produto no esoque
    * 
    * @param quantity - A quantidade a diminuir
    */
    public Boolean decreaseQuantity(int quantity) {
        // Decrece a quantidade da quantidade.
        if(this.quantity - quantity >= 0) {
            this.quantity -= quantity;
            return true;
        }

        return false;
    }

    /**
    * Retorna a quantidade mínima de produto
    */
    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    /**
    * Estabelece a quantidade mínima de produto
    * 
    * @param minimumQuantity - a quantidade mínima
    */
    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }
}
