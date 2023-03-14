package org.example;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    List<Product> productList = new ArrayList<>();


    public int getTotalAmountInStorage() {
        int qty = 0;

        for (int i = 0; i < productList.size(); i++) {
            qty += productList.get(i).getQuantity();
        }

        return qty;
    }

    public int getSpecificProductQuantity(Product product){
        int qty;

        int index = productList.indexOf(product);

        qty = productList.get(index).getQuantity();

        return qty;
    }

    public void AddToStorage(Product product) {
        if (!productList.contains(product)) {
            productList.add(product);
        }
    }

    public void RemoveFromStorage(Product product) {
        if (productList.contains(product)) {
            productList.remove(product);
        }
    }

    public double StorageTotalValue() {
        double totalValue = 0;

        for (int i = 0; i < productList.size(); i++) {
            totalValue += productList.get(i).getCost() * productList.get(i).getQuantity();
        }
        return totalValue;
    }

    public List<Product> getAllMinimum() {

        List<Product> lowerThanMinimum = new ArrayList<>();

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getQuantity() <= productList.get(i).getMinimumQuantity()) {
                lowerThanMinimum.add(productList.get(i));
            }
        }

        return lowerThanMinimum;
    }

    public boolean getProductMinimum(Product product) {
        boolean minimum = false;

        int index = productList.indexOf(product);

            if (productList.get(index).getQuantity() <= productList.get(index).getMinimumQuantity()) {
                minimum = false;
            }else {
                minimum = true;
            }

        return minimum;
    }

}
