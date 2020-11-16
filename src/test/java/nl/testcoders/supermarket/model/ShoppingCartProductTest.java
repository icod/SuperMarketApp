package nl.testcoders.supermarket.model;

import nl.testcoders.supermarket.constants.DiscountValues;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ShoppingCartProductTest {

    private Product product;
    private ShoppingCartProduct shoppingCartProduct;


    @BeforeEach
    void setUp() {
        product = new Product("Melk", 328190321, 1.00, 13);
        shoppingCartProduct = ShoppingCartProduct.of(product);
    }

    @Test
    void testEquals() {
        ShoppingCartProduct shoppingCartProduct1 = ShoppingCartProduct.of(product);
        ShoppingCartProduct shoppingCartProduct2 = ShoppingCartProduct.of(product);
        assertEquals(shoppingCartProduct2, shoppingCartProduct1);
    }

    @Test
    void getPrice_noDiscount() {
        // no discount
        assertEquals(product.getPrice(), shoppingCartProduct.getPrice());
    }

    @Test
    void getPrice_bonusAndExpiringDiscount() {
        // product has discounts
        product.setDiscountedBonus(true);
        shoppingCartProduct.setDiscountedExpiring(true);
        shoppingCartProduct.setQuantity(2);
        double expected = 2 * product.getPriceBeforeDiscount() * (1- DiscountValues.EXPIRING);
        assertEquals(expected, shoppingCartProduct.getPrice());
    }

    @Test
    void getPriceBeforeDiscount() {
        // product has discounts
        product.setDiscountedBonus(true);
        shoppingCartProduct.setDiscountedExpiring(true);
        shoppingCartProduct.setQuantity(2);
        assertEquals(product.getPriceBeforeDiscount() * 2, shoppingCartProduct.getPriceBeforeDiscount());
    }

    @Test
    void increase() {
        shoppingCartProduct.setQuantity(2);
        assertTrue(shoppingCartProduct.increase());
    }

    @Test
    void decrease() {
        shoppingCartProduct.setQuantity(1);
        assertFalse(shoppingCartProduct.decrease());
        assertEquals(1, shoppingCartProduct.getQuantity());

        shoppingCartProduct.setQuantity(2);
        assertTrue(shoppingCartProduct.decrease());
        assertEquals(1, shoppingCartProduct.getQuantity());
    }
}