package com.example.test_spring_boot.Repository;

import com.example.test_spring_boot.Dto.ReceiptDto;
import com.example.test_spring_boot.Entity.ReceiptEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReceiptRepository extends JpaRepository<ReceiptEntity, Long> {

    @Query("select new com.example.test_spring_boot.Dto.ReceiptDto(r) from ReceiptEntity r ")
    List<ReceiptDto> getAll();
    @Query("select r from ReceiptEntity r where r.name like concat('%',?1,'%') and r.CreateDate > ?2 and r.CreateDate < ?3 ")
    Page<ReceiptEntity> pageSearchByAll(String name ,Date fromDate,Date toDate ,  Pageable pageable);
    @Query("select r from ReceiptEntity r where r.name like concat('%',?1,'%')")
    Page<ReceiptEntity> pageSearchByTextSearch(String name ,Pageable pageable);
    @Query("select new com.example.test_spring_boot.Dto.ReceiptDto(r) from ReceiptEntity r where r.name like concat('%',?1,'%')")
    List<ReceiptDto> listSearchByName(String name);

    @Query("select new com.example.test_spring_boot.Dto.ReceiptDto(r) from ReceiptEntity r where r.name like concat('%',?1,'%') and r.CreateDate > ?2 and r.CreateDate < ?3 ")
    List<ReceiptDto> listSearchByAll(String name ,Date fromDate,Date toDate);

    @Query("select r from ReceiptEntity r")
    Page<ReceiptEntity> pageSearch(Pageable pageable);


}
