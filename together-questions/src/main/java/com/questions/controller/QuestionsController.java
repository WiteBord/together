package com.questions.controller;

import com.questions.dao.OptionsDao;
import com.questions.dto.QuestionsDto;
import com.questions.entity.OptionsEntity;
import com.questions.entity.QuesClassEntity;
import com.questions.service.QueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController {

    @Autowired
    OptionsDao optionsDao;

    @Autowired
    QueService queService;

    @GetMapping("/selectAllOptions")
    public List<OptionsEntity> getQuestions(){
        List<OptionsEntity> optionsList;
        optionsList=optionsDao.selectAll();
        return optionsList;
    }

    @GetMapping("/searchQues")//搜索
    public List<QuestionsDto> searchQues(String word,String queClassId){
        List<QuestionsDto> questionsList=new ArrayList<>();
        questionsList=queService.searchQuestion(word,queClassId);
        return questionsList;
    }



    @GetMapping("/getQuesClass")
    public List<QuesClassEntity> getQuesClass(){
        return queService.getQuesClass();
    }

}
