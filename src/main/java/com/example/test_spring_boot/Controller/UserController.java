package com.example.test_spring_boot.Controller;

import com.example.test_spring_boot.Dto.CategoryDto;
import com.example.test_spring_boot.Dto.UserDto;
import com.example.test_spring_boot.Entity.UserEntity;
import com.example.test_spring_boot.Repository.CategoryRepository;
import com.example.test_spring_boot.Repository.UserRepository;
import com.example.test_spring_boot.Service.MailService;
import com.example.test_spring_boot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/user")
@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MailService mailService;

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/manager_user")
    public String managerUser(Model model, HttpServletRequest request){
        List<UserDto> userDtoList = userRepository.findAll().stream().map(x-> new UserDto(x)).collect(Collectors.toList());
        model.addAttribute("lstUser", userDtoList);
        model.addAttribute("userDto", new UserDto());
        HttpSession session = request.getSession();
        String uzxc = session.getAttribute("nameUser").toString();
        model.addAttribute("nameUser", uzxc);
        List<CategoryDto> lstCategory = categoryRepository.getAllDto();
        model.addAttribute("categories",lstCategory);
        return "view_admin/user/index";
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/create_update_user")
    public String registerAccount(UserDto userDto ,Model model){
        userDto = userService.updateAcc(userDto, bCryptPasswordEncoder);
        List<CategoryDto> lstCategory = categoryRepository.getAllDto();
        model.addAttribute("categories",lstCategory);
        return "redirect:/user/manager_user";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/user_detail/{id}")
    public String user_detail(@PathVariable("id") Long id, Model model, HttpServletRequest request){
        model.addAttribute("userDto", new UserDto(userRepository.getById(id)));
        HttpSession session = request.getSession();
        String uzxc = session.getAttribute("nameUser").toString();
        model.addAttribute("nameUser", uzxc);
        List<CategoryDto> lstCategory = categoryRepository.getAllDto();
        model.addAttribute("categories",lstCategory);
        return "view_admin/user/user_detail";
    }

    @GetMapping("/remove_user/{id}")
    @Secured({"ROLE_ADMIN"})
    public String removeUser(@PathVariable("id") Long id){
        List<CategoryDto> lstCategory = categoryRepository.getAllDto();
        userRepository.deleteById(id);
        return "redirect:/user/manager_user";
    }
    @PostMapping("/sendMailResetPassWord")
    public String sendMailResetPassWord(@ModelAttribute UserDto userDto){
        int max = 10000;
        int min = 1;
        int range = max - min + 1;
        int token = (int)(Math.random() * range);
        UserEntity userEntity = userRepository.getByEmail(userDto.getEmail());

        if(userEntity != null){
            userEntity.setToken(token);
            userRepository.save(userEntity);
            mailService.resetPassWord(userDto.getEmail(),"Thông báo đăng ký lại mật khẩu",token);
            return "redirect:/";
        }else {
            return "redirect:/404";
        }
    }
    @GetMapping("/formEmail")
    public String formEmail(){
        return "/view_user/formEmail";
    }

    @GetMapping("/reset-password")
    public String formResetPassWord(@RequestParam("token") int token ,@RequestParam("email") String email,Model model){
        UserEntity userEntity = userRepository.getByEmailAndToken(email,token);
        model.addAttribute("userdto",new UserDto(userEntity));
        if(userEntity != null){
            return "/view_user/formResetPassWord";
        }else {
            return "redirect:/403";
        }
    }

    @PostMapping("/resetpassWord")
    public String formResetPassWord(UserDto userDto){
        UserEntity userEntity = userRepository.findById(userDto.getId()).get();
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userRepository.save(userEntity);
        return "redirect:/login";
    }
}
