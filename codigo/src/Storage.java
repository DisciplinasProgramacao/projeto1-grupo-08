package codigo.src;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static List<Product> products;
    private static List<Product> soldProducts = new ArrayList<>();

    List<Product> productList = new ArrayList<>();

    private double totalPurchases = 0;

    // Get total amount of products in stock
    public int getTotalAmountInStorage() {
        int qty = 0;

        for (int i = 0; i < productList.size(); i++) {
            qty += productList.get(i).getQuantity();
        }

        return qty;
    }

    // Get amount of specific product in stock
    public int getSpecificProductQuantity(Product product) {
        int qty;

        int index = productList.indexOf(product);

        qty = productList.get(index).getQuantity();

        return qty;
    }

    // Add product to stock
    public void AddToStorage(Product product) {
        if (!productList.contains(product)) {
            productList.add(product);
        }
    }

    // Remove product from stock
    public static void RemoveFromStorage(Product product, int quantity) {
        // Verifique se a lista de produtos foi inicializada
        if (products == null) {
            System.out.println("Erro: a lista de produtos não foi inicializada.");
            return;
        }

        int index = products.indexOf(product);
        // Verifique se o índice do produto é válido
        if (index < 0 || index >= products.size()) {
            System.out.println("Erro: índice do produto inválido.");
            return;
        }

        Product productInStorage = products.get(index);
        // Verifique se o produto não é nulo
        if (productInStorage == null) {
            System.out.println("Erro: o produto é nulo.");
            return;
        }

        if (productInStorage.decreaseQuantity(quantity)) {
            System.out.println("Produto removido com sucesso do estoque.");
        } else {
            System.out.println("Erro: não foi possível remover o produto do estoque.");
        }
    }

    // Get the total value of the products in stock
    public double StorageTotalValue() {
        double totalValue = 0;

        for (Product product : productList) {
            totalValue += product.getPrice() * product.getQuantity();
        }

        return totalValue;
    }

    // Get the check in all the products if it they have the minimum quantity in
    // storage to run the grocery store
    public List<Product> getAllMinimum() {

        List<Product> lowerThanMinimum = new ArrayList<>();

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getQuantity() <= productList.get(i).getMinimumQuantity()) {
                lowerThanMinimum.add(productList.get(i));
            }
        }

        return lowerThanMinimum;
    }

    // Get the check if the product has the minimum quantity in storage to run the
    // grocery store
    public boolean getProductMinimum(Product product) {
        boolean minimum = false;

        int index = productList.indexOf(product);

        if (productList.get(index).getQuantity() <= productList.get(index).getMinimumQuantity()) {
            minimum = false;
        } else {
            minimum = true;
        }

        return minimum;
    }

    public List<Product> getProducts() {
        return productList;
    }

    public static double getValueSold() {
        double total = 0;
        for (Product product : soldProducts) {
            total += product.getFinalPrice();
        }
        return total;
    }

    public double getAmountSpent() {
        return totalPurchases;
    }

    public void recordSale(Product product, int quantity) {
        double totalSales = 0;

        double saleValue = product.getPrice() * quantity;
        totalSales += saleValue;

        // Adicione o produto à lista de produtos vendidos
        soldProducts.add(product);
    }

    public void recordPurchase(Product product, int quantity) {
        double purchaseValue = product.getCost() * quantity;
        totalPurchases += purchaseValue;
    }
}
