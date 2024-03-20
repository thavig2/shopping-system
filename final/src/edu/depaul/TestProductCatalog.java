package edu.depaul;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestProductCatalog {
    private ProductCatalog catalog;

    @BeforeEach
    public void setup() {
        catalog = new ProductCatalog();
    }

    @Test
    public void testReadProductFile() {
        ProductCatalog.readProductFile();
            for (Product product : ProductCatalog.productMap.values()) {
                assertNotNull(product);
            }
    }

    @Test
    public void testDisplayProductCatalog() {
        ProductCatalog.readProductFile();
        assertDoesNotThrow(() -> ProductCatalog.displayProductCatalog());
    }
    
}
