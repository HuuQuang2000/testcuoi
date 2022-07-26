package com.example.test_spring_boot.Service.ServiceImpl;

import com.example.test_spring_boot.Dto.OrderDTO;

import com.example.test_spring_boot.Entity.OrderEntity;
import com.example.test_spring_boot.Entity.RoomEntity;
import com.example.test_spring_boot.Repository.OrderRepository;
import com.example.test_spring_boot.Repository.RoomRepository;
import com.example.test_spring_boot.Service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderDTO add(OrderDTO orderDTO) throws ParseException {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setActive(1);
        orderEntity.setName(orderDTO.getName());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Double dateOrder = 0d;
        try{
            Date dateStart = df.parse(orderDTO.getDateStartFormat());
            Date dateEnd = df.parse(orderDTO.getDateEndFormat());
            orderEntity.setDayEndOrder(dateEnd);
            orderEntity.setDayStartOrder(dateStart);
            dateOrder = Double.valueOf((dateEnd.getTime()-dateStart.getTime()) /24/60/60/1000);
        }catch (Exception e){
            return null;
        }
        Set<RoomEntity> roomEntitySet = new HashSet<>();

        orderEntity.setPrice(0d);
        if (orderDTO.getIdRoom() != null){
            RoomEntity roomEntity = roomRepository.findById(orderDTO.getIdRoom()).orElse(null);
            if (roomEntity != null){
                orderEntity.setPrice(roomEntity.getPrice()*dateOrder);
                roomEntity.setStatus(0);
                orderEntity.setRoomEntitySet(roomEntity);
                roomRepository.save(roomEntity);
            }
        }

       OrderDTO orderDTO1 = new OrderDTO(orderRepository.save(orderEntity));

        return orderDTO1;
    }

    @Override
    public OrderDTO findById(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElse(null);
        OrderDTO orderDTO = new OrderDTO();
        if (orderEntity != null){
            orderDTO = new OrderDTO(orderEntity);
        }
        return orderDTO;
    }

    @Override
    public Boolean delete(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElse(null);
        if (orderEntity != null){
            orderEntity.setActive(0);
            orderRepository.save(orderEntity);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public OrderDTO findByName(String name) {
        return null;
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.getAllDto();
    }
}
