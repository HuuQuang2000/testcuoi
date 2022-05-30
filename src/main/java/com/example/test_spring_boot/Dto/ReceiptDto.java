package com.example.test_spring_boot.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceiptDto {
    private List<ProductHistoryDto> listProductDTO;
    private Double price;
    private int total;
    private String name;
    private String createTime;
}
