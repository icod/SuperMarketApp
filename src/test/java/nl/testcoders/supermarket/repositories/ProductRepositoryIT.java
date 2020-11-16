package nl.testcoders.supermarket.repositories;

import nl.testcoders.supermarket.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(value = SpringExtension.class)
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class ProductRepositoryIT {

    Product product;

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        product = new Product("Melk", 328190321, 1.00, 13);
        productRepository.save(product);
    }

    @Test
    void find_by_barcode() {
        List<Product> results = productRepository.findByBarcode(328190321);
        assertEquals(product, results.get(0));
    }

    @Test
    void find_by_id() {
        assertEquals(product, productRepository.findById(1));
    }

}