package com.example.cartservice.external.repository;

import com.example.cartservice.domain.entities.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CardEntity, Long> {
}
