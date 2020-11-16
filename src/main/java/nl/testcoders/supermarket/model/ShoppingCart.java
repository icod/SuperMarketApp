package nl.testcoders.supermarket.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    @Getter
    private List<ShoppingCartProduct> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public boolean add(Product product) {
        ShoppingCartProduct shoppingCartProduct = ShoppingCartProduct.of(product);
        if (products.contains(shoppingCartProduct)) {
            int index = products.indexOf(shoppingCartProduct);
            return products.get(index).increase();
        }
        return products.add(shoppingCartProduct);
    }

    public boolean remove(Product product) {
        ShoppingCartProduct shoppingCartProduct = ShoppingCartProduct.of(product);
        if (products.contains(shoppingCartProduct)) {
            int index = products.indexOf(shoppingCartProduct);
            ShoppingCartProduct productToDecrease = products.get(index);
            if (productToDecrease.getQuantity() > 1) {
                return productToDecrease.decrease();
            }
        }
        return products.remove(shoppingCartProduct);
    }

    public boolean removeAll(Product product) {
        ShoppingCartProduct shoppingCartProduct = ShoppingCartProduct.of(product);
        return products.remove(shoppingCartProduct);
    }

    public void clear() {
        this.products = new ArrayList<>();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    /**
     * @return the amount due after discounts
     */
    public double getTotal() {
        return products.stream().mapToDouble(ShoppingCartProduct::getPrice).sum();
    }

    /**
     * @return the amount before discounts are applied
     */
    public double getSubtotal() {
        return products.stream().mapToDouble(ShoppingCartProduct::getPriceBeforeDiscount).sum();
    }

    /**
     * @return the total discount that is applied to this basket
     */
    public double getTotalDiscount() {
        return products.stream().mapToDouble(ShoppingCartProduct::getCalculatedDiscount).sum();
    }

}
