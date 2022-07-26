package com.example.test_spring_boot.Service.ServiceImpl;


import com.example.test_spring_boot.Dto.RoomDTO;
import com.example.test_spring_boot.Entity.CategoryEntity;
import com.example.test_spring_boot.Entity.RoomEntity;
import com.example.test_spring_boot.Repository.CategoryRepository;
import com.example.test_spring_boot.Repository.RoomRepository;
import com.example.test_spring_boot.Service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public RoomDTO addOrUpdate(RoomDTO roomDTO) {
        RoomEntity roomEntity = null;
        if (roomDTO.getId() != null){
            roomEntity = roomRepository.findById(roomDTO.getId()).orElse(null);
        }else {
            roomEntity = new RoomEntity();
        }

        roomEntity.setName(roomDTO.getName());
        roomEntity.setActive(1);
        roomEntity.setPrice(roomDTO.getPrice());
        roomEntity.setType(1);
        roomEntity.setStatus(1);
        if (roomDTO.getIdCategory() != null ){
            CategoryEntity categoryEntity = categoryRepository.findById(roomDTO.getIdCategory()).orElse(null);
            roomEntity.setCategoryEntity(categoryEntity);
        }
        RoomEntity roomEntity1 = roomRepository.save(roomEntity);
        return new RoomDTO(roomEntity1);
    }

    @Override
    public RoomDTO findById(Long id) {
        RoomEntity roomEntity = roomRepository.findById(id).orElse(null);
        RoomDTO roomDTO = new RoomDTO();
        if (roomEntity != null){
            roomDTO = new RoomDTO(roomEntity);
        }
        return roomDTO;
    }

    @Override
    public Boolean delete(Long id) {
        RoomEntity roomEntity = roomRepository.findById(id).orElse(null);
        if (roomEntity != null){
            roomEntity.setActive(0);
            roomRepository.save(roomEntity);
            return true;
        }else {
            return false;
        }
    }
    @Override
    public RoomDTO findByName(String name) {
        return null;
    }

    @Override
    public Boolean returnRoom(Long id) {
        RoomEntity roomEntity = roomRepository.findById(id).orElse(null);
        RoomDTO roomDTO = new RoomDTO();
        if (roomEntity != null){
            roomEntity.setStatus(1);

            roomDTO = new RoomDTO(roomRepository.save(roomEntity));
            return true;
        }else {
            return false;
        }

    }

    @Override
    public List<RoomDTO> getAll() {
        return roomRepository.getAllDto();
    }

    @Override
    public List<RoomDTO> getAllByStatus() {
        return roomRepository.getAllDtoByStatus(1);
    }
}
