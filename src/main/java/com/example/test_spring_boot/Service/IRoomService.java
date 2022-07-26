package com.example.test_spring_boot.Service;

import com.example.test_spring_boot.Dto.RoomDTO;

import java.util.List;

public interface IRoomService {
   RoomDTO addOrUpdate(RoomDTO roomDTO);
   RoomDTO findById(Long id);
   Boolean delete(Long id);
   RoomDTO findByName(String name);

   Boolean returnRoom(Long id);

   List<RoomDTO> getAll();
   List<RoomDTO> getAllByStatus();
}
