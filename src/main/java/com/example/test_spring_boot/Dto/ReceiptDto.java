package com.example.test_spring_boot.Dto;

import com.example.test_spring_boot.Entity.ProductEntity;
import com.example.test_spring_boot.Entity.ProductHistory;
import com.example.test_spring_boot.Entity.ReceiptEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

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
    private Long id;
    private String phoneNumber;
    private String address;
    private Double priceShip;
    private Integer status;
    public ReceiptDto(ReceiptEntity receiptEntity){
        this.id = receiptEntity.getId();
        this.name = receiptEntity.getName();
        this.phoneNumber = receiptEntity.getPhoneNumber();
        this.address = receiptEntity.getAddress();
        this.status = receiptEntity.getStatus();
        this.createTime = new SimpleDateFormat("yyyy-MM-dd HH:ss").format(receiptEntity.getCreateDate());
        this.listProductDTO = receiptEntity.getProductHistorys().stream().map(x -> new ProductHistoryDto(x)).collect(Collectors.toList());
        this.priceShip = receiptEntity.getPriceShip();
        this.price = receiptEntity.getPriceShip();
        this.total = 0;
        for (ProductHistory p : receiptEntity.getProductHistorys()){
            this.price += p.getProductEntity().getPrice();
            this.total += p.getTotalItem();
        }
    }
}
