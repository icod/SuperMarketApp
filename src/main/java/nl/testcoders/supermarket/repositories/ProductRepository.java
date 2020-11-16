package nl.testcoders.supermarket.repositories;

import nl.testcoders.supermarket.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByBarcode(long barcode);
    Product findById(long id);
}
