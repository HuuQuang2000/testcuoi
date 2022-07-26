package com.example.test_spring_boot.Controller;

import com.example.test_spring_boot.Dto.OrderDTO;
import com.example.test_spring_boot.Dto.RoomDTO;
import com.example.test_spring_boot.Service.CategoryService;
import com.example.test_spring_boot.Service.IOrderService;
import com.example.test_spring_boot.Service.IRoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;


@Controller
public class HomeController {
    @Autowired
    IRoomService iRoomService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    IOrderService iOrderService;

    @GetMapping("/")
    @Secured({"ROLE_ADMIN"})
    public String homePage(){
        return "/view_user/index";
    }

    @GetMapping("/Room/getAll")
    @Secured({"ROLE_ADMIN"})
    public String GetAll(Model model){
        model.addAttribute("listRoom",iRoomService.getAll());
        return "";
    }
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin/Room/getAll")
    public String adminGetAll(Model model){
        model.addAttribute("listRoom",iRoomService.getAll());
        model.addAttribute("listRoomStatus",iRoomService.getAllByStatus());
        model.addAttribute("listCategory",categoryService.getAll());


        return "/view_admin/room/index";
    }
    @Secured({"ROLE_ADMIN"})
    @PostMapping("/room/addOrUpdate")
    public String addOrUpdate(@ModelAttribute ("RoomDto")RoomDTO roomDTO, Model model){
        iRoomService.addOrUpdate(roomDTO);
        model.addAttribute("listCategory",categoryService.getAll());
        return "redirect:/admin/Room/getAll";
    }
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/room/formUpdate/{id}")
    public String formUpdate(Model model, @PathVariable("id") Long id){
        model.addAttribute("listCategory",categoryService.getAll());
        model.addAttribute("roomDto",iRoomService.findById(id));

        return "/view_admin/room/roomDetail";
    }
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/room/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        iRoomService.delete(id);
        return "redirect:/admin/Room/getAll";
    }
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/room/detail/{id}")
    public String detail(@PathVariable("id") Long id,Model model){
        model.addAttribute("roomDto",iRoomService.findById(id));
        return "/view_admin/room/roomDetail";
    }
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/room/return/{id}")
    public String returnRoom(@PathVariable("id") Long id,Model model){
        iRoomService.returnRoom(id);
        return "redirect:/admin/Room/getAll";
    }
    @Secured({"ROLE_ADMIN"})
    @PostMapping("/order/add")
    public String order(@ModelAttribute ("OrderDTO") OrderDTO orderDTO) throws ParseException {
        iOrderService.add(orderDTO);
        return "redirect:/admin/Room/getAll";
    }
    @Secured({"ROLE_ADMIN"})

    @GetMapping("/admin/order/getAll")
    public String adminGetAllOrder(Model model){
        model.addAttribute("listCategory",categoryService.getAll());
        model.addAttribute("listOrder",iOrderService.getAll());
        model.addAttribute("listCategory",categoryService.getAll());
        return "/view_admin/order/index";
    }
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/order/remove/{id}")
    public String removeOrder(@PathVariable("id") Long id) throws ParseException {
        iOrderService.delete(id);
        return "redirect:/admin/order/getAll";
    }
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/order/detail/{id}")
    public String detailOrder(@PathVariable("id") Long id,Model model) throws ParseException {
        model.addAttribute("orderDto",iOrderService.findById(id));
        return "/view_admin/order/orderDetail";
    }
}
