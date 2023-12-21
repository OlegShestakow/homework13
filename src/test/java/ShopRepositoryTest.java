import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ShopRepositoryTest {
    @Test
    public void removeWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Микроволновка", 5_000);
        Product product2 = new Product(2, "Хлеб", 40);
        Product product3 = new Product(3, "Машина", 400_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Микроволновка", 5_000);
        Product product2 = new Product(2, "Хлеб", 40);
        Product product3 = new Product(3, "Машина", 400_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(
                NotFoundException.class,
                () -> repo.remove(100)
        );


    }
}
