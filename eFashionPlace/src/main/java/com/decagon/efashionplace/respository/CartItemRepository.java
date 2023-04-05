package com.decagon.efashionplace.respository;

import com.decagon.efashionplace.entity.CartItem;
import com.decagon.efashionplace.entity.Product;
import com.decagon.efashionplace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<Product,Long> {
//    public List<CartItem> findById(long id);
}
