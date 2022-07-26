package com.example.test_spring_boot.Dto;

import com.example.test_spring_boot.Entity.OrderEntity;
import com.example.test_spring_boot.Entity.RoomEntity;
import com.example.test_spring_boot.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private String name;
    private UserDto userDto;

    private Date dayStartOrder;
    private Date dayEndOrder;
    private String dateStartFormat;
    private String dateEndFormat;

    private RoomDTO roomDTO;

    private Long idRoom;
    private Double price;
    public OrderDTO(OrderEntity orderEntity){
        this.id = orderEntity.getId();
        this.name =  orderEntity.getName();
        this.dayEndOrder = orderEntity.getDayEndOrder();
        if(orderEntity.getDayStartOrder() != null){
            this.dayStartOrder =  orderEntity.getDayStartOrder();
            this.dateStartFormat  =  new SimpleDateFormat("yyyy-MM-dd HH:ss").format(orderEntity.getDayStartOrder());
        }
        if(orderEntity.getDayStartOrder() != null){
            this.dayEndOrder =  orderEntity.getDayEndOrder();
            this.dateEndFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss").format(orderEntity.getDayEndOrder());
        }

        if (orderEntity != null && orderEntity.getRoomEntitySet() != null){
            this.roomDTO = new RoomDTO(orderEntity.getRoomEntitySet());
        }

        this.price = orderEntity.getPrice();
    }
}
