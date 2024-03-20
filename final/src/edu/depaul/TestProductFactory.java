package edu.depaul;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestProductFactory {

    @Test
    public void testCreateClothingProduct() {
        Product product = ProductFactory.createProduct(1, "Clothing", "Product 1", 10.0);
        assertTrue(product instanceof Clothing);
        assertEquals("Product 1", product.getName());
        assertEquals(10.0, product.getPrice());
    }

    @Test
    public void testCreateBooksProduct() {
        Product product = ProductFactory.createProduct(2, "Books", "Product 2", 20.0);
        assertTrue(product instanceof Books);
        assertEquals("Product 2", product.getName());
        assertEquals(20.0, product.getPrice());
    }

    @Test
    public void testCreateElectronicsProduct() {
        Product product = ProductFactory.createProduct(3, "Electronics", "Product 3", 30.0);
        assertTrue(product instanceof Electronics);
        assertEquals("Product 3", product.getName());
        assertEquals(30.0, product.getPrice());
    }

    @Test
    public void testCreateInvalidProduct() {
        assertThrows(IllegalArgumentException.class, () -> {
            ProductFactory.createProduct(4, "InvalidType", "Product 4", 40.0);
        });
    }
}