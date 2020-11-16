package nl.testcoders.supermarket.model;

import lombok.*;
import nl.testcoders.supermarket.utilities.Padding;

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

    public String generateReceipt() {
        StringBuilder sb = new StringBuilder();
        sb.append("*".repeat(20)).append("\n")
                .append(" ".repeat(6))
                .append("Receipt".toUpperCase())
                .append("\n")
                .append("*".repeat(20))
                .append("\n");

        for (ShoppingCartProduct shoppingCartProduct: products) {
            sb.append(receiptLine(shoppingCartProduct));
        }

        return sb.toString();
    }

    public void printReceipt() {
        System.out.println(generateReceipt());
    }

    private String receiptLine(ShoppingCartProduct shoppingCartProduct) {
        int productName = 20;
        int quantity = 6;
        int pricePerUnit = 10;
        int price = 6;
        int discount = 7;
        Product product = shoppingCartProduct.getProduct();
        StringBuilder sb = new StringBuilder();
        sb.append(Padding.right(product.getDescription(), productName));
        sb.append(Padding.left(shoppingCartProduct.getQuantity(), quantity));
        sb.append(Padding.left(product.getPrice(), pricePerUnit));
        sb.append(Padding.left(shoppingCartProduct.getPrice(), price));
        sb.append(Padding.left(shoppingCartProduct.getCalculatedDiscount(), discount));
        sb.append("\n");

        return sb.toString();
    }

}
