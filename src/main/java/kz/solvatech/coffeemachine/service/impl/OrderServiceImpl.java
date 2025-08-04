package kz.solvatech.coffeemachine.service.impl;

import kz.solvatech.coffeemachine.dto.OrderDTO;
import kz.solvatech.coffeemachine.exception.WorkingHoursException;
import kz.solvatech.coffeemachine.model.OrderEntity;
import kz.solvatech.coffeemachine.repository.OrderRepository;
import kz.solvatech.coffeemachine.service.OperationalService;
import kz.solvatech.coffeemachine.service.OrderService;
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
