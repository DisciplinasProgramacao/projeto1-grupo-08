package codigo.src;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProduct {
    
        private Product product;
    
        /**
        * Configura o ambiente de teste. Este método é chamado antes de cada método de teste na classe, evitando as repetições de codigo
        */
        @BeforeEach
        public void setUp() {
            product = new Product();
        }
    
        /**
        * Teste da atribuição do nome, método da classe Produtos
        */
        @Test
        public void testSetName() {
            product.setName("Produto Teste");
            Assertions.assertEquals("Produto Teste", product.getName());
        }
    
        /**
        * Teste da atribuição da descrição da classe Produtos
        */
        @Test
        public void testSetDescription() {
            product.setDescription("Descrição do Produto Teste");
            Assertions.assertEquals("Descrição do Produto Teste", product.getDescription());
        }
    
        /**
        * Teste de atribuição do valor de custo do produto
        */
        @Test
        public void testSetCost() {
            product.setCost(10.00);
            Assertions.assertEquals(10.00, product.getCost(), 0.01);
        }
    
        /**
        * Teste de atribuição de preço do produto
        */
        @Test
        public void testSetPrice() {
            Assertions.assertTrue(product.setPrice(9.00));
            Assertions.assertEquals(9.00, product.getPrice(), 0.01);
            Assertions.assertEquals(10.62, product.getFinalPrice(), 0.01);
        }
    
        /**
        * Teste de atribuição de preço do produto com valor inválido
        */
        @Test
        public void testSetPriceInvalid() {
            Assertions.assertFalse(product.setPrice(3.00));
            Assertions.assertEquals(7.50, product.getPrice(), 0.01);
            Assertions.assertEquals(8.85, product.getFinalPrice(), 0.01);
        }
    
        /**
        * Teste do valor de lucro do Produto
        */
        @Test
        public void testGetGain() {
            Assertions.assertEquals(2.5, product.getGain(), 0.01);
        }
    
        /**
        * Teste do incremento da quantidade de produto
        */
        @Test
        public void testAddQuantity() {
            product.addQuantity(50);
            Assertions.assertEquals(150, product.getQuantity());
        }
    
        /**
        * Teste de funcionamento da redução da quantidade de um produto
        */
        @Test
        public void testDecreaseQuantity() {
            Assertions.assertTrue(product.decreaseQuantity(50));
            Assertions.assertEquals(50, product.getQuantity());
        }
    
        /**
        * Teste de funcionamento da redução da quantidade de um produto com valor inválido
        */
        @Test
        public void testDecreaseQuantityInvalid() {
            Assertions.assertFalse(product.decreaseQuantity(150));
            Assertions.assertEquals(100, product.getQuantity());
        }
       
}
