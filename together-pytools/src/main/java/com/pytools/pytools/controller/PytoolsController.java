package com.pytools.pytools.controller;


import com.pytools.pytools.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/pytools")
public class PytoolsController {

    @Autowired
    ExcelService excelService;

    @PostMapping("/readExcel")
    public HashMap<String,List<List<String>>> addQuesClass(){
        return excelService.readExcel("C:\\Users\\hejunlin\\Desktop\\aaa.xlsx");
    }


}
