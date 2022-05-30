package com.example.test_spring_boot.Controller;


import com.example.test_spring_boot.Dto.CategoryDto;
import com.example.test_spring_boot.Dto.ReceiptDto;
import com.example.test_spring_boot.Dto.SearchDto.ResultDTO;
import com.example.test_spring_boot.Dto.SearchDto.SearchReportDto;
import com.example.test_spring_boot.Repository.CategoryRepository;
import com.example.test_spring_boot.Service.ServiceImpl.ProductHistoryServiceImpl;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/receipt")
public class ReceiptController {
    @Autowired
    ProductHistoryServiceImpl productHistoryService;
    @Autowired
    CategoryRepository categoryRepository;
    @PostMapping("/search_report_product")
    public ResponseEntity<?> searchPageReceipt(SearchReportDto searchReportDto, HttpServletResponse response){
        ResultDTO resultDTO = productHistoryService.searchReceipDto(searchReportDto,response);
        return ResponseEntity.ok(resultDTO);
    }
    @GetMapping("/index")
    public String home(Model model){
        List<CategoryDto> lstCategory = categoryRepository.getAllDto();
        model.addAttribute("categories",lstCategory);
        return "view_admin/report/Receipt-view";
    }

    @PostMapping("/export_report_by_search")
    public Workbook exportBySearchReport(Model model, SearchReportDto searchReportDto, HttpServletResponse response){
        ResultDTO resultDTO = productHistoryService.searchReceipDto(searchReportDto,response);
        return productHistoryService.exportBySearchDto(resultDTO.getReceiptDtos(), response);
    }

}
