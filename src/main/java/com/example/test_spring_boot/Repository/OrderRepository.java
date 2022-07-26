package com.example.test_spring_boot.Repository;

import com.example.test_spring_boot.Dto.CategoryDto;
import com.example.test_spring_boot.Dto.OrderDTO;
import com.example.test_spring_boot.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {

    @Query("SELECT new com.example.test_spring_boot.Dto.OrderDTO(o) from OrderEntity o where o.active = 1")
    List<OrderDTO> getAllDto();
}
