import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void addOrderTest() {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1");

        //WHEN

        //THEN
        try {
            shopService.addOrder(productsIds);
        } catch (ProductNotFoundException e) {
            fail("Unexpected ProductNotFoundException was thrown: " + e.getMessage());
        }
        //Order expected = new Order("-1", List.of(new Product("1", "Apfel")), OrderStatus.PROCESSING);
        //assertEquals(expected.products(), actual.products());
        //assertNotNull(expected.id());
    }

    @Test
    void addOrderTest_whenInvalidProductId_expectException() {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1", "2");
        //WHEN
        //THEN
        try {
            shopService.addOrder(productsIds);
            fail();
        } catch (ProductNotFoundException e) {
            assertTrue(true);
        }
    }
}
