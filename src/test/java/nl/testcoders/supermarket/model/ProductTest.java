package nl.testcoders.supermarket.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Melk", 328190321, 1.00, 13);
    }

    @Test
    void getPriceAfterDiscount_no_discount() {
        assertEquals(1.00, product.getPriceAfterDiscount());
    }

    @Test
    void getPriceAfterDiscount_bonus_discount() {
        product.setDiscountedBonus(true);
        assertEquals(0.80, product.getPriceAfterDiscount());
    }

    @Test
    void getPriceAfterDiscount_expiring_discount() {
        product.setDiscountedExpiring(true);
        assertEquals(0.65, product.getPriceAfterDiscount());
    }

    @Test
    void getPriceAfterDiscount_expiring_and_bonus_discount() {
        product.setDiscountedExpiring(true);
        product.setDiscountedBonus(true);
        assertEquals(0.65, product.getPriceAfterDiscount());
    }

    @Test
    void getDescription() {
        assertEquals("Melk", product.getDescription());
    }

    @Test
    void getBarcode() {
        assertEquals(328190321, product.getBarcode());
    }

    @Test
    void getPrice() {
        assertEquals(1.00, product.getPrice());
    }

    @Test
    void getAmountInStock() {
        assertEquals(13, product.getAmountInStock());
    }

    @Test
    void setAmountInStock() {
        product.setAmountInStock(12);
        assertEquals(12, product.getAmountInStock());
    }

    @Test
    void removeDiscount() {
        product.setDiscountedBonus(true);
        product.setDiscountedExpiring(true);
        assertTrue(product.isDiscountedBonus());
        assertTrue(product.isDiscountedExpiring());
        product.removeDiscount();
        assertFalse(product.isDiscountedBonus());
        assertFalse(product.isDiscountedExpiring());
    }
}