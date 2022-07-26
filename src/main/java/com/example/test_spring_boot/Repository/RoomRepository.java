package com.example.test_spring_boot.Repository;

import com.example.test_spring_boot.Dto.OrderDTO;
import com.example.test_spring_boot.Dto.RoomDTO;
import com.example.test_spring_boot.Entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity , Long> {


    @Query("SELECT new com.example.test_spring_boot.Dto.RoomDTO(r) from RoomEntity r where r.active = 1")
    List<RoomDTO> getAllDto();

    @Query("SELECT new com.example.test_spring_boot.Dto.RoomDTO(r) from RoomEntity r where r.active = 1 and r.Status = ?1")
    List<RoomDTO> getAllDtoByStatus(Integer status);
}
