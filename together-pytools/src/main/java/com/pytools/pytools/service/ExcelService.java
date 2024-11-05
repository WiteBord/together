package com.pytools.pytools.service;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface ExcelService {
    HashMap<String,List<List<String>>> readExcel(String filePath);
}
