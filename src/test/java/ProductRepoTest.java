import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @org.junit.jupiter.api.Test
    void getProducts() {
        //GIVEN
        ProductRepo repo = new ProductRepo();

        //WHEN
        List<Product> actual = repo.getProducts();

        //THEN
        List<Product> expected = new ArrayList<>();
        expected.add(new Product("1", "Apfel"));
        assertEquals(actual, expected);
    }

    @org.junit.jupiter.api.Test
    void getProductById() {
        //GIVEN
        ProductRepo repo = new ProductRepo();
        Product expected = new Product("1", "Apfel");
        //WHEN
        Optional<Product> actual = repo.getProductById("1");

        //THEN
        assertTrue(actual.isPresent());
        assertEquals(actual.get().name(), expected.name());
    }

    @org.junit.jupiter.api.Test
    void addProduct() {
        //GIVEN
        ProductRepo repo = new ProductRepo();
        Product newProduct = new Product("2", "Banane");
                //WHEN
        Product actual = repo.addProduct(newProduct);

        //THEN
        Optional<Product> expected = repo.getProductById("2");
        assertTrue(expected.isPresent());
        assertEquals(actual.name(), expected.get().name());
    }

    @org.junit.jupiter.api.Test
    void removeProduct() {
        //GIVEN
        ProductRepo repo = new ProductRepo();

        //WHEN
        repo.removeProduct("1");

        //THEN
        assertTrue(repo.getProductById("1").isEmpty());
    }
}
