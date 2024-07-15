package com.pytools.pytools.serviceImpl;

import com.pytools.pytools.service.OfficeService;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.stereotype.Service;

@Service
public class OfficeServiceImpl implements OfficeService {
    @Override
    public HashMap<String,List<List<String>>> readExcel(String filePath) {
        HashMap<String,List<List<String>>> xlsMap=new HashMap<>();

        try {
            FileInputStream files = new FileInputStream(filePath);
            // 创建工作簿对象
            Workbook wb = new XSSFWorkbook(files);
            int sheetsNum = wb.getNumberOfSheets();//sheet数量

            for (int i = 0; i < sheetsNum; i++) {
                //获取Sheet对象
                XSSFSheet sheet = (XSSFSheet) wb.getSheetAt(i);
                //获取该sheet的总行数
                int rowNum = sheet.getLastRowNum();
                //获取sheet名称
                String stName=sheet.getSheetName();
                List<List<String>> dataList=new ArrayList<>();
                for (int j = 0; j <= rowNum; j++) {
                    List<String> rowDataList =new ArrayList<>();
                    //获取行对象row
                    XSSFRow row = sheet.getRow(j);
                    //获取每行的单元格数
                    int cellNum=0;//需要跳过空行
                    if(Objects.nonNull(row)){
                        cellNum = row.getLastCellNum();
                    }
                    for (int k = 0; k < cellNum; k++) {
                        //获取单元格对象
                        XSSFCell cell = row.getCell(k);
                        //根据单元格数据类型进行取值
                        String stringValue = cell.toString();
                        rowDataList.add(stringValue);
                    }
                    dataList.add(rowDataList);
                }
                xlsMap.put(stName,dataList);
            }

        }catch (IOException io){
            io.printStackTrace();
        }
        return xlsMap;

    }






}
