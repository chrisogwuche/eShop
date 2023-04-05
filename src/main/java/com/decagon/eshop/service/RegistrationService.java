package com.decagon.eshop.service;

import com.decagon.eshop.Model.UserInfo;
import com.decagon.eshop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RegistrationService {

    UserRepository userRepository;

    public Integer register(UserInfo userInfo) {
        List<UserInfo> UserInfoList =  new ArrayList<>();
        UserInfoList.add(userRepository.save(userInfo));
        return UserInfoList.size();
    }
}
