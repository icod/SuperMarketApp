package nl.testcoders.supermarket.model;

import nl.testcoders.supermarket.constants.DiscountValues;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    Product product;
    Product bread;
    ShoppingCart cart;

    @BeforeEach
    void beforeEach() {
        product = new Product("Melk", 328190321, 1.00, 13);
        bread = new Product("bread", 2190, 2.40, 12);
        cart = new ShoppingCart();
    }

    @Test
    void add() {
        assertTrue(cart.isEmpty());
        assertTrue(cart.add(product));
        assertFalse(cart.isEmpty());

        assertEquals(1, cart.getProducts().get(0).getQuantity());
        assertTrue(cart.add(product));
        assertEquals(2, cart.getProducts().get(0).getQuantity());
        assertTrue(cart.add(bread));
        assertEquals(2, cart.getProducts().get(0).getQuantity());
        assertEquals(1, cart.getProducts().get(1).getQuantity());
    }

    @Test
    void remove() {
        assertTrue(cart.add(product));
        assertTrue(cart.add(product));
        assertFalse(cart.isEmpty());
        assertTrue(cart.remove(product));
        assertTrue(cart.remove(product));
        assertTrue(cart.isEmpty());
        assertFalse(cart.remove(product));
    }

    @Test
    void removeAll() {
        cart.add(bread);
        cart.add(bread);
        assertTrue(cart.removeAll(bread));
        assertTrue(cart.isEmpty());
    }

    @Test
    void clear() {
        cart.add(product);
        cart.clear();
        assertTrue(cart.isEmpty());
    }

    @Test
    void isEmpty() {
        assertTrue(cart.isEmpty());
        cart.add(product);
        assertFalse(cart.isEmpty());
    }

    @Test
    void getTotal() {
        product.setDiscountedBonus(true);
        cart.add(product);
        cart.getProducts().get(0).setDiscountedExpiring(true);
        assertEquals(0.65, cart.getTotal());

        cart.add(bread);
        bread.setDiscountedBonus(true);
        assertEquals(2.57, cart.getTotal());

        cart.add(bread);
        assertEquals(4.49, cart.getTotal());

    }

    @Test
    void getSubtotal() {
        product.setDiscountedBonus(true);
        cart.add(product);
        cart.getProducts().get(0).setDiscountedExpiring(true);
        assertEquals(1.00, cart.getSubtotal());

        cart.add(bread);
        bread.setDiscountedBonus(true);
        assertEquals(3.40, cart.getSubtotal());

        cart.add(bread);
        assertEquals(5.80, cart.getSubtotal());

    }

    @Test
    void getTotalDiscount() {
        product.setDiscountedBonus(true);
        cart.add(product);
        cart.getProducts().get(0).setDiscountedExpiring(true);
        assertEquals(.35, cart.getTotalDiscount());

        bread.setDiscountedBonus(true);
        cart.add(bread);
        assertEquals(0.83, cart.getTotalDiscount());

        cart.add(bread);
        assertEquals(1.31, cart.getTotalDiscount());
    }

    @Test
    void getProducts() {
        // empty cart
        assertTrue(cart.getProducts().isEmpty());

        // add a product
        cart.add(product);
        assertNotNull(cart.getProducts());
        assertEquals(1, cart.getProducts().size());

        cart.add(bread);
        assertEquals(2, cart.getProducts().size());
    }

    @Test
    void checkedOutCartCannotBeCheckedOutAgain() {
        assertTrue(cart.checkOut());
        assertFalse(cart.checkOut());
    }

    @Test
    void checkedOutCartCannotBeCleared() {
        cart.checkOut();
        assertFalse(cart.clear());
    }

    @Test
    void checkedOutCartCannotHaveAnyMoreProductsAddedTo() {
        cart.checkOut();
        assertFalse(cart.add(bread));
    }

    @Test
    void checkOutCartCannotHaveItemsRemovedFromIt() {
        cart.add(bread);
        cart.checkOut();
        assertFalse(cart.remove(bread));
        assertFalse(cart.removeAll(bread));
    }

    @Test
    void printReceipt() {
        cart.add(bread);
        cart.add(product);
        assertNotNull(cart.generateReceipt());
    }
}