package com.example.test_spring_boot.Service;

import com.example.test_spring_boot.Dto.OrderDTO;
import com.example.test_spring_boot.Dto.RoomDTO;

import java.text.ParseException;
import java.util.List;

public interface IOrderService {
    OrderDTO add(OrderDTO orderDTO) throws ParseException;
    OrderDTO findById(Long id);
    Boolean delete(Long id);
    OrderDTO findByName(String name);
    List<OrderDTO> getAll();
}
