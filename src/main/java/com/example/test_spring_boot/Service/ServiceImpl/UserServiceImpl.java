package com.example.test_spring_boot.Service.ServiceImpl;

import com.example.test_spring_boot.Dto.UserDto;
import com.example.test_spring_boot.Entity.RoleEntity;
import com.example.test_spring_boot.Entity.UserEntity;
import com.example.test_spring_boot.Repository.RoleRepository;
import com.example.test_spring_boot.Repository.UserRepository;
import com.example.test_spring_boot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserEntity checkExistUserOauth(String username, String method ) {
               UserEntity u = null;
               if(userRepository.getByEmail(username) != null){
                   u = userRepository.getByEmail(username);
                  if(!u.getMethodLogin().contains(method) ){
                      return null;
                  }
               }else {
                   u = new UserEntity();
               }
               u.setUsername(username);
               u.setEmail(username);
               u.setMethodLogin(method);
               RoleEntity role = roleRepository.findById(2L).get();
               Set<RoleEntity> roleSet = new HashSet<>();
               roleSet.add(role);
               if(u.getRoles() != null && u.getRoles().size() > 0){
                   u.getRoles().clear();
               }
               u.setRoles(roleSet);
               u = userRepository.save(u);
               return u;
    }

    @Override
    public UserDto registerAcc(UserDto userDto, BCryptPasswordEncoder bCryptPasswordEncoder) {
        UserEntity userEntity = userRepository.getByUsername(userDto.getUsername());
        if(userEntity != null){
            return null;
        }
        else {
            userEntity = new UserEntity();
            userEntity.setUsername(userDto.getUsername());
            userEntity.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
            userEntity.setEmail(userDto.getEmail());
            RoleEntity role =roleRepository.findById(2L).get();
            Set<RoleEntity> roleEntities = new HashSet<>();
            roleEntities.add(role);
            userEntity.setRoles(roleEntities);
            userEntity.setFullname(userDto.getFullname());
            userEntity = userRepository.save(userEntity);
        }
        return new UserDto(userEntity);
    }

    @Override
    public UserDto updateAcc(UserDto userDto, BCryptPasswordEncoder bCryptPasswordEncoder) {
        UserEntity userEntity = userRepository.getById(userDto.getId());
        if(userDto.getPassword() != ""){
            userEntity.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        }
        userEntity.setEmail(userDto.getEmail());
        userEntity.setFullname(userDto.getFullname());
        return new UserDto(userRepository.save(userEntity));
    }
}
