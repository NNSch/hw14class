package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "телефон", 38_000);
        Product product2 = new Product(12, "книга", 1_000);
        Product product3 = new Product(15, "бра", 2_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(12);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveNotProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(10, "телефон", 38_000);
        Product product2 = new Product(12, "книга", 1_000);
        Product product3 = new Product(15, "бра", 2_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(123);
        });
    }
}
