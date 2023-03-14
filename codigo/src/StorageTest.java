package codigo.src;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class StorageTest {

    private Storage newStorage = new Storage();
    private Product detergent, juice, bread;
    //Product (name,cost,price,QuantityStorage,StorageMinimum)

    @BeforeEach
    public void setUp(){
        detergent = new Product("detergent","cleaning product", 2, 5, 50,10);
        juice = new Product("juice","fruit drink",1, 5, 10,15);
        bread = new Product("bread","food made from wheat", 1, 2, 40,20);
    }

    @Test //A product should be monitored to check if its actual quantity in storage is lower than the minimum necessary to run the grocery store.
    public void checkMinimumQuantityOfProduct() {
        newStorage.AddToStorage(juice);
        assertEquals(false,newStorage.getProductMinimum(juice));
    }

    @Test
    public void checkSpecificProductQuantity() {
        newStorage.AddToStorage(juice);
        assertEquals(10, newStorage.getSpecificProductQuantity(juice));
    }

    @Test
    public void checkMinimumQuantityOfAllProducts() {
        newStorage.AddToStorage(detergent);
        newStorage.AddToStorage(juice);
        newStorage.AddToStorage(bread);

        newStorage.RemoveFromStorage(bread);
        assertEquals(60, newStorage.getTotalAmountInStorage());
    }

    @Test
    public void CalculateStorageValue(){

        newStorage.AddToStorage(detergent);
        newStorage.AddToStorage(juice);
        newStorage.AddToStorage(bread);
        assertEquals(150, newStorage.StorageTotalValue());
    }




}
