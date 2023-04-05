package com.decagon.eshop.repository;



import com.decagon.eshop.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
//    Optional<UserInfo> findByUser(String email, String password);

    UserInfo save(UserInfo userInfo);

}

