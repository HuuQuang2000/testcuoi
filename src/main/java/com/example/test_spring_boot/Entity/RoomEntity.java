package com.example.test_spring_boot.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "tbl_room")
@AllArgsConstructor
@NoArgsConstructor
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer Status;
    private String name;
    private Double price;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CategoryEntity categoryEntity;
    private Integer active;
    private Integer type;
}
