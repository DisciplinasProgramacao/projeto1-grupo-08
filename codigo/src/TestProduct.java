package codigo.src;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProduct {
    
        private Product product;
    
        @BeforeEach
        public void setUp() {
            product = new Product();
        }
    
        @Test
        public void testSetName() {
            product.setName("Produto Teste");
            Assertions.assertEquals("Produto Teste", product.getName());
        }
    
        @Test
        public void testSetDescription() {
            product.setDescription("Descrição do Produto Teste");
            Assertions.assertEquals("Descrição do Produto Teste", product.getDescription());
        }
    
        @Test
        public void testSetCost() {
            product.setCost(10.00);
            Assertions.assertEquals(10.00, product.getCost(), 0.01);
        }
    
        @Test
        public void testSetPrice() {
            product.setPrice(9.00);
            Assertions.assertEquals(9.00, product.getPrice(), 0.01);
            Assertions.assertEquals(10.62, product.getFinalPrice(), 0.01);
        }
    
        @Test
        public void testSetPriceInvalid() {
            product.setPrice(3.00);
            Assertions.assertEquals(7.50, product.getPrice(), 0.01);
            Assertions.assertEquals(8.85, product.getFinalPrice(), 0.01);
        }
    
        @Test
        public void testGetGain() {
            Assertions.assertEquals(2.5, product.getGain(), 0.01);
        }
    
        @Test
        public void testAddQuantity() {
            product.addQuantity(50);
            Assertions.assertEquals(150, product.getQuantity());
        }
    
        @Test
        public void testDecreaseQuantity() {
            product.decreaseQuantity(50);
            Assertions.assertEquals(50, product.getQuantity());
        }
    
        @Test
        public void testDecreaseQuantityInvalid() {
            product.decreaseQuantity(150);
            Assertions.assertEquals(100, product.getQuantity());
        }
       
}
