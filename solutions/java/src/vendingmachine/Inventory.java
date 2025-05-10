package vendingmachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {

    Map<Product, Integer> products;

    public Inventory(){
        products = new ConcurrentHashMap<>();
    }

    public void addNewProduct(Product p, int quantity){
        products.put(p, quantity);
    }

    public void removeProduct(Product p){
        products.remove(p);
    }

    public void updateQuantity(Product p, int quantity){
        products.put(p, quantity);
    }

    public int getQuantity(Product p){
        return products.getOrDefault(p, 0);
    }

    public boolean isProductAvailable(Product p){
        return products.containsKey(p) && products.get(p) > 0;
    }


}
