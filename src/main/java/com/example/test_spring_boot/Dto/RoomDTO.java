package com.example.test_spring_boot.Dto;


import com.example.test_spring_boot.Entity.CategoryEntity;
import com.example.test_spring_boot.Entity.RoomEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private Long id;
    private Integer status;
    private String name;
    private Double price;
    private CategoryDto categoryDto;
    private Integer type;
    private Long idCategory;

    public RoomDTO(RoomEntity roomEntity){
        this.id = roomEntity.getId();
        this.status = roomEntity.getStatus();
        this.name = roomEntity.getName();
        this.price = roomEntity.getPrice();
        if (roomEntity.getCategoryEntity() != null){
            this.categoryDto = new CategoryDto(roomEntity.getCategoryEntity());
        }
        this.type = roomEntity.getType();
    }
}
