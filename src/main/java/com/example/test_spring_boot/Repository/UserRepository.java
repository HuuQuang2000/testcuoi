package com.example.test_spring_boot.Repository;

import com.example.test_spring_boot.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("select u from UserEntity u where u.username = ?1")
    UserEntity getByUsername(String username);
    @Query("select u from UserEntity u where u.CreateBy = ?1")
    UserEntity getByCreateBy(String username);
    @Query("select u from UserEntity u where u.email like ?1")
    UserEntity getByEmail(String email);

    @Query("select u from UserEntity u where u.email like ?1 and u.token = ?2")
    UserEntity getByEmailAndToken(String email,int token);
}
