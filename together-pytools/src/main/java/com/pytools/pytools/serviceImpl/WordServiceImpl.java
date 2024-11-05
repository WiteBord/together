package com.pytools.pytools.serviceImpl;

import com.pytools.pytools.service.WordService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class WordServiceImpl implements WordService {

    @Override
    public void readWord(String filePath) {
        try {
            FileInputStream files = new FileInputStream(filePath);
            // 创建工作簿对象
            XWPFDocument wb = new XWPFDocument(files);











        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
