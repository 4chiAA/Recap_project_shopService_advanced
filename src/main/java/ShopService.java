import lombok.With;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ShopService {
    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();

    public Order addOrder(List<String> productIds) throws ProductNotFoundException {
        List<Product> products = new ArrayList<>();
        for (String productId : productIds) {
            Optional<Product> productToOrder = productRepo.getProductById(productId);
            if (productToOrder.isEmpty()) {
                throw new ProductNotFoundException("Product mit der Id: " + productId + " konnte nicht bestellt werden!");
            }
            products.add(productToOrder.get());
        }

        Order newOrder = new Order(UUID.randomUUID().toString(), products, OrderStatus.PROCESSING, ZonedDateTime.now());

        return orderRepo.addOrder(newOrder);
    }

    public List<Order> getOrdersByStatus(OrderStatus status){
        return orderRepo.getOrders().stream()
                                        .filter(s -> s.status().equals(status))
                                        .collect(Collectors.toList());
    }

    public void updateOrder(String orderID, OrderStatus status){
        Order order = orderRepo.getOrderById(orderID);
        Order updatedOrder = order.withStatus(status);
        orderRepo.removeOrder(orderID);
        orderRepo.addOrder(updatedOrder);
        }

    }
