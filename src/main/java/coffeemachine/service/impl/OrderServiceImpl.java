package coffeemachine.service.impl;

import coffeemachine.dto.OrderDTO;
import coffeemachine.exception.WorkingHoursException;
import coffeemachine.model.OrderEntity;
import coffeemachine.repository.OrderRepository;
import coffeemachine.service.OperationalService;
import coffeemachine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OperationalService opirationalService;
    @Override
    public Long findPopularRecipe() {

        return orderRepository.findMostPopularRecipe();
    }

    @Override
    public void addOrder(OrderDTO orderDTO) {
        if(!opirationalService.isWorkingHours()){
            throw new WorkingHoursException("Not working hours");
        }

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDateTime(LocalDateTime.now());
        orderEntity.setRecipeId(orderDTO.getRecipeId());
        orderRepository.save(orderEntity);

    }
}
