package com.decagon.efashionplace.respository;



import com.decagon.efashionplace.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<UserInfo> findByUser(String email, String password);
    User save(User userInfo);
    List<User> findByEmail(String email);


}

