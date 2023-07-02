package com.likelion.test.demo.repository;

import com.likelion.test.demo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select r from Car r where r.user.id = :userId")
    List<Car> findAllByUserId(Long userId);
}
