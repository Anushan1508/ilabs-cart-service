package com.example.cartservice.external.repository;

import com.example.cartservice.domain.entities.CardEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CardEntity, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM CardEntity c WHERE c.cartItem = :item")
    int  deleteByCartItem(@Param("item") String item);
}
