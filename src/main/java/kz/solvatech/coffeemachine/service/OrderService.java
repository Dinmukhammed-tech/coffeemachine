package kz.solvatech.coffeemachine.service;

import kz.solvatech.coffeemachine.dto.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    Long findPopularRecipe();

    void addOrder(OrderDTO orderDTO);
}
