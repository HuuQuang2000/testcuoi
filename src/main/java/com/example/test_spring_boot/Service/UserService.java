package com.example.test_spring_boot.Service;

import com.example.test_spring_boot.Dto.UserDto;
import com.example.test_spring_boot.Entity.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;

public interface UserService {
    UserEntity checkExistUserOauth(String email, String method,String username);
    UserDto registerAcc(UserDto userDto, BCryptPasswordEncoder bCryptPasswordEncoder);
    UserDto updateAcc(UserDto userDto, BCryptPasswordEncoder bCryptPasswordEncoder);
}
