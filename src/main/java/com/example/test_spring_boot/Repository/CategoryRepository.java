package com.example.test_spring_boot.Repository;

import com.example.test_spring_boot.Dto.CategoryDto;
import com.example.test_spring_boot.Entity.CategoryEntity;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Query("SELECT new com.example.test_spring_boot.Dto.CategoryDto(c) from CategoryEntity c")
    List<CategoryDto> getAllDto();
    @Query("select p from CategoryEntity p")
    Page<CategoryEntity> getAll(Pageable pageable);

    @Query("select p from CategoryEntity p where p.name like concat('%',:name,'%') ")
    Page<CategoryEntity> getAllByName(Pageable pageable,@Param("name") String name);
}
