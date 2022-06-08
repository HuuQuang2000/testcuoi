package com.example.test_spring_boot.Controller;


import com.example.test_spring_boot.Dto.CategoryDto;
import com.example.test_spring_boot.Dto.ReceiptDto;
import com.example.test_spring_boot.Dto.SearchDto.ResultDTO;
import com.example.test_spring_boot.Dto.SearchDto.SearchReportDto;
import com.example.test_spring_boot.Dto.UserDto;
import com.example.test_spring_boot.Entity.UserEntity;
import com.example.test_spring_boot.Repository.CategoryRepository;
import com.example.test_spring_boot.Repository.UserRepository;
import com.example.test_spring_boot.Service.ReceiptService;
import com.example.test_spring_boot.Service.ServiceImpl.ProductHistoryServiceImpl;
import com.example.test_spring_boot.Service.UserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/receipt")
public class ReceiptController {
    @Autowired
    ProductHistoryServiceImpl productHistoryService;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ReceiptService receiptService;
    @Autowired
    UserRepository userService;
    @PostMapping("/search_report_product")
    public ResponseEntity<?> searchPageReceipt(SearchReportDto searchReportDto, HttpServletResponse response){
        Page<ReceiptDto> resultDTO = receiptService.searchByDto(searchReportDto);
        return ResponseEntity.ok(resultDTO);
    }
    @GetMapping("/status/{id}")
    @Secured({"ROLE_ADMIN"})
    public String home(Model model, @PathVariable("id") Long id,HttpServletRequest request){
        List<CategoryDto> lstCategory = categoryRepository.getAllDto();
        model.addAttribute("categories",lstCategory);
        receiptService.setActiveByTime();
        String url = "view_admin/report/Receipt-susscess-view";
        if(id == 3){
            url = "view_admin/report/Receipt-pending-ship-view";
        }else if(id==4){
            url = "view_admin/report/Receipt-pending-pay-view";
        }else if (id==2){
            url="view_admin/report/Receipt-pending-confirm-view";
        }else if (id==5){
            url="view_admin/report/Receipt-Detroy-view";
        }
        HttpSession session = request.getSession();
        String uzxc = session.getAttribute("nameUser").toString();
        model.addAttribute("nameUser", uzxc);
        return url;
    }
    @PostMapping("/export_report_by_search")
    public Workbook exportBySearchReport(Model model, SearchReportDto searchReportDto, HttpServletResponse response){
       List<ReceiptDto> resultDTO = receiptService.searchPageByDto(searchReportDto);
        return productHistoryService.exportBySearchDto(resultDTO, response);
    }

    @PostMapping("/detail")
    @Secured({"ROLE_ADMIN"})
    public String detail(Model model, ReceiptDto receiptDto){
        ReceiptDto r = receiptService.findById(receiptDto.getId());
        List<CategoryDto> lstCategory = categoryRepository.getAllDto();
        model.addAttribute("receipt",r);
        model.addAttribute("categories",lstCategory);
        return "view_admin/report/detail-view";
    }
    @PostMapping("/user/detail")
    public String userDetail(Model model, ReceiptDto receiptDto , HttpServletRequest request){
        ReceiptDto r = receiptService.findById(receiptDto.getId());
        List<CategoryDto> lstCategory = categoryRepository.getAllDto();
        model.addAttribute("receipt",r);
        model.addAttribute("categories",lstCategory);
        HttpSession session = request.getSession();
        String uzxc = session.getAttribute("nameUser").toString();
        model.addAttribute("nameUser", uzxc);
        return "view_user/receiptDetail";
    }
    @PostMapping("/delete")
    @Secured({"ROLE_ADMIN"})
    public String deleteById(Model model, ReceiptDto receiptDto,HttpServletRequest request) throws IOException {
        receiptService.changStatus(receiptDto.getId(), 5);
        return "redirect:/receipt/status/"+receiptService.findById(receiptDto.getId()).getStatus();
    }
    @PostMapping("/ship")
    @Secured({"ROLE_ADMIN"})
    public String ship(Model model, ReceiptDto receiptDto,HttpServletRequest request) throws IOException {
        receiptService.changStatus(receiptDto.getId(), 3);
        HttpSession session = request.getSession();
        String uzxc = session.getAttribute("nameUser").toString();
        model.addAttribute("nameUser", uzxc);
        return "redirect:/receipt/status/3";
    }
    @PostMapping("/pay")
    @Secured({"ROLE_ADMIN"})
    public String pay(Model model, ReceiptDto receiptDto ,HttpServletRequest request) throws IOException {
        receiptService.changStatus(receiptDto.getId(), 1);
        HttpSession session = request.getSession();
        String uzxc = session.getAttribute("nameUser").toString();
        model.addAttribute("nameUser", uzxc);
        return "redirect:/receipt/status/1";
    }

    @GetMapping ("/user")
    public String userReceipt(Model model, @RequestParam("username") String username, HttpSession session) throws IOException {
       UserDto userDto = new UserDto(userService.getByUsername(username));

       List<ReceiptDto> list = receiptService.getAll();
       for (int i =0 ; i < list.size() ; i ++){
           if(!list.get(i).getListProductDTO().get(0).getUsername().contains(username) && list.get(i).getListProductDTO() != null ){
               list.remove(list.get(i));
           };
       }

       session.setAttribute("nameUser",username);
       model.addAttribute("listReceipt",list);
        return "view_user/receipt";
    }
}
