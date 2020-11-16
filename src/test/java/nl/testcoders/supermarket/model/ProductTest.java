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
    void givenAProductWithoutDiscount_thenNoDiscountShouldBeApplied() {
        assertEquals(product.getPriceBeforeDiscount(), product.getPrice());
    }

    @Test
    void givenAProductWithBonusDiscount_thenBonusDiscountShouldBeApplied() {
        product.setDiscountedBonus(true);
        assertEquals(0.80, product.getPrice());
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
    void getPriceBeforeDiscount() {
        product.setDiscountedBonus(true);
        assertEquals(1.00, product.getPriceBeforeDiscount());
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

}