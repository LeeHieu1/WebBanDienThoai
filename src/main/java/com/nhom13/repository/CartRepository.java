package com.nhom13.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nhom13.model.Cart;
import com.nhom13.model.pk.CartPK;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartPK> {

    @Query(value = "Select * from cart where user_id = :user_id", nativeQuery = true)
    List<Cart> findByUserId(@Param("user_id") Long user_id);
}
