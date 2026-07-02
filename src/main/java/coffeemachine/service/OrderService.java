package coffeemachine.service;

import coffeemachine.dto.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    Long findPopularRecipe();

    void addOrder(OrderDTO orderDTO);
}
